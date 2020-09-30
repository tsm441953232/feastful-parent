package com.tsm.redpacket.model.redPacket;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GrabPacketRequest {
    @ApiModelProperty(value = "客户ID")
    private Integer userId;

    @ApiModelProperty(value = "红包")
    private Integer redPacketId;

}
