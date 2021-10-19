package com.sinc.sepos.internal.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ReportToExt {

    /**
     * 내부망 -> 외부망 비상벨 신고
     * @param restTemplate
     * @return
     */
    public ResponseEntity reportToExt(RestTemplate restTemplate) {
        //restTemplate.exchange("127.0.0.1:8080/knpa/report", HttpMethod.POST, String.class);

        // restTemplate.exchange("127.0.0.1:8080/knpa/report", HttpMethod.POST, new ResponseEntity(HttpStatus.OK), String.class);

        return new ResponseEntity(HttpStatus.OK);
    }

}
