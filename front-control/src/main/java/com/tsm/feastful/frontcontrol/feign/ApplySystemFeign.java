package com.tsm.feastful.frontcontrol.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "apply-system")
public interface ApplySystemFeign {

    @RequestMapping(value= "hello" ,method = RequestMethod.GET)
    String getMethodToAps();
}
