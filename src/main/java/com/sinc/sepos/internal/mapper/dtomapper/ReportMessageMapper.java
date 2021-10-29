package com.sinc.sepos.internal.mapper.dtomapper;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.entity.ReportTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

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
    ReportMessageDTO toReportMessage(StoreDTO storeDTO, ReportTemplate reportTemplate);

}
