package com.sinc.sepos.internal.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StoreMapper {

    List<HashMap<String, String>> getStoreList();

}
