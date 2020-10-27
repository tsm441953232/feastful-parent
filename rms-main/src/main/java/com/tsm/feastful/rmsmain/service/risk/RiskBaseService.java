package com.tsm.feastful.rmsmain.service.risk;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;

public interface RiskBaseService {
    Boolean collectData(RiskInvokeRequest request);
    Boolean existData(RiskInvokeRequest request);
}
