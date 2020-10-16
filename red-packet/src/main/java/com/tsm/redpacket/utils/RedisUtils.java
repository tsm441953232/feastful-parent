package com.tsm.redpacket.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

@Slf4j
public class RedisUtils {

    /*public static <T> T get(String key, Long timeout, Class<T> clazz, Callable<T> getFunction, Runnable exceptionRunnable) {
        RedisService redisService = SpringUtil.getBean(RedisService.class);
        if (redisService == null) {
            log.error("Redis查询接口 初始化异常");
            return null;
        }
        if (StringUtils.isBlank(key)) {
            return null;
        }
        String cacheValue = redisService.get(key);
        T object = null;
        if (StringUtils.isNotBlank(cacheValue)) {
            if (CacheConstant.EMPTY_CACHE.equals(cacheValue)) {
                return null;
            }

            try {
                object = JSONObject.parseObject(cacheValue, clazz);
            } catch (Exception e) {
                log.error("RedisUtil get error, key:[" + key + "], cacheValue:[" + cacheValue + "]", e);
            }

            if (object != null) {
                return object;
            } else {
                //说明解析发生了异常，调用解析异常处理，比如可以做一些缓存过期处理之类的操作
                if (exceptionRunnable != null) {
                    exceptionRunnable.run();
                }
            }
        }

        try {
            if (getFunction != null) {
                object = getFunction.call();
            }
        } catch (Exception e) {
            log.error("getFunction.call error", e);
            return null;
        }

        cacheValue = object != null ? JsonUtil.object2json(object) : CacheConstant.EMPTY_CACHE;
        redisService.set(key, cacheValue, timeout);
        return object;
    }*/

}
