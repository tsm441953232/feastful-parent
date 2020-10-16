package com.tsm.redpacket.model.thread;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Data
@Slf4j
public class SaleTicket implements Runnable {
    private int ticketStock = 2;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            if (ticketStock > 0) {
                log.info("ticketStock before = {}", ticketStock);
                this.ticketStock--;
                log.info("ticketStock after = {}", ticketStock);
                try {
                    log.info(Thread.currentThread().getName() + "开始睡眠");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(Thread.currentThread().getName() + "正在卖票,还剩" + ticketStock + "张票");
                log.info(Thread.currentThread().getName() + "查看卖票标志位" + flag + "已售出!!!");
            } else {
                log.info(Thread.currentThread().getName() + "===============票已卖完=================");
                flag = false;
                log.info(Thread.currentThread().getName() + "查看卖票标志位" + flag + "未售出!!!");
            }
        }

    }
}
