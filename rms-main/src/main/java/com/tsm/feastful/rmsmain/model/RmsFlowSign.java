package com.tsm.feastful.rmsmain.model;

import lombok.Data;

/**
 * 用于传递内部流程信号
 */
@Data
public class RmsFlowSign {
    private Boolean interruptSign = false; //中断信号
    private Boolean hasPolicy = false;
}
