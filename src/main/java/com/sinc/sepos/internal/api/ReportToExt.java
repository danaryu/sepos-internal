package com.sinc.sepos.internal.api;

import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.sinc.sepos.internal.common.exception.TempConnectionFailException;
import com.sinc.sepos.internal.common.response.BaseResponse;
import com.sinc.sepos.internal.common.response.ErrorCode;
import com.sinc.sepos.internal.configuration.ConstantsConfiguration;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;


@Slf4j
@Component
@RequiredArgsConstructor
public class ReportToExt {

    private final RestTemplate restTemplate;
    private final ConstantsConfiguration constConfig;

    /**
     * 내부망 -> 외부망으로 신고메세지를 전송한다.
     * 내부망 API Server internal Error 인 경우, retry.maxDelay 간격으로 retry.maxAttempts만큼 재시도한다.
     *
     * @param reportMessageDTO
     * @return ResponseEntity
     * @throws Exception
     * @Author Dana Ryu
    */

    @Retryable(maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"),
            value = HttpServerErrorException.class)
    public ResponseEntity<BaseResponse> report(ReportMessageDTO reportMessageDTO) throws Exception {

        System.out.println("reportMessageDTO = " + reportMessageDTO.toString());

        /* 외부망 호출 */
        String extUrl = constConfig.getExtUrl();
        ResponseEntity<BaseResponse> responseEntity = restTemplate.postForEntity(extUrl, reportMessageDTO, BaseResponse.class);

        /* Server 통신 결과 값 Check */
        BaseResponse baseResponse = responseEntity.getBody();
        if (responseEntity.getStatusCode().is5xxServerError() || baseResponse.getMessage().isBlank() || baseResponse.getCode().isBlank()) {
            log.error("### 외부망 API서버가 정상 응답하지 않습니다. ###");
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        /* 응답 */
        return responseEntity;
    }

    /**
     * RetryMethod(@Retryable)를 실행 후, 정해진 시도 횟수에도 실패하면 recover 응답을 생성한다.
     *
     * @param @Retryable 대상 method와 동일한 parameter input
     * @Return ResponseEntity<String>
     * @Author DANA Ryu
    */

    @Recover
    private ResponseEntity<ResponseDTO> recover(HttpServerErrorException e, ReportMessageDTO reportMessageDTO) throws TempConnectionFailException {
        return new ResponseEntity(new BaseResponse(ErrorCode.TEMPORARY_CONNECT_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
