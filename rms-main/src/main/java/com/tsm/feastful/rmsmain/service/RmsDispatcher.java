package com.tsm.feastful.rmsmain.service;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.model.RiskInvokeResponse;

/**
 * 风控请求分发类
 */
public interface RmsDispatcher {
    RiskInvokeResponse start(RiskInvokeRequest request,String businessType) throws Exception;
}
