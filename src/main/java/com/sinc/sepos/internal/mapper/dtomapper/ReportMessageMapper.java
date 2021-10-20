package com.sinc.sepos.internal.mapper.dtomapper;

import com.sinc.sepos.internal.dto.ReportDTO;
import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.entity.ReportMessage;
import com.sinc.sepos.internal.entity.ReportTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMessageMapper {

    ReportMessageMapper INSTANCE = Mappers.getMapper(ReportMessageMapper.class);

    // TODO Store로 바꾸기. || reportDTO로 바꾸기 ?
    @Mapping(source = "reportTemplate.reportCnts", target = "rptCnts")
    ReportMessage toReportMessage(StoreDTO storeDTO, ReportTemplate reportTemplate);
/*
    // 점포명
    private String storeNm;
    // 점포구분 05: Nobrand
    private String storeType;
    // 점포 X좌표
    private String storeX;
    // 점포 Y좌표
    private String storeY;
    // 점포 신규주소
    private String storeNewAddr;
    // 점포 구주소
    private String storeOldAddr;
    // 점포 상세주소
    private String storeDtlsAddr;
    // 점포 전화번호
    private String storeTelNo;
    //신고 내용
    private String rptCnts;
    //신고 일시
    private LocalDateTime storeSendDm = LocalDateTime.now();
    */
}
