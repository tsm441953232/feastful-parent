package com.tsm.feastful.frontcontrol.model.register;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterRequest {
    @ApiModelProperty("手机号")
    @NotEmpty(message = "手机号不能为空")
    private String phoneNum; //手机号

    @ApiModelProperty("业务类型")
    private String businessType;//业务类型

    @ApiModelProperty("渠道号")
    @NotEmpty(message = "渠道号不能为空")
    private String channelCode;//渠道号

    @ApiModelProperty("子渠道号")
    @NotEmpty(message = "子渠道号不能为空")
    private String childChannelCode;//子渠道号

    @ApiModelProperty("账户密码")
    @NotEmpty(message = "密码不能为空")
    private String accountPassword;//账户密码
}
