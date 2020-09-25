package com.tsm.feastful.frontcontrol.controller;

import com.tsm.feastful.frontcontrol.common.ResponseDto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@Api(value = "redis测试类")
public class RedisController {
    @Autowired
    private DefaultRedisScript<String> redisScript;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/lua")
    public ResponseDto lua() {
        List<String> keys = Arrays.asList("fc_sequence");
        String execute = stringRedisTemplate.execute(redisScript, keys, null);
        assert execute != null;
        return ResponseDto.ok(execute);
    }

}
