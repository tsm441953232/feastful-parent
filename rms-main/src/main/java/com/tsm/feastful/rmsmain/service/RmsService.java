package com.tsm.feastful.rmsmain.service;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.model.RiskInvokeResponse;

/**
 * 处理风控请求
 */
public interface RmsService {
    RiskInvokeResponse invoke(RiskInvokeRequest riskInvokeRequest);
}
