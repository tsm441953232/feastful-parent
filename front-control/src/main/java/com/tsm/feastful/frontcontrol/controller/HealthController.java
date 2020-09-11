package com.tsm.feastful.frontcontrol.controller;

import com.tsm.feastful.frontcontrol.service.HealthService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "健康测试类")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @GetMapping("hello")
    public String hello(){
        log.info("hello,this is front-control server");
        return "hello,this is front-control server";
    }

    @GetMapping("helloAps")
    public String helloAps() {
        return healthService.getMethodToAps();
    }

    @GetMapping("helloFeignAps")
    public String helloFeignAps() {
        return healthService.getFeignMethodToAps();
    }
}
