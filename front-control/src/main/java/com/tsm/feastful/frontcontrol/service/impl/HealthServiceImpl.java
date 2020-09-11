package com.tsm.feastful.frontcontrol.service.impl;

import com.tsm.feastful.frontcontrol.feign.ApplySystemFeign;
import com.tsm.feastful.frontcontrol.service.HealthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HealthServiceImpl implements HealthService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplySystemFeign applySystemFeign;



    @Override
    public String getMethodToAps() {
        String returnMessage = restTemplate.getForObject("http://APPLY-SYSTEM/hello",String.class);
        return returnMessage;
    }

    @Override
    public String getFeignMethodToAps() {
        return applySystemFeign.getMethodToAps();
    }
}
