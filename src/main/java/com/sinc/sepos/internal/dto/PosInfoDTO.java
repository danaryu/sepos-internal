package com.sinc.sepos.internal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@RequiredArgsConstructor
public class PosInfoDTO {

    @NotBlank(message = "pos_str_code는 빈 값 일 수 없습니다.")
    @JsonProperty("pos_str_code")
    private final String posStrCode;

    @NotBlank(message = "pos_no는 빈 값 일 수 없습니다.")
    @JsonProperty("pos_no")
    private final String posNo;

    @NotBlank(message = "pos_ip는 빈 값 일 수 없습니다.")
    @JsonProperty("pos_ip")
    private final String posRcvIp;

}
