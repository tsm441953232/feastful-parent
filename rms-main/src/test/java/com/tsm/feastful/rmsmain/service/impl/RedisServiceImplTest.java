package com.tsm.feastful.rmsmain.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tsm.feastful.rmsmain.model.applyinfo.ApplyInfo;
import com.tsm.feastful.rmsmain.service.RedisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RedisServiceImplTest {

    @Autowired
    private RedisService redisService;

    @Test
    void set() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setApplyId("123");
        applyInfo.setContactList(null);
        applyInfo.setCustomerId("id");
        try {
            redisService.set("test", applyInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSet() {
    }

    @Test
    void getStrValue() {
    }

    @Test
    void get() throws Exception {
        ApplyInfo applyInfo = redisService.get("test", ApplyInfo.class);
        System.out.println(applyInfo.toString());
    }

    @Test
    void testGet() {
    }
}