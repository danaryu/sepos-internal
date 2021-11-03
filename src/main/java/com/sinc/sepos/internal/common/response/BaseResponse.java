package com.sinc.sepos.internal.common.response;

import com.sinc.sepos.internal.common.format.EnumFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse {

    private String message;
    private String code;

    public BaseResponse(EnumFormat code) {
        this.message = code.getValue();
        this.code = code.getKey();
    }

    public static BaseResponse of(EnumFormat code) {
        return new BaseResponse(code);
    }

}
