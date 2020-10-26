package com.tsm.feastful.rmsmain.service.impl;

import com.tsm.feastful.rmsmain.entity.RmsConfigRoute;
import com.tsm.feastful.rmsmain.repository.RmsConfigRouteRepo;
import com.tsm.feastful.rmsmain.service.RmsRouteService;
import com.tsm.feastful.rmsmain.utils.JavaScriptUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class RmsRouteServiceImpl implements RmsRouteService {
    @Autowired
    private RmsConfigRouteRepo rmsConfigRouteRepo;

    @Override
    public String getRmsRoute(String routeCode) {
        log.info("接收到查询路由编码的请求,RouteCode ={} ",routeCode);
        RmsConfigRoute rmsConfigRoute = rmsConfigRouteRepo.getByRouteCode(routeCode);
        if(Objects.nonNull(rmsConfigRoute)){
            return (String) JavaScriptUtils.javaScriptExecute(rmsConfigRoute.getRouteRule(),"process_route",null);
        }

        return null;
    }
}
