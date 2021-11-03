package com.sinc.sepos.internal.common.response;

import com.sinc.sepos.internal.common.format.EnumFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements EnumFormat {

    /**
     * successCode 정의 ("subCode", "message")
     */

    // COMMON
    EXT_SUCCESS("S0000", "정상 처리되었습니다.");

    private String successCode;
    private String message;

    SuccessCode(String successCode, String message) {
        this.message = message;
        this.successCode = successCode;
    }

    @Override
    public String getKey() {
        return this.successCode;
    }

    @Override
    public String getValue() {
        return this.message;
    }

}
