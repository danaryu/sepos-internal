package com.sinc.sepos.internal.dto;

import com.sinc.sepos.internal.common.utils.PosUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.UnsupportedEncodingException;

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
    private String resStat;

/*
    private String errCd;
    private String errMsg;
*/

    private String sendDt;
    private String sendMsg;
    private String sendStat;

    public ReportLogDTO encodingRequestLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        reportLogDTO.setSendMsg(PosUtil.EncodingToEN(reportLogDTO.getSendMsg()));
        return reportLogDTO;
    }

    public ReportLogDTO encodingResponseLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        reportLogDTO.setResMsg(PosUtil.EncodingToEN(reportLogDTO.getResMsg()));
        return reportLogDTO;
    }

}
