package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.common.adapter.EncodingAdapter;
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
    private final EncodingAdapter encodingAdapter;

    @Override
    public void insertRequestLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        ReportLog reportLog = ReportLogDTOMapper.INSTANCE.toEntity(encodingAdapter.encodingRequestLog(reportLogDTO));
        logMapper.insertRequestLog(reportLog);
    }

    @Override
    public void updateResponseLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        ReportLog reportLog = ReportLogDTOMapper.INSTANCE.toEntity(encodingAdapter.encodingResponseLog(reportLogDTO));
        logMapper.updateResponseLog(reportLog);
    }

}
