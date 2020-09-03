package com.tsm.feastful.frontcontrol.enumm;

import com.tsm.feastful.frontcontrol.error.CommonError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusinessErrorEnum implements CommonError {
    //通用错误类型00001
    PARAMENER_VALIDATION_ERROR("10001", "参数不合法"),
    UNKNOWN_ERROR("10002", "系统繁忙，请稍后再试"),
    LOGIN_EXPIRE("10003", "登录信息已超时，请重新登录"),


    //以20000开头为用户信息相关错误定义
    USER_NOT_EXIST("20001", "用户不存在"),
    USER_PASSWORD_INVALID("20002", "用户密码不正确"),
    USER_LOGIN_INVALID("20003", "用户登录异常,请重新登录"),

    //以30000开头为业务错误定义
    SMS_ALREARY_SEND("30001", "验证码已经发送, 请1分钟后重发!"),
    SMS_CODE_ERROR("30002", "短信验证码错误"),
    SMS_CODE_EXPIRE("30003", "短信验证码已失效，请重新获取"),
    IMG_CODE_EXPIRE("30004", "图片验证码已过期，请重新获取"),
    IMG_CODE_ERROR("30005", "图片验证码错误"),

    //融资
    FINANCING_PRICE_ERROR("40001", "融资定价管理异常");


    private String errCode;
    private String errMsg;

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
