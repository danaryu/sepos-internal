package com.sinc.sepos.internal.common.exception;

import com.sinc.sepos.internal.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class TempConnectionFailException extends Exception {

    private final ErrorCode errorCode;

    public TempConnectionFailException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public TempConnectionFailException(ErrorCode errorCode) {
        super(errorCode.getErrorCode());
        this.errorCode = errorCode;
    }
}
