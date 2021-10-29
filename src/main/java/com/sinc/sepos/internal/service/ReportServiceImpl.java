package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.common.utils.PosUtil;
import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.entity.ReportTemplate;
import com.sinc.sepos.internal.entity.Store;
import com.sinc.sepos.internal.mapper.dtomapper.ReportMessageMapper;
import com.sinc.sepos.internal.mapper.dtomapper.StoreDTOMapper;
import com.sinc.sepos.internal.mapper.sqlmapper.LogMapper;
import com.sinc.sepos.internal.mapper.sqlmapper.StoreMapper;
import com.sinc.sepos.internal.mapper.sqlmapper.TemplateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final StoreMapper storeMapper;
    private final TemplateMapper templateMapper;
    private final LogMapper logMapper;

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
        // System.out.println("store.toString() = " + store.toString());
        StoreDTO storeDTO = StoreDTOMapper.INSTANCE.toDTO(store);
        /*
            `try {
                storeDTO = EncodingStrDTO(storeDTO);
                System.out.println("storeDTO.toString() = " + storeDTO.toString());
            } catch(Exception e) {
                // TODO Exception logic
                System.out.println("e.getMessage() = " + e.getMessage());
            }`
        */
        return storeDTO;
    }

    /**
     * 전달받은 StoreDTO를 바탕으로 ReportDTO를 생성한다.
     * TODO: method명을 무엇으로 해야할지..(ㅠㅠ)
     * @return
     */

    @Override
    public ReportMessageDTO makeReport(StoreDTO storeDTO) {
        //TODO report Template Encoding logic 추가
        ReportTemplate reportTemplate = templateMapper.findBasicTemplate();
        // System.out.println("reportTemplate = " + reportTemplate.toString());
        ReportMessageDTO reportMessageDTO = ReportMessageMapper.INSTANCE.toReportMessage(storeDTO, reportTemplate);
        // System.out.println("reportMessage = " + reportMessage.toString());
        try {
            reportMessageDTO = encodingReport(reportMessageDTO);
            System.out.println("reportMessage = " + reportMessageDTO.toString());
        } catch(Exception e) {
            // TODO Exception logic
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return reportMessageDTO;
    }

    /**
     * reportTemplate encoding
     * @param reportMessageDTO
     * @return ReportTemplate
     * @throws UnsupportedEncodingException
     */

    private ReportMessageDTO encodingReport(ReportMessageDTO reportMessageDTO) throws UnsupportedEncodingException {
        reportMessageDTO.setStrNm(PosUtil.EncodingToKR(reportMessageDTO.getStrNm()));
        reportMessageDTO.setStrOldAddr(PosUtil.EncodingToKR(reportMessageDTO.getStrOldAddr()));
        reportMessageDTO.setStrNewAddr(PosUtil.EncodingToKR(reportMessageDTO.getStrNewAddr()));
        reportMessageDTO.setStrDtlsAddr(PosUtil.EncodingToKR(reportMessageDTO.getStrDtlsAddr()));
        reportMessageDTO.setRptCnts(PosUtil.EncodingToKR(reportMessageDTO.getRptCnts()));
        return reportMessageDTO;
    }

    /**
     * storeDTO encoding
     * @param storeDTO
     * @return StoreDTO
     * @throws UnsupportedEncodingException
     */

    private StoreDTO EncodingStrDTO(StoreDTO storeDTO) throws UnsupportedEncodingException {
        storeDTO.setStrNm(PosUtil.EncodingToKR(storeDTO.getStrNm()));
        storeDTO.setStrOldAddr(PosUtil.EncodingToKR(storeDTO.getStrOldAddr()));
        storeDTO.setStrNewAddr(PosUtil.EncodingToKR(storeDTO.getStrNewAddr()));
        storeDTO.setStrDtlsAddr(PosUtil.EncodingToKR(storeDTO.getStrDtlsAddr()));
        return storeDTO;
    }

}
