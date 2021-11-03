package com.sinc.sepos.internal.mapper.dtomapper;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.entity.ReportTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportMessageMapper {

    ReportMessageMapper INSTANCE = Mappers.getMapper(ReportMessageMapper.class);

    /**
     * storeDTO와 reportTemplate을 받아 reportMessage를 생성한다.
     * @param storeDTO
     * @param reportTemplate
     * @return
     */

    @Mapping(source = "reportTemplate.reportCnts", target = "rptCnts")
    @Mapping(source = "storeDTO.strNm", target = "storeNm")
    @Mapping(source = "storeDTO.strType", target = "storeType")
    @Mapping(source = "storeDTO.strX", target = "storeX")
    @Mapping(source = "storeDTO.strY", target = "storeY")
    @Mapping(source = "storeDTO.strNewAddr", target = "storeNewAddr")
    @Mapping(source = "storeDTO.strOldAddr", target = "storeOldAddr")
    @Mapping(source = "storeDTO.strDtlsAddr", target = "storeDtlsAddr")
    @Mapping(source = "storeDTO.strTelNo", target = "storeTelNo")
    ReportMessageDTO toReportMessage(StoreDTO storeDTO, ReportTemplate reportTemplate);

}
