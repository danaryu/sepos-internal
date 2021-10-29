package com.sinc.sepos.internal.mapper.sqlmapper;

import com.sinc.sepos.internal.entity.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    Store getStoreInfo();
    Store findStrByPosStrCode(String posStrCode);
}
