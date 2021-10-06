package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;

    @Override
    public List<HashMap<String, String>> getStoreList() {
        return storeMapper.getStoreList();
    }
}
