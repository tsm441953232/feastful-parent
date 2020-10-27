package com.tsm.feastful.rmsmain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Slf4j
public class JacksonUtils {
    private static ObjectMapper OBJECT_MAPPER;
    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);
        TimeZone china = TimeZone.getTimeZone("GMT+08:00");
        OBJECT_MAPPER.setTimeZone(china);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    public static String objectToJson(Object object) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    /**
     * json 转JavaBean
     */
    public static <T> T json2pojo(String jsonString, Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonString, clazz);
    }
}
