package com.tsm.feastful.frontcontrol.sequence;


import org.springframework.beans.factory.annotation.Value;

/**
 * 序列号相关配置信息
 */

public class SequenceConstant {


    private SequenceConstant() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 最大可用的序列号
     */
    public static final String MAX = "max";
    /**
     * 当前序列号
     */
    public static final String CUR = "cur";


    public static final String UPDATE_TIME = "updateTime";

    /**
     * reids sequence key 前缀
     */
    public static final String REDIS_SEQUENCE_PREFIX = "fc:sequence:";

    /**
     * 序列名称
     */
    private String sequenceName = "custId";

    /**
     * lua脚本对应的的shakey ：获取下一个可用的序列号
     */
    private String getNextSeqNumLuaShaKey;

    /**
     * 更新maxSeqNum的最小阈值
     * 如果可用的序列号数量，小于该阈值，则更新maxSeqNum
     */
    @Value("${sequence.cust.id.min.threshold:400}")
    public int minThreshold = 400;

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

}
