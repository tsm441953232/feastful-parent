package com.tsm.redpacket.controller;

import com.tsm.redpacket.common.ResponseDto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController(value = "/redis")
@Slf4j
@Api(value = "redis测试类")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "get/{key}")
    public ResponseDto<Map<String,String>> getRedis(@PathVariable String key){
        log.info("Redis test get -  {} ", key);
        final String redisValue = stringRedisTemplate.opsForValue().get(key);
        Map<String,String> map = new HashMap<>(1);
        map.put(key,redisValue);
        return ResponseDto.ok(map);
    }

    @GetMapping("set")
    public ResponseDto<Map<String, Object>> setRedis(@RequestParam String key,
                                                     @RequestParam String value) {
        log.info("Redis test set -  {} : {}", key, value);
        stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);

        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return ResponseDto.ok(map);
    }
}
