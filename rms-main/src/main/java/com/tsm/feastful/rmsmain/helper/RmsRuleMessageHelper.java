package com.tsm.feastful.rmsmain.helper;

import com.tsm.feastful.rmsmain.entity.RmsPolicySelection;
import com.tsm.feastful.rmsmain.model.RiskHeader;
import com.tsm.feastful.rmsmain.model.RuleMessage;
import com.tsm.feastful.rmsmain.model.applyinfo.ApplyInfo;
import com.tsm.feastful.rmsmain.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RmsRuleMessageHelper {
    @Autowired
    private static RedisService redisService;


    /**
     * @return
     * @params
     * @description 获取ruleMessage缓存的key
     * @updateBy
     * @updateContent
     */
    public static String getRuleMessageKey(RiskHeader riskHeader) {
        StringBuffer key = new StringBuffer("rms_main_1");
        key.append("_");
        key.append(riskHeader.getApplyId());
        key.append("_");
        key.append(riskHeader.getNodeCode());
        return key.toString();
    }

    public static RuleMessage getRuleMessage(String key) throws Exception {
        return redisService.get(key, RuleMessage.class);
    }

    /**
     * 创建规则引擎的交互模型，每执行一个规则集（RuleSet）时，都讲RuleSet设置为当前的规则集
     * @param riskHeader
     * @param rmsPolicySelection
     * @return
     * @throws Exception
     */
    public static RuleMessage createRuleMessage(RiskHeader riskHeader, RmsPolicySelection rmsPolicySelection) throws Exception {
        String ruleMessageKey = getRuleMessageKey(riskHeader);
        RuleMessage ruleMessage = getRuleMessage(ruleMessageKey);
        if(null == ruleMessage){
            ruleMessage.setRiskHeader(riskHeader);
            ruleMessage.setRuleSetCode(rmsPolicySelection.getRuleSetCode());
            ApplyInfo applyInfo = new ApplyInfo();
            applyInfo.setCustomerId(riskHeader.getCustomerId());
            applyInfo.setApplyId(riskHeader.getApplyId());
            ruleMessage.setApplyInfo(applyInfo);
        }
        ruleMessage.setRuleSetCode(rmsPolicySelection.getRuleSetCode());
        return ruleMessage;
    }
}
