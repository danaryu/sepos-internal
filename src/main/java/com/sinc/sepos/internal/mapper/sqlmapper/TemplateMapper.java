package com.sinc.sepos.internal.mapper.sqlmapper;

import com.sinc.sepos.internal.entity.ReportTemplate;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TemplateMapper {
    ReportTemplate findBasicTemplate();
}
