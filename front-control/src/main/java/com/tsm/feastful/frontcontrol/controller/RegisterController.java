package com.tsm.feastful.frontcontrol.controller;

import com.tsm.feastful.frontcontrol.common.ResponseDto;
import com.tsm.feastful.frontcontrol.model.register.RegisterRequest;
import com.tsm.feastful.frontcontrol.model.register.RegisterResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "注册")
@RestController
@RequestMapping("/api/register")
@Slf4j
public class RegisterController {

    @PostMapping("/userRegister")
    @ApiOperation("客户注册接口")
    public ResponseDto<RegisterResponse> userRegister(@Valid @RequestBody RegisterRequest registerRequest) {
        return null;
    }

}
