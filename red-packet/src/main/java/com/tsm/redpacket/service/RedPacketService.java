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

    //乐观锁-有重入机制 避免抢红包失败无法抢到的问题 每次请求最多重试三次
    int grabRedPacketOptimisticLockRetry(GrabPacketRequest grabPacketRequest);

    //redis-script脚本进行抢红包操作
    int grabRedPacketRedisScript(GrabPacketRequest grabPacketRequest);
}
