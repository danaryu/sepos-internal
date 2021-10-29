package com.sinc.sepos.internal.controller;

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
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.lang.invoke.ConstantBootstraps;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReportController {

    /**
     * POS로부터 전달받은 점포/POS번호를 Mapping하여, 비상벨 신고 내용을 외부망으로 전송한다.
     * @return ResponseEntity
     */

    private final RestTemplate restTemplate;
    private final ReportService reportService;
    private final LogService logService;
    private final ConstantsConfiguration constConfig;

    /* private final ReportToExt reportToExt; */

    @ResponseBody
    @PostMapping("/knpa/report")
    public ResponseEntity reportToExt(@RequestBody @Valid PosInfoDTO posInfoDTO) {

        /* POS서버 -> 내부망 */
        System.out.println("posInfoDTO.toString() = " + posInfoDTO.toString());
        // log.debug("posInfoDTO.toString()" + posInfoDTO.toString());

        /* 점포코드에 해당하는 주소조회 */
        StoreDTO storeDTO = reportService.findStrByPosStrCode(posInfoDTO.getPosStrCode());

        /* Report 생성 */
        ReportMessageDTO reportMessageDTO = reportService.makeReport(storeDTO);

        /* 요청 log 저장 */
        ReportLogDTO requestLog = makeRequestLog(posInfoDTO, reportMessageDTO);
        logService.insertReportLog(requestLog);

        /* Report 외부망 호출 */
        // reportToExt.report(restTemplate, storeService.report(store));


        /* 응답 log 저장 */

        return new ResponseEntity("hello", HttpStatus.OK);
    }

    /**
     * 신고 요청에 대한 Log를 생성한다.
     *
     *   sequence 번호 생성 POS점포코드 + POS번호 + localDateTime
     *   외부망 전송상태 SEND_STAT = 'N'
     *
     * @param posInfoDTO
     * @return
     */

    private ReportLogDTO makeRequestLog(PosInfoDTO posInfoDTO, ReportMessageDTO reportMessageDTO) {
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHss"));
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


}
