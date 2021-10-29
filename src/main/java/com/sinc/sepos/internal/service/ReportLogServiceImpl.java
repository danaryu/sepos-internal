package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.common.utils.PosUtil;
import com.sinc.sepos.internal.dto.ReportLogDTO;
import com.sinc.sepos.internal.entity.ReportLog;
import com.sinc.sepos.internal.mapper.dtomapper.ReportLogDTOMapper;
import com.sinc.sepos.internal.mapper.sqlmapper.LogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class ReportLogServiceImpl implements LogService {

    private final LogMapper logMapper;

    @Override
    public void insertReportLog(ReportLogDTO reportLogDTO) {
        try {
            reportLogDTO = encodingRequestLog(reportLogDTO);
        } catch(Exception e) {
            // TODO Exception logic
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        ReportLog reportLog = ReportLogDTOMapper.INSTANCE.toEntity(reportLogDTO);
        logMapper.insertReportLog(reportLog);
    }

    /**
     * reportLogDTO를 encoding한다.
     * @param reportLogDTO
     * @return
     * @throws UnsupportedEncodingException
     */

    public ReportLogDTO encodingRequestLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        reportLogDTO.setSendMsg(PosUtil.EncodingToEN(reportLogDTO.getSendMsg()));
        return reportLogDTO;
    }

}
