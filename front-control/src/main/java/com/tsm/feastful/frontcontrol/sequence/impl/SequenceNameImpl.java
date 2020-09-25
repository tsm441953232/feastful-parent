package com.tsm.feastful.frontcontrol.sequence.impl;

import com.netflix.discovery.converters.Auto;
import com.tsm.feastful.frontcontrol.sequence.SequenceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SequenceNameImpl implements SequenceClient {
    @Override
    public Integer nextSeqNumByMysqlAndRedis(String sequenceName) {
        return null;
    }

}
