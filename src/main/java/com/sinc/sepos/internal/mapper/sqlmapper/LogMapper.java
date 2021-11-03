package com.sinc.sepos.internal.mapper.sqlmapper;

import com.sinc.sepos.internal.dto.ReportLogDTO;
import com.sinc.sepos.internal.entity.ReportLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    void insertRequestLog(ReportLog log);
    void updateResponseLog(ReportLog log);
}
