package com.tsm.redpacket.service.impl;

import com.tsm.redpacket.service.RedisLuaShaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisLuaShaServiceImpl implements RedisLuaShaService {
    private String redPacketDecreaseLuaSha;

}
