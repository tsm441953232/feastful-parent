package com.tsm.redpacket.controller;

import com.tsm.redpacket.common.ResponseDto;
import com.tsm.redpacket.model.redPacket.SetRedPacketRequest;
import com.tsm.redpacket.service.RedPacketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "redPacket")
@Api(value = "红包")
@Slf4j
public class RedPacketController {
    @Autowired
    private RedPacketService redPacketService;

    @ApiOperation("设置红包")
    @PostMapping("set")
    ResponseDto<String> setRedPacket(@RequestBody SetRedPacketRequest setRedPacketRequest){
        log.info("接收到设置红包的请求, 请求体为 setRedPacketRequest = {}",setRedPacketRequest.toString());
        redPacketService.setRedPacket(setRedPacketRequest);
        return ResponseDto.ok();
    }
}
