package com.tsm.feastful.rmsmain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tsm.feastful.rmsmain.model.applyinfo.ApplyInfo;
import com.tsm.feastful.rmsmain.model.innerblacklist.InnerBlacklist;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleMessage implements Serializable {
    @ApiModelProperty("访问头信息")
    private RiskHeader riskHeader;
    @ApiModelProperty("规则集")
    private String ruleSetCode;
    @ApiModelProperty("申请信息")
    private ApplyInfo applyInfo;
    @ApiModelProperty("自有黑名单")
    private InnerBlacklist innerBlacklist;
}
