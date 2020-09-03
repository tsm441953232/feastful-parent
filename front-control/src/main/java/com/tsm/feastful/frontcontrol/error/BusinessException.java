package com.tsm.feastful.frontcontrol.error;


import com.tsm.feastful.frontcontrol.enumm.BusinessErrorEnum;

/**
 * @ClassName BusinessException
 * @Description 包装器业务异常模式
 * @Author
 * @Data 2019/6/10 10:49
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException implements CommonError {


    private CommonError commonError;

    //直接接收EmBusinessError的传参用于构造业务异常
    public BusinessException(CommonError commonError) {
        super(commonError.getErrMsg());
        this.commonError = commonError;
    }

    public BusinessException(String message) {
        super(message);
        commonError = new CommonError() {
            @Override
            public String getErrCode() {
                return BusinessErrorEnum.PARAMENER_VALIDATION_ERROR.getErrCode();
            }

            @Override
            public String getErrMsg() {
                return message;
            }

            @Override
            public CommonError setErrMsg(String errMsg) {
                commonError.setErrMsg(errMsg);
                return commonError;
            }
        };
    }

    //接收自定义errMsg的方式构造业务异常

    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public String getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
