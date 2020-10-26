package com.tsm.feastful.rmsmain.service.impl;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.model.RiskInvokeResponse;
import com.tsm.feastful.rmsmain.service.RmsDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RmsDispatcherImpl implements RmsDispatcher {
    @Override
    public RiskInvokeResponse start(RiskInvokeRequest request, String businessType) {
        return null;
    }
}
