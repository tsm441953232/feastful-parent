package com.tsm.feastful.rmsmain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 通用返回Client对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    /**
     * 默认响应成功状态
     */
    private String code;
    /**
     * 默认响应成功消息
     */
    private String message;
    /**
     * 默认响应空数据
     */
    private T data;

    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MSG = "Invoke success!";

    public static final String ERROR_CODE = "201";
    public static final String ERROR_MSG = "Invoke error!";

    public ResponseDto(String message) {
        this(SUCCESS_CODE, message, null);
    }

    public ResponseDto(String code, String message) {
        this(code, message, null);
    }

    /**
     * put the error message from BindingResult into responseDto object
     */
    public static void putErrorMessages(ResponseDto response, BindingResult result) {
        if (result.hasErrors()) {
            final List<ObjectError> allErrors = result.getAllErrors();
            String errorMessages = allErrors.stream()
                    .map(it -> it.getDefaultMessage())
                    .collect(Collectors.joining(";"));

            response.setMessage(errorMessages);
        }
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean isFailed() {
        return !isSuccess();
    }

    public ResponseDto(int code, String msg) {
        this(String.valueOf(code), msg, null);
    }

    public ResponseDto(T data) {
        this(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static ResponseDto ok() {
        return new ResponseDto(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static ResponseDto ok(Object data) {
        ResponseDto one = responseSuccess();
        one.setData(data);

        return one;
    }

    public static ResponseDto okMsg(String msg) {
        ResponseDto one = responseSuccess();
        one.setMessage(msg);

        return one;
    }

    public static ResponseDto failed(String errorMsg) {
        return new ResponseDto(ERROR_CODE, errorMsg);
    }

    public static ResponseDto failed(String errorCode, String errorMsg) {
        return new ResponseDto(errorCode, errorMsg);
    }

    public static ResponseDto responseSuccess() {
        return new ResponseDto(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static ResponseDto responseSuccess(String successMsg) {
        return new ResponseDto(successMsg);
    }

    public static ResponseDto responseError() {
        return new ResponseDto(ERROR_CODE, ERROR_MSG);
    }

    public static ResponseDto responseError(String errorMsg) {
        return new ResponseDto(ERROR_CODE, errorMsg);
    }

}
