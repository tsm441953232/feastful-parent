package com.tsm.redpacket.controller;

import com.tsm.redpacket.common.ResponseDto;
import com.tsm.redpacket.service.SerializeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@Api("序列化测试类")
public class SerializeController {
    @Autowired
    private SerializeService serializeService;

    @GetMapping(value = "serialize")
    public ResponseDto serialize() throws IOException {
        serializeService.serialize();
        return ResponseDto.ok();
    }

    @GetMapping(value = "deserialize")
    public ResponseDto deserialize() throws IOException, ClassNotFoundException {
        serializeService.deserialize();
        return ResponseDto.ok();
    }
}
