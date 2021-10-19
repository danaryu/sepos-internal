package com.sinc.sepos.internal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PosInfoDTO {

    @JsonProperty("pos_str_code")
    private final String posStrCode;

    @JsonProperty("pos_no")
    private final String posNo;

}
