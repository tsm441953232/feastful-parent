package com.tsm.feastful.frontcontrol.service.impl;

import com.tsm.feastful.frontcontrol.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * lua脚本：获取下一个可用的序列号
     */
    private static final String GET_NEXT_SEQNUM_LUA = "local maxSeqNumStr = redis.pcall(\"HGET\", KEYS[1], \"max\")\n" +
            "if type(maxSeqNumStr) == 'boolean' and maxSeqNumStr == false then\n" +
            "    return nil\n" +
            "end\n" +
            "\n" +
            "local maxSeqNum = tonumber(maxSeqNumStr)\n" +
            "local seqNum = redis.pcall(\"HINCRBY\", KEYS[1], \"cur\", 1)\n" +
            "if seqNum <= maxSeqNum then\n" +
            "    return seqNum..':'..maxSeqNum\n" +
            "else\n" +
            "    return nil\n" +
            "end";



    @Override
    public String scriptLoad(String script) {
        return null;
    }
}
