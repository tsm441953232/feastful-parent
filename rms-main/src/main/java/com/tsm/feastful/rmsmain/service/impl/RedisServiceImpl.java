package com.tsm.feastful.rmsmain.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tsm.feastful.rmsmain.service.RedisService;
import com.tsm.feastful.rmsmain.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final long defaultTime = 1000 * 60 * 10;

    @Override
    public void set(String key, Object value) throws JsonProcessingException {
        this.set(key,value,defaultTime);
    }

    /**
     * 把对象缓存到缓存中，以key-value的方式，并且设置有效时间
     * @param key  缓存对应的key
     * @param value  缓存的对象
     * @param milliSeconds  有效期
     */
    @Override
    public void set(String key, Object value, long milliSeconds) throws JsonProcessingException {
        stringRedisTemplate.opsForValue().set(key,getStrValue(value),milliSeconds, TimeUnit.MILLISECONDS);
    }


    public static String getStrValue(Object value) throws JsonProcessingException {
        String redisValue;
        if (value instanceof String) {
            redisValue = value.toString();
        } else {
            redisValue = JacksonUtils.objectToJson(value);
        }
        return redisValue;
    }

    @Override
    public <T> T get(String key, Class<T> tClass) throws Exception {
        Object result = get(key);
        if (result == null) {
            return null;
        }

        if (tClass.equals(String.class)) {
            return (T) result;
        }

        return JacksonUtils.json2pojo(result.toString(),tClass);
    }

    @Override
    public Object get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
