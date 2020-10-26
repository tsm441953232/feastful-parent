package com.tsm.feastful.rmsmain.service;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;

/**
 * 处理风控请求
 */
public interface RmsService {
    void invoke(RiskInvokeRequest riskInvokeRequest);
}
