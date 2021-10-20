package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.common.utils.PosUtil;
import com.sinc.sepos.internal.dto.ReportDTO;
import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.entity.Store;
import com.sinc.sepos.internal.mapper.dtomapper.StoreDTOMapper;
import com.sinc.sepos.internal.mapper.sqlmapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;

    @Override
    public Store getStoreInfo() {
        Store store = storeMapper.getStoreInfo();
        return storeMapper.getStoreInfo();
    }

    /**
     * POS점포코드로 점포 정보 조회
     * @param posStrCode
     * @return
     */

    @Override
    public StoreDTO findStrByPosStrCode(String posStrCode) {
        Store store = storeMapper.findStrByPosStrCode(posStrCode);
        System.out.println("store.toString() = " + store.toString());
        StoreDTO storeDTO = StoreDTOMapper.INSTANCE.toDTO(store);
        try {
            storeDTO = EncodingDTO(storeDTO);
            System.out.println("storeDTO.toString() = " + storeDTO.toString());
        } catch(Exception e) {
            // TODO Exception logic
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return storeDTO;
    }

    /**
     * storeDTO encoding
     * @param storeDTO
     * @return
     * @throws UnsupportedEncodingException
    */

    private StoreDTO EncodingDTO(StoreDTO storeDTO) throws UnsupportedEncodingException {
        storeDTO.setStrNm(PosUtil.EncodingToKR(storeDTO.getStrNm()));
        storeDTO.setStrOldAddr(PosUtil.EncodingToKR(storeDTO.getStrOldAddr()));
        storeDTO.setStrNewAddr(PosUtil.EncodingToKR(storeDTO.getStrNewAddr()));
        storeDTO.setStrDtlsAddr(PosUtil.EncodingToKR(storeDTO.getStrDtlsAddr()));
        return storeDTO;
    }


}
