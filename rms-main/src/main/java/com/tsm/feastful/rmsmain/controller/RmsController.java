package com.tsm.feastful.rmsmain.controller;

import com.tsm.feastful.rmsmain.common.ResponseDto;
import com.tsm.feastful.rmsmain.model.RiskInvokeEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("风控请求")
@RequestMapping(value = "/rms")
public class RmsController {

    @RequestMapping(value = "/invoke")
    public ResponseDto invoke(RiskInvokeEntity riskInvokeEntity){
        return null;
    }
}
