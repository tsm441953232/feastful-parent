package com.tsm.feastful.rmsmain.service.impl;

import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.model.RiskInvokeResponse;
import com.tsm.feastful.rmsmain.service.RmsDispatcher;
import com.tsm.feastful.rmsmain.service.RmsRouteService;
import com.tsm.feastful.rmsmain.service.RmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RmsServiceImpl implements RmsService {
    @Autowired
    private RmsDispatcher rmsDispatcher;
    @Autowired
    private RmsRouteService rmsRouteService;

    @Override
    public RiskInvokeResponse invoke(RiskInvokeRequest riskInvokeRequest) {
        log.info("接收到请求风控系统的请求, riskInvokeRequest = {}", riskInvokeRequest.toString());

        String businessType = rmsRouteService.getRmsRoute("JDE-ROUTE1");//根据路由编码获取业务类型
        RiskInvokeResponse riskInvokeResponse = rmsDispatcher.start(riskInvokeRequest,businessType);//开启执行方法
        return riskInvokeResponse;
    }
}
