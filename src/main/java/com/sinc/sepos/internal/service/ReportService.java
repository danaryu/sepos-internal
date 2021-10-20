package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.ReportDTO;
import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.entity.ReportMessage;
import com.sinc.sepos.internal.entity.Store;


public interface ReportService {

    Store getStoreInfo();
    StoreDTO findStrByPosStrCode(String posStrCode);
    ReportMessage makeReport(StoreDTO storeDTO);

}
