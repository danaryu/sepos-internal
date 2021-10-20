package com.sinc.sepos.internal;

import com.sinc.sepos.internal.entity.Store;
import com.sinc.sepos.internal.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportServiceTest {

    @Autowired
    ReportService reportService;

    @Test
    void getStoreList_TEST() throws Exception {
        // List<HashMap<String, String>> storeList = storeService.getStoreList();
        /*
            for (HashMap<String, String> store : storeList) {
                System.out.println("store.toString() = " + store.toString());
            }
        */
    }

    @Test
    void getStoreInfo_TEST() throws Exception {
        Store store = reportService.getStoreInfo();
        System.out.println("storeDTO.toString() = " + store.toString());
    }



}
