package com.sinc.sepos.internal.common.advice;

import com.sinc.sepos.internal.common.exception.TempConnectionFailException;
import com.sinc.sepos.internal.common.response.BaseResponse;
import com.sinc.sepos.internal.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    /**
     * 외부망 서버와 일시적 통신 실패 에러
     *  HttpStatusCode 500Error
     *
     * @Param e
     * @Return ResponseEntity<BaseResponse>
     */

    @ExceptionHandler(TempConnectionFailException.class)
    public ResponseEntity<BaseResponse> temporaryConnectionFailHandler(TempConnectionFailException e) {
        BaseResponse baseResponse = BaseResponse.of(ErrorCode.TEMPORARY_CONNECT_ERROR);

        log.error("### temporaryConnectionFailHandler : " + e.getMessage());
        baseResponse.setMessage(e.getMessage() + baseResponse.getMessage());

        // 내부망 -> POS서버 통신은 정상이므로, HttpStatus
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    //JsonProcessingException

}
