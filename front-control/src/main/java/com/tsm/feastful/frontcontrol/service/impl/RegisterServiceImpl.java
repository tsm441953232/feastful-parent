package com.tsm.feastful.frontcontrol.service.impl;

import com.tsm.feastful.frontcontrol.common.ResponseDto;
import com.tsm.feastful.frontcontrol.entity.FcAccount;
import com.tsm.feastful.frontcontrol.entity.FcSysParam;
import com.tsm.feastful.frontcontrol.model.register.RegisterRequest;
import com.tsm.feastful.frontcontrol.model.register.RegisterResponse;
import com.tsm.feastful.frontcontrol.repository.FcAccountRepo;
import com.tsm.feastful.frontcontrol.repository.FcSysParamRepo;
import com.tsm.feastful.frontcontrol.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.tsm.feastful.frontcontrol.constants.CommonConstants.*;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private FcAccountRepo fcAccountRepo;
    @Autowired
    private FcSysParamRepo fcSysParamRepo;

    @Override
    public ResponseDto<RegisterResponse> userRegister(RegisterRequest registerRequest) throws Exception {
        log.info("registerRequest = {}", registerRequest.toString());

        FcAccount fcAccount = FcAccount.newFcAccount(registerRequest);
        fcAccountRepo.save(fcAccount);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setCustomerId(getCustomerId());
        return ResponseDto.ok(registerResponse);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String getCustomerId(){
        FcSysParam fcSysParam = fcSysParamRepo.getByParamIndex(SYS_PARAM_INDEX_1001);
        //TODO 加redis分布式锁
        Long currentCustomerId = Long.parseLong(fcSysParam.getParamValue());
        currentCustomerId = currentCustomerId + 1L;
        fcSysParam.setParamValue(currentCustomerId.toString());
        fcSysParamRepo.saveAndFlush(fcSysParam);
        return currentCustomerId.toString();
    }
}
