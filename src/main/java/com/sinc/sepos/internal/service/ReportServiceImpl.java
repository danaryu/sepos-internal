package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.common.utils.PosUtil;
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

    /**
     * POS점포코드로 점포 정보를 조회한다.
     * @param posStrCode
     * @return
     */
    
    @Override
    public StoreDTO findStrByPosStrCode(String posStrCode) {
        StoreDTO storeDTO = reportMapper.findStrByPosStrCode(posStrCode);

        try {
            storeDTO = EncodingDTO(storeDTO);
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return storeDTO;

    }

    private StoreDTO EncodingDTO(StoreDTO storeDTO) throws UnsupportedEncodingException {
        storeDTO.setStrNm(PosUtil.EncodingToKR(storeDTO.getStrNm()));
        storeDTO.setStrOldAddr(PosUtil.EncodingToKR(storeDTO.getStrOldAddr()));
        storeDTO.setStrNewAddr(PosUtil.EncodingToKR(storeDTO.getStrNewAddr()));
        storeDTO.setStrDtlsAddr(PosUtil.EncodingToKR(storeDTO.getStrDtlsAddr()));
        return storeDTO;
    }


}
