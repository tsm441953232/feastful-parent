package com.tsm.redpacket.model.redPacket;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SetRedPacketRequest {
    @ApiModelProperty(value = "客户ID")
    private Integer userId;
    @ApiModelProperty(value = "金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "个数")
    private Integer total;

}
