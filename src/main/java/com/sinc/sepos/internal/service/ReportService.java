package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.ReportDTO;
import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.entity.Store;


public interface StoreService {

    Store getStoreInfo();
    StoreDTO findStrByPosStrCode(String posStrCode);

}
