package com.tsm.feastful.rmsmain.service.risk;

import com.tsm.feastful.rmsmain.model.RiskHeader;
import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;

public interface RiskBaseService {
    Boolean collectData(RiskHeader riskHeader) throws Exception;
    Boolean existData(RiskHeader riskHeader);
}
