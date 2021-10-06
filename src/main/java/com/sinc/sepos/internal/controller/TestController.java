package com.sinc.sepos.internal.controller;

import com.sinc.sepos.internal.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final StoreService storeService;

    @GetMapping("/hello")
    public List<HashMap<String, String>> getTest() throws Exception {
        return storeService.getStoreList();
    }

}
