package com.tsm.feastful.frontcontrol.error;


import com.tsm.feastful.frontcontrol.common.ResponseDto;
import com.tsm.feastful.frontcontrol.enumm.BusinessErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class UnionExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object apiExceptionHandler(HttpServletRequest request, BusinessException ex) {
        Map<String, String> responseData = new HashMap<>();
        log.error(" 业务异常抛出：{}", ex);

        responseData.put("errCode", ex.getErrCode());
        responseData.put("errMsg", ex.getErrMsg());

        return ResponseDto.failed(responseData.get("errCode"), responseData.get("errMsg"));
    }


    /**
     * Description : 全局异常捕捉处理
     * Group :
     *
     * @param ex
     * @return
     * @author honghh
     * @date 2019/4/1 0001 10:34
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object apiExceptionHandler(HttpServletRequest request, Exception ex) {
        Map<String, String> responseData = new HashMap<>();
        log.error(" 异常抛出：{}", ex);
        responseData.put("errCode", BusinessErrorEnum.UNKNOWN_ERROR.getErrCode());
        responseData.put("errMsg", BusinessErrorEnum.UNKNOWN_ERROR.getErrMsg());

        return ResponseDto.failed(responseData.get("errCode"), responseData.get("errMsg"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object bindExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        log.error(" 参数绑定异常抛出：{}", ex);

        List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
        StringBuffer errorMsg = new StringBuffer();
        for (FieldError fieldError : bindingResult) {
            errorMsg.append(fieldError.getDefaultMessage()).append(",");
        }
        errorMsg.append(".");

        return ResponseDto.failed(BusinessErrorEnum.PARAMENER_VALIDATION_ERROR.getErrCode(), errorMsg.toString());
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object bindExceptionHandler(HttpServletRequest request, MissingServletRequestPartException ex) {
        log.error(" 参数绑定异常抛出：{}", ex);

        String errorMsg = ex.getMessage();

        return ResponseDto.failed(BusinessErrorEnum.PARAMENER_VALIDATION_ERROR.getErrCode(), errorMsg);
    }

}
