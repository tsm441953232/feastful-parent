package com.tsm.feastful.rmsmain.service.risk.impl;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.service.risk.RiskBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("QueryApplicationService")
public class QueryApplication implements RiskBaseService {
    @Override
    public Boolean collectData(RiskInvokeRequest request) {
        return null;
    }

    @Override
    public Boolean existData(RiskInvokeRequest request) {
        return null;
    }
}
