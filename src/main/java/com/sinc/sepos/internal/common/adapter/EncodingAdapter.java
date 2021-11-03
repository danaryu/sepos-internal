package com.sinc.sepos.internal.common.adapter;

import com.sinc.sepos.internal.dto.ReportLogDTO;
import com.sinc.sepos.internal.dto.ReportMessageDTO;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class EncodingAdapter {

    /**
     * reportTemplate encoding
     * @param reportMessageDTO
     * @return ReportTemplate
     * @throws UnsupportedEncodingException
     */

    public ReportMessageDTO encodingReport(ReportMessageDTO reportMessageDTO) throws UnsupportedEncodingException {
        return reportMessageDTO.encodingReport(reportMessageDTO);
    }

    /**
     * reportLogDTO encoding (request Log)
     * @param reportLogDTO
     * @return
     * @throws UnsupportedEncodingException
     */

    public ReportLogDTO encodingRequestLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        return reportLogDTO.encodingRequestLog(reportLogDTO);
    }

    /**
     * reportLogDTO encoding (response Log)
     * @param reportLogDTO
     * @return
     * @throws UnsupportedEncodingException
     */

    public ReportLogDTO encodingResponseLog(ReportLogDTO reportLogDTO) throws UnsupportedEncodingException {
        return reportLogDTO.encodingResponseLog(reportLogDTO);
    }

}
