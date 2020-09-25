package com.tsm.feastful.frontcontrol.sequence;

/**
 * 序列号客户端
 */
public interface SequenceClient {


    /**
     * 获取下一个可用的序列号
     *
     * @return
     */
    Integer nextSeqNumByMysqlAndRedis(String sequenceName);


}
