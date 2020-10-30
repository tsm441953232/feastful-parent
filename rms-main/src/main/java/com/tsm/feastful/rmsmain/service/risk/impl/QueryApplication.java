package com.tsm.feastful.rmsmain.service.risk.impl;

import com.tsm.feastful.rmsmain.helper.RmsRuleMessageHelper;
import com.tsm.feastful.rmsmain.model.RiskHeader;
import com.tsm.feastful.rmsmain.model.RuleMessage;
import com.tsm.feastful.rmsmain.service.risk.RiskBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("QueryApplicationService")
public class QueryApplication implements RiskBaseService {

    @Override
    public Boolean collectData(RiskHeader riskHeader) throws Exception {
        String key = RmsRuleMessageHelper.getRuleMessageKey(riskHeader);
        RuleMessage ruleMessage = RmsRuleMessageHelper.getRuleMessage(key);

    }

    @Override
    public Boolean existData(RiskHeader riskHeader) {
        return null;
    }
}
