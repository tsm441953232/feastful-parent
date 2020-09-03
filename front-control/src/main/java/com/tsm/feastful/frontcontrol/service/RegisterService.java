package com.tsm.feastful.frontcontrol.service;

import com.tsm.feastful.frontcontrol.common.ResponseDto;
import com.tsm.feastful.frontcontrol.model.register.RegisterRequest;
import com.tsm.feastful.frontcontrol.model.register.RegisterResponse;

public interface RegisterService {
    ResponseDto<RegisterResponse> userRegister(RegisterRequest registerRequest) throws Exception;
}
