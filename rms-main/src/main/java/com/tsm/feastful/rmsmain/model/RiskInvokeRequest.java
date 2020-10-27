package com.tsm.feastful.rmsmain.model;

import lombok.Data;

@Data
public class RiskInvokeRequest {
    private RiskHeader riskHeader;
    private String phoneNum;
    private String idCardNum;
}
