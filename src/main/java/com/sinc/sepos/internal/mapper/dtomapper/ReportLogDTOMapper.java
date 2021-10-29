package com.sinc.sepos.internal.mapper.dtomapper;

import com.sinc.sepos.internal.dto.ReportLogDTO;
import com.sinc.sepos.internal.entity.ReportLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportLogDTOMapper {
    ReportLogDTOMapper INSTANCE = Mappers.getMapper(ReportLogDTOMapper.class);
    ReportLog toEntity(ReportLogDTO reportLogDTO);
}


