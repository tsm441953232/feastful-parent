package com.tsm.feastful.rmsengine.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "健康测试类")
public class HealthController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hello")
    public String hello(){
        log.info("hello,this is rms-engine server");
        return "hello,this is rms-engine server" + this.serverPort;
    }

}
