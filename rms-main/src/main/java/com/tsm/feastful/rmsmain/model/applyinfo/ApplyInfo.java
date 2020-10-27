package com.tsm.feastful.rmsmain.model.applyinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApplyInfo {
    @ApiModelProperty("申请号")
    String applyId;
    @ApiModelProperty("客户ID")
    String customerId;
    @ApiModelProperty("联系人列表")
    List<String> contactList;//联系人列表
}
