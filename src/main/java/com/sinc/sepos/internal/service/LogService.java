package com.sinc.sepos.internal.service;

import com.sinc.sepos.internal.dto.ReportLogDTO;

import java.io.UnsupportedEncodingException;

public interface LogService {
    void insertRequestLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException;
    void updateResponseLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException;
}
