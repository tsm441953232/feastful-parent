package com.tsm.feastful.frontcontrol.controller;

import com.tsm.feastful.frontcontrol.common.ResponseDto;
import com.tsm.feastful.frontcontrol.service.HealthService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Api(tags = "健康测试类")
public class HealthController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private HealthService healthService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("hello")
    public String hello(){
        log.info("hello,this is front-control server");
        return "hello,this is front-control server" + this.serverPort;
    }

    @GetMapping("helloAps")
    public String helloAps() {
        return healthService.getMethodToAps();
    }

    @GetMapping("helloFeignAps")
    public String helloFeignAps() {
        return healthService.getFeignMethodToAps();
    }

    @GetMapping(value = "/redis/get/{key}")
    public ResponseDto<Map<String,String>> getRedis(@PathVariable String key){
        log.info("Redis test get -  {} ", key);
        final String redisValue = stringRedisTemplate.opsForValue().get(key);
        Map<String,String> map = new HashMap<>(1);
        map.put(key,redisValue);
        return ResponseDto.ok(map);
    }

    @GetMapping("redis/set")
    public ResponseDto<Map<String, String>> setRedis(@RequestParam String key,
                                                     @RequestParam String value) {
        log.info("Redis test set -  {} : {}", key, value);
        stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);

        Map<String, String> map = new HashMap<>(1);
        map.put(key, value);
        return ResponseDto.ok(map);
    }
}
