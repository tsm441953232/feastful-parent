package com.tsm.feastful.rmsmain.model.innerblacklist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InnerBlacklist implements Serializable {
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("1 黑名单，2白名单，3灰名单")
    private Integer listType;
    @ApiModelProperty("来源站点，如：[\"机构1\",\"机构2\"]")
    private List<String> listSrc;
    @ApiModelProperty("是否符合类型要求")
    private Boolean listFlag;
    @ApiModelProperty("列出所有的参数的命中情况（不命中的不列出）")
    @JsonProperty("hitParameters")
    private List<HitParameters> hitParametersList;
}
