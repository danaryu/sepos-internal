package com.sinc.sepos.internal.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StoreDTO {
    // TODO table 컬럼명 바꿔야함.. str도있고 store도 있고
    // pos점포코드
    private String posStrCode;
    // 영업점포코드
    private String strCode;
    // 점포명
    private String strNm;
    // 업태코드
    private String biztpCode;
    // 점포구분 05: Nobrand
    private String strType;
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
    // 점포 전화번호
    private String strTelNo;
}
