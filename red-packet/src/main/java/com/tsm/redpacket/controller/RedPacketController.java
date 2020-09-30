package com.tsm.redpacket.controller;

import com.tsm.redpacket.common.ResponseDto;
import com.tsm.redpacket.model.redPacket.GrabPacketRequest;
import com.tsm.redpacket.model.redPacket.SetRedPacketRequest;
import com.tsm.redpacket.service.RedPacketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController(value = "/redPacket")
@Api(value = "红包")
@Slf4j
@CrossOrigin
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

    @ApiOperation("抢红包-不加锁")
    @GetMapping("grabRedPacket")
    ResponseDto<Map<String, Object>> grabRedPacket(@RequestParam(value = "redPacketId") Integer redPacketId ,
                                      @RequestParam(value = "userId") Integer userId){
        GrabPacketRequest grabPacketRequest = new GrabPacketRequest();
        grabPacketRequest.setRedPacketId(redPacketId);
        grabPacketRequest.setUserId(userId);
        log.info("接收到抢红包-不加锁的请求, 请求体为 setRedPacketRequest = {}",grabPacketRequest.toString());
        int result = redPacketService.grabRedPacket(grabPacketRequest);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result == 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
        return ResponseDto.ok(retMap);
    }
}
