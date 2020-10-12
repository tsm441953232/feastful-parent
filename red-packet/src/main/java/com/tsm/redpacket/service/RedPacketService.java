package com.tsm.redpacket.service;

import com.tsm.redpacket.model.redPacket.GrabPacketRequest;
import com.tsm.redpacket.model.redPacket.SetRedPacketRequest;

public interface RedPacketService {
    void setRedPacket(SetRedPacketRequest setRedPacketRequest);

    //不加锁
    int grabRedPacket(GrabPacketRequest grabPacketRequest);

    //悲观锁
    int grabRedPacketPessimisticLock(GrabPacketRequest grabPacketRequest);

    //乐观锁-无重入机制
    int grabRedPacketOptimisticLock(GrabPacketRequest grabPacketRequest);

    //乐观锁-有重入机制
    int grabRedPacketOptimisticLockRetry(GrabPacketRequest grabPacketRequest);
}
