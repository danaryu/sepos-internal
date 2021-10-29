package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.entity.Store;


public interface ReportService {
    Store getStoreInfo();
    StoreDTO findStrByPosStrCode(String posStrCode);
    ReportMessageDTO makeReport(StoreDTO storeDTO);
}
