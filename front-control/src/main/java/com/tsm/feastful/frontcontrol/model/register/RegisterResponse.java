package com.tsm.feastful.frontcontrol.model.register;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterResponse {
    @ApiModelProperty(value = "客户ID")
    private String customerId;
}
