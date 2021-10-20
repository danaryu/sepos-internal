package com.sinc.sepos.internal.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Store {
    // pos점포코드
    private final String posStrCode;
    // 영업점포코드
    private final String strCode;
    // 점포명
    private final String strNm;
    // 업태코드
    private final String biztpCode;
    // 점포구분 05: Nobrand
    private final String storeType;
    // 서버 IP
    private final String svrIpAddr;
    // 점포 X좌표
    private final String strX;
    // 점포 Y좌표
    private final String strY;
    // 점포 신규주소
    private final String strNewAddr;
    // 점포 구주소
    private final String strOldAddr;
    // 점포 상세주소
    private final String strDtlsAddr;
    // 점포 전화번호 (지역)
    private final String strTano;
    // 점포 전화번호
    private final String strTeno;
    // 점포 전화번호
    private final String strTsno;
}
