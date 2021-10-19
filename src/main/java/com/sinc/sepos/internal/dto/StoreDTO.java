package com.sinc.sepos.internal.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class StoreDTO {
    // pos점포코드
    private String posStrCode;
    // 영업점포코드
    private String strCode;
    // 점포명
    private String strNm;
    // 업태코드
    private String biztpCode;
    // 점포구분 05: Nobrand
    private String storeType;
    // 서버 IP
    private String svrIpAddr;
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
    // 점포 전화번호 (지역)
    private String strTano;
    // 점포 전화번호
    private String strTeno;
    // 점포 전화번호
    private String strTsno;
}
