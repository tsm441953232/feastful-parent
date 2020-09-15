package com.tsm.feastful.frontcontrol.feign;

import com.tsm.feastful.frontcontrol.hystric.ApplySystemFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "apply-system",fallback = ApplySystemFeignHystrix.class)
public interface ApplySystemFeign {

    @RequestMapping(value= "hello" ,method = RequestMethod.GET)
    String getMethodToAps();
}
