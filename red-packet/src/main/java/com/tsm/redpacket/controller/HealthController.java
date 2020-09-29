package com.tsm.redpacket.controller;

import com.tsm.redpacket.common.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/health")
@Slf4j
@Api(value = "健康测试类")
public class HealthController {

    @ApiOperation("健康测试方法")
    @GetMapping(value = "get")
    ResponseDto<String> health() {
        return ResponseDto.ok("hello，this is redPacket server");
    }
}
