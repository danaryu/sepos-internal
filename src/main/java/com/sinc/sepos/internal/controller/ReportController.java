package com.sinc.sepos.internal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinc.sepos.internal.api.ReportToExt;
import com.sinc.sepos.internal.common.response.BaseResponse;
import com.sinc.sepos.internal.common.response.SuccessCode;
import com.sinc.sepos.internal.configuration.ConstantsConfiguration;
import com.sinc.sepos.internal.dto.*;
import com.sinc.sepos.internal.service.LogService;
import com.sinc.sepos.internal.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReportController {

    /**
     * POS로부터 전달받은 점포/POS번호/POS IP를 Mapping 하여, 비상벨 신고 내용을 외부망으로 전송한다.
     * @Param posInfoDTO
     * @return ResponseEntity
     */

    private final ReportService reportService;
    private final LogService logService;
    private final ConstantsConfiguration constConfig;
    private final ReportToExt reportToExt;

    @ResponseBody
    @PostMapping("/knpa/report")
    public ResponseEntity<BaseResponse> reportToExt(@RequestBody @Valid PosInfoDTO posInfoDTO) throws Exception {

        /* 점포코드에 해당하는 주소조회 */
        StoreDTO storeDTO = reportService.findStrByPosStrCode(posInfoDTO.getPosStrCode());

        /* Report 생성 */
        ReportMessageDTO reportMessageDTO = reportService.makeReport(storeDTO);
        System.out.println("reportMessageDTO = " + reportMessageDTO.toString());

        /* 요청 log 저장 */
        ReportLogDTO reportLog = makeRequestLog(posInfoDTO, reportMessageDTO);
        System.out.println("reportLog = " + reportLog.toString());
        logService.insertRequestLog(reportLog);

        /* Report 외부망 호출 */
        System.out.println("reportMessageDTO.toString() = " + reportMessageDTO.toString());
        ResponseEntity<BaseResponse> response = reportToExt.report(reportMessageDTO);

        /* 응답 log 저장 */
        ReportLogDTO responseLog = makeResponseLog(reportLog, response);
        System.out.println("responseLog.toString() = " + responseLog.toString());
        logService.updateResponseLog(responseLog);

        return response;
    }

    /**
     * 신고 요청에 대한 Log를 생성한다.
     *
     *   sequence 번호 생성 POS점포코드 + POS번호 + localDateTime
     *   외부망 전송상태 SEND_STAT = 'N'
     *
     * @param posInfoDTO, reportMessageDTO
     * @return ReportLogDTO
     */

    private ReportLogDTO makeRequestLog(PosInfoDTO posInfoDTO, ReportMessageDTO reportMessageDTO) {

        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String workSequence = new StringBuilder(posInfoDTO.getPosStrCode())
                .append(posInfoDTO.getPosNo())
                .append(localDateTime)
                .toString();
        String bizDate = localDateTime.substring(0, 8);

        ReportLogDTO reportLogDTO = new ReportLogDTO();
        reportLogDTO.setBizDate(bizDate);
        reportLogDTO.setPosStrCode(posInfoDTO.getPosStrCode());
        reportLogDTO.setPosNo(posInfoDTO.getPosNo());
        reportLogDTO.setPosRcvIp(posInfoDTO.getPosRcvIp());
        reportLogDTO.setWorkSeq(workSequence);

        reportLogDTO.setSendMsg(reportMessageDTO.toString());
        reportLogDTO.setSendStat(constConfig.getRequestSendStat());
        reportLogDTO.setSendDt(localDateTime);

        reportLogDTO.setCrtnId(constConfig.getRequestCreateId());
        reportLogDTO.setChgId(constConfig.getRequestChangeId());

        return reportLogDTO;
    }

    /**
     * 신고 요청에 대한 응답 Log 객체를 생성한다.
     *   sequence 번호에 대한 응답 Log Update
     *
     * @param reportLog, response
     * @return ReportLogDTO
     */

    public ReportLogDTO makeResponseLog(ReportLogDTO reportLog, ResponseEntity<BaseResponse> response) throws JsonProcessingException {
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        BaseResponse baseResponse = response.getBody();
        reportLog.setChgId(constConfig.getResponseChangeId());

        reportLog.setResDt(localDateTime);

        reportLog.setResStat(String.valueOf(response.getStatusCodeValue()));
        reportLog.setResMsg(baseResponse.getMessage());
        reportLog.setResCd(baseResponse.getCode());

        // Error인 경우, Table Insert error 처리
        if(baseResponse.getCode().equals("S0000")) {
            reportLog.setSendStat(constConfig.getErrorSendStat());
        }

        reportLog.setSendStat(constConfig.getResponseSendStat());
        return reportLog;
    }


}
