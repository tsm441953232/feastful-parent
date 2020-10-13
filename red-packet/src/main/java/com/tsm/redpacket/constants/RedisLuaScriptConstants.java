package com.tsm.redpacket.constants;

public class RedisLuaScriptConstants {
    public static final String redPacketDecreaseLuaScript = "--缓存抢红包列表信息列表key\n" +
            "local listKey = 'red_packet_list_'..KEYS[1]\n" +
            "--当前被抢红包key\n" +
            "local redPacket = 'red_packet_'..KEYS[1]\n" +
            "--获取当前红包库存\n" +
            "local stock = tonumber(redis.call('hget', redPacket, 'stock'))\n" +
            "--没有库存，返回为0\n" +
            "if stock <= 0 then return 0 end\n" +
            "--库存减1\n" +
            "stock = stock -1\n" +
            "--保存当前库存\n" +
            "redis.call('hset',redPacket,'stock', tostring(stock))\n" +
            "--往链表中加入当前红包信息\n" +
            "redis.call('rpush', listKey, ARGV[1])\n" +
            "--如果是最后一个红包，则返回2，表示抢红包已经结束，需要将列表中的数据保存到数据库中\n" +
            "if stock == 0 then return 2 end\n" +
            "--如果并非最后一个红包，则返回1，表示抢红包成功\n" +
            "return 1";
}
