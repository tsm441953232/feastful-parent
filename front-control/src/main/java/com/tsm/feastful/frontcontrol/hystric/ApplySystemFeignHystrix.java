package com.tsm.feastful.frontcontrol.hystric;

import com.tsm.feastful.frontcontrol.feign.ApplySystemFeign;
import org.springframework.stereotype.Component;

@Component
public class ApplySystemFeignHystrix implements ApplySystemFeign{
    @Override
    public String getMethodToAps() {
        return "sorry ,this is hystrix to aps";
    }
}
