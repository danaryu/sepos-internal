package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    @Override
    public StoreDTO getStoreInfo() {
        StoreDTO storeDTO = reportMapper.getStoreInfo();
        return reportMapper.getStoreInfo();
    }

    @Override
    public StoreDTO findStrByPosStrCode(String posStrCode) {
        StoreDTO storeDTO = reportMapper.findStrByPosStrCode(posStrCode);
        return storeDTO;
    }




}
