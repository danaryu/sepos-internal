package com.sinc.sepos.internal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sinc.sepos.internal.common.utils.PosUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReportMessageDTO {

    // 점포명
    @JsonProperty("store_nm")
    private String storeNm;

    // 점포구분 05: Nobrand
    @JsonProperty("store_type")
    private String storeType;

    // 점포 X좌표
    @JsonProperty("store_x")
    private String storeX;

    // 점포 Y좌표
    @JsonProperty("store_y")
    private String storeY;

    // 점포 신규주소
    @JsonProperty("store_new_addr")
    private String storeNewAddr;

    // 점포 구주소
    @JsonProperty("store_old_addr")
    private String storeOldAddr;

    // 점포 상세주소
    @JsonProperty("store_dtls_addr")
    private String storeDtlsAddr;

    // 점포 전화번호
    @JsonProperty("store_tel_no")
    private String storeTelNo;

    //신고 내용
    @JsonProperty("rpt_cnts")
    private String rptCnts;

    //신고 일시
    @JsonProperty("store_send_dm")
    private String storeSendDm = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));


    /**
     * reportTemplate encoding
     * @param reportMessageDTO
     * @return ReportTemplate
     * @throws UnsupportedEncodingException
     */

    public ReportMessageDTO encodingReport(ReportMessageDTO reportMessageDTO) throws UnsupportedEncodingException {
        reportMessageDTO.setStoreNm(PosUtil.EncodingToKR(reportMessageDTO.getStoreNm()));
        reportMessageDTO.setStoreOldAddr(PosUtil.EncodingToKR(reportMessageDTO.getStoreOldAddr()));
        reportMessageDTO.setStoreNewAddr(PosUtil.EncodingToKR(reportMessageDTO.getStoreNewAddr()));
        reportMessageDTO.setStoreDtlsAddr(PosUtil.EncodingToKR(reportMessageDTO.getStoreDtlsAddr()));
        reportMessageDTO.setRptCnts(PosUtil.EncodingToKR(reportMessageDTO.getRptCnts()));
        return reportMessageDTO;
    }


}

