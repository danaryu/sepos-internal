package com.sinc.sepos.internal;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class ReportServiceTest {

    @Autowired
    ReportService reportService;

    @Test
    void getStoreList_TEST() throws Exception {
        List<HashMap<String, String>> storeList = reportService.getStoreList();
        for (HashMap<String, String> store : storeList) {
            System.out.println("store.toString() = " + store.toString());
        }
    }

    @Test
    void getStoreInfo_TEST() throws Exception {
        StoreDTO storeDTO = reportService.getStoreInfo();
        System.out.println("storeDTO.toString() = " + storeDTO.toString());
    }



}
