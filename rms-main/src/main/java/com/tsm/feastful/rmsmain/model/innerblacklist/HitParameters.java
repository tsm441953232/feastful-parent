package com.tsm.feastful.rmsmain.model.innerblacklist;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HitParameters implements Serializable {
    @ApiModelProperty("参数名")
    private String parameterName;
    @ApiModelProperty("命中黑名单数据库中的值，该值可能是脱敏的（带*）")
    private String hitValue;
}
