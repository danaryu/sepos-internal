package com.sinc.sepos.internal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReportLogDTO {
    private String bizDate;
    private String posStrCode;
    private String posNo;
    private String posRcvIp;
    private String workSeq;
    private String crtnDt;
    private String crtnId;
    private String chgDt;
    private String chgId;

    private String resDt;
    private String resMsg;
    private String resCd;

    private String errCd;
    private String errCnt;

    private String sendDt;
    private String sendMsg;
    private String sendStat;
}
