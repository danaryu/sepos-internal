package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.StoreDTO;


public interface ReportService {
    StoreDTO getStoreInfo();
    StoreDTO findStrByPosStrCode(String posStrCode);
}
