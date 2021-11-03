package com.sinc.sepos.internal.common.response;

import com.sinc.sepos.internal.common.format.EnumFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements EnumFormat {

    /**
     * errorCode 정의 ("subErrorCode", "message")
     */

    // COMMON ERROR (Internal Error)
    INVALID_REQUEST("E2000", "잘못된 요청입니다."),
    INTERNAL_PROCESS_ERROR("E2001", "요청 처리에 실패하였습니다. (내부망 내부 에러)"),

    // API ERROR
    TEMPORARY_CONNECT_ERROR("E7001", "외부망 서버가 정상 응답하지 않습니다."); // HttpStatus.INTERNAL_SERVER_ERROR

    private String errorCode;
    private String message;

    ErrorCode(String errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getKey() {
        return this.errorCode;
    }

    @Override
    public String getValue() {
        return this.message;
    }

}
