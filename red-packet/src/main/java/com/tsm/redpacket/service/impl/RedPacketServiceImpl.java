package com.tsm.redpacket.service.impl;

import com.tsm.redpacket.entity.TRedPacket;
import com.tsm.redpacket.model.redPacket.SetRedPacketRequest;
import com.tsm.redpacket.repository.TRedPacketRepository;
import com.tsm.redpacket.service.RedPacketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class RedPacketServiceImpl implements RedPacketService {
    @Autowired
    private TRedPacketRepository tRedPacketRepository;

    @Override
    public void setRedPacket(SetRedPacketRequest setRedPacketRequest) {
        log.info("设置红包开始, setRedPacketRequest = {} ", setRedPacketRequest.toString());
        TRedPacket tRedPacket = new TRedPacket();
        tRedPacket.setUserId(setRedPacketRequest.getUserId());
        tRedPacket.setAmount(setRedPacketRequest.getAmount());
        tRedPacket.setTotal(setRedPacketRequest.getTotal());
        // TODO lambda表达式使用失败
        /*tRedPacket.setStock((setRedPacketRequest.getAmount(),setRedPacketRequest.getTotal()) -> {
            return divideRedPacketStock(setRedPacketRequest.getAmount(),setRedPacketRequest.getTotal());
        });*/
        tRedPacket.setStock(divideRedPacketStock(tRedPacket.getAmount(),tRedPacket.getTotal()));
        tRedPacket.setUnitAmount(divideRedPacketUnitAmount(tRedPacket.getAmount(),tRedPacket.getStock()));
        tRedPacket.setVersion(0);
        tRedPacketRepository.save(tRedPacket);
    }

    private Integer divideRedPacketStock(BigDecimal amount , Integer total){
        BigDecimal divided = new BigDecimal(total);
        return amount.divide(divided).intValue();
    }

    private BigDecimal divideRedPacketUnitAmount(BigDecimal amount , Integer stock){
        BigDecimal divided = new BigDecimal(stock);
        return amount.divide(divided);
    }
}
