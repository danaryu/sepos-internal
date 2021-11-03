package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.common.adapter.EncodingAdapter;
import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import com.sinc.sepos.internal.entity.ReportTemplate;
import com.sinc.sepos.internal.entity.Store;
import com.sinc.sepos.internal.mapper.dtomapper.ReportMessageMapper;
import com.sinc.sepos.internal.mapper.dtomapper.StoreDTOMapper;
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
    private final EncodingAdapter encodingAdapter;

    /**
     * POS점포코드로 점포 정보 조회
     * @param posStrCode
     * @return
     */

    @Override
    public StoreDTO findStrByPosStrCode(String posStrCode) {
        Store store = storeMapper.findStrByPosStrCode(posStrCode);
        StoreDTO storeDTO = StoreDTOMapper.INSTANCE.toDTO(store);
        return storeDTO;
    }

    /**
     * 전달받은 StoreDTO를 바탕으로 ReportDTO를 생성한다.
     * @return
     */

    @Override
    public ReportMessageDTO makeReport(StoreDTO storeDTO) throws UnsupportedEncodingException {
        ReportTemplate reportTemplate = templateMapper.findBasicTemplate();
        ReportMessageDTO reportMessageDTO = ReportMessageMapper.INSTANCE.toReportMessage(storeDTO, reportTemplate);
        return encodingAdapter.encodingReport(reportMessageDTO);
    }

}
