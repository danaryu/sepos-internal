package com.sinc.sepos.internal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReportMessageDTO {
    // 점포명
    private String strNm;
    // 점포구분 05: Nobrand
    private String strType;
    // 점포 X좌표
    private String strX;
    // 점포 Y좌표
    private String strY;
    // 점포 신규주소
    private String strNewAddr;
    // 점포 구주소
    private String strOldAddr;
    // 점포 상세주소
    private String strDtlsAddr;
    // 점포 전화번호
    private String strTelNo;
    //신고 내용
    private String rptCnts;
    //신고 일시
    private String strSendDm = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
}

