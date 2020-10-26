package com.tsm.feastful.rmsmain.utils;

import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Slf4j
public class JavaScriptUtils {

    public static Object javaScriptExecute(String jsStr, String funcName, Object clazz) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        log.info("路由算法：" + jsStr);
        try {
            engine.eval(jsStr);
        } catch (ScriptException e) {
            log.error("JsExecuteUtils", e);
        }

        Object result = null;
        if (engine instanceof Invocable) {
            Invocable invoke = (Invocable) engine;
            try {
                result = invoke.invokeFunction(funcName, clazz);
            } catch (Exception e) {
                log.error("JsExecuteUtils", e);
            }
        }
        return result;
    }
}
