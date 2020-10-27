package com.tsm.feastful.rmsmain.service.impl;

import com.tsm.feastful.rmsmain.entity.RmsPolicyActuator;
import com.tsm.feastful.rmsmain.entity.RmsPolicySelection;
import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.model.RiskInvokeResponse;
import com.tsm.feastful.rmsmain.repository.RmsPolicyActuatorRepo;
import com.tsm.feastful.rmsmain.repository.RmsPolicySelectionRepo;
import com.tsm.feastful.rmsmain.service.risk.RiskBaseService;
import com.tsm.feastful.rmsmain.service.RmsDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RmsDispatcherImpl implements RmsDispatcher {
    @Autowired
    private RmsPolicySelectionRepo rmsPolicySelectionRepo;
    @Autowired
    private RmsPolicyActuatorRepo rmsPolicyActuatorRepo;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public RiskInvokeResponse start(RiskInvokeRequest request, String businessType) {
        log.info("开始执行风控规则集  request = {}, businessType = {}", request.toString(), businessType);
        //1.查询环节对应的风控策略集
        List<RmsPolicySelection> rmsPolicySelectionList = rmsPolicySelectionRepo.findByNodeCodeAndBusinessTypeOrderBySequenceAsc(request.getRiskHeader().getNodeCode(), businessType);
        //2.根据策略集去调用该策略集对应的执行器
        for (RmsPolicySelection rmsPolicySelection : rmsPolicySelectionList) {
            log.info("当前执行的执行的风控规则集为 ruleSetCode ={} ", rmsPolicySelection.getNodeCode());
            List<RmsPolicyActuator> rmsPolicyActuatorList = rmsPolicyActuatorRepo.findByRuleSetCode(rmsPolicySelection.getRuleSetCode());
            executeRmsPolicyActuator(request, rmsPolicyActuatorList);
        }
        RiskInvokeResponse riskInvokeResponse = new RiskInvokeResponse();
        riskInvokeResponse.setHeader(request.getRiskHeader());
        return riskInvokeResponse;
    }

    public void executeRmsPolicyActuator(RiskInvokeRequest riskInvokeRequest, List<RmsPolicyActuator> rmsPolicyActuatorList) {
        for (RmsPolicyActuator rmsPolicyActuator : rmsPolicyActuatorList) {
            String serviceId = rmsPolicyActuator.getServiceId();
            log.info("serviceId = {}", serviceId);
            RiskBaseService riskBaseService = (RiskBaseService) applicationContext.getBean(serviceId);
            riskBaseService.collectData(riskInvokeRequest);
        }
    }
}
