package com.sinc.sepos.internal.controller;

import com.sinc.sepos.internal.dto.PosInfoDTO;
import com.sinc.sepos.internal.dto.StoreDTO;
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

    @ResponseBody
    @PostMapping("/knpa/report")
    public ResponseEntity reportToExt(@RequestBody @Valid PosInfoDTO posInfoDTO) {

        /* POS서버 -> 내부망 */
        System.out.println("posInfoDTO.toString() = " + posInfoDTO.toString());
        // log.debug("posInfoDTO.toString()" + posInfoDTO.toString());

        /* log 저장 */

        /* 점포코드에 해당하는 주소조회 */
        StoreDTO storeDTO = reportService.findStrByPosStrCode(posInfoDTO.getPosStrCode());
        System.out.println("storeDTO = " + storeDTO.toString());

        /* 외부망 호출 */


        /* 응답 */
        return new ResponseEntity("hello", HttpStatus.OK);
    }


}
