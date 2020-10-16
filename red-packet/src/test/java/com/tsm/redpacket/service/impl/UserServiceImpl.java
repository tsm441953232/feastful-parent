package com.tsm.redpacket.service.impl;

import com.tsm.redpacket.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
@Data
public class UserServiceImpl implements UserService, Runnable {
    private volatile boolean flag;
    private String name;

    UserServiceImpl() {
    }


    @Override
    public void run() {
        flag = true;
        while (flag) {
            log.info("flag = {}", flag);
            String name = Thread.currentThread().getName();
            log.info("name = {}", name);
        }
    }

    public void stop() {
        flag = false;
        log.info("调用stop方法, flag = {}", flag);
    }

    @Test
    public void testForVolatile() {
        UserService userService = new UserServiceImpl();
        Thread t1 = new Thread((Runnable) userService);
        Thread t2 = new Thread((Runnable) userService);
        t1.start();
        t2.start();
        this.stop();

    }

}
