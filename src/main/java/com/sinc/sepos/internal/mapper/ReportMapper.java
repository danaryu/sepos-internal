package com.sinc.sepos.internal.mapper;

import com.sinc.sepos.internal.dto.StoreDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {
    StoreDTO getStoreInfo();
    StoreDTO findStrByPosStrCode(String posStrCode);
}
