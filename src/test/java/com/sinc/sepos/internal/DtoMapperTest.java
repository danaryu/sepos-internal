package com.sinc.sepos.internal;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.entity.Store;
import com.sinc.sepos.internal.mapper.dtomapper.StoreDTOMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DtoMapperTest {

    @Autowired
    StoreDTOMapper storeDTOMapper;

    @Test
    public void Entity를_DTO로_Mapping() {
//        Store store = new Store("3477","1677", "노브랜드강남역삼점","40","05","10.253.32.215","127.0313729","37.4923601","서울특별시 강남구 강남대로 324","서울특별시 강남구 역삼동 832-6","역삼디오슈페리움","02","2051","9666");
//
//        StoreDTO storeDTO = storeDTOMapper.toDTO(store);
//
//        System.out.println("storeDTO.toString() = " + storeDTO.toString());
//        System.out.println("store.toString() = " + store.toString());
//
//        assertEquals("3477", store.getPosStrCode());

    }


}
