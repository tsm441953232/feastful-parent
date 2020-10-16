package com.tsm.redpacket.service.impl;

import com.tsm.redpacket.model.thread.SaleTicket;
import com.tsm.redpacket.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThreadServiceImpl implements ThreadService {

    public static void main(String[] args){
        SaleTicket saleTicket = new SaleTicket();
        for(int t=1;t<=3;t++) {
            new Thread(saleTicket).start();
        }
    }

}
