package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.entity.Store;

import java.io.UnsupportedEncodingException;


public interface ReportService {
    StoreDTO findStrByPosStrCode(String posStrCode);
    ReportMessageDTO makeReport(StoreDTO storeDTO) throws UnsupportedEncodingException;
}
