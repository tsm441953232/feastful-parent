package com.tsm.feastful.rmsmain.controller;

import com.tsm.feastful.rmsmain.common.ResponseDto;
import com.tsm.feastful.rmsmain.model.RiskInvokeRequest;
import com.tsm.feastful.rmsmain.service.RmsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("风控请求")
@RequestMapping(value = "/rms")
public class RmsController {
    @Autowired
    private RmsService rmsService;

    @RequestMapping(value = "/invoke")
    public ResponseDto invoke(RiskInvokeRequest riskInvokeRequest){
        return null;
    }
}
