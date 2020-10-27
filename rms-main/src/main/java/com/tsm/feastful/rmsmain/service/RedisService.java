package com.tsm.feastful.rmsmain.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisService {

    void set(String key, Object value) throws JsonProcessingException;

    void set(String key, Object value, long milliSeconds) throws JsonProcessingException;

    <T> T get(String key, Class<T> tClass) throws Exception;

    Object get(String key);
}
