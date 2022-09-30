package com.mis.beidoudata.exception;

import com.mis.beidoudata.vo.RespBean;
import com.mis.beidoudata.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Author Li HuiKun
 * @Date 2022/8/23 14:19
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e){
        if (e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());
        }else if (e instanceof BindException){
            BindException ex = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数效验异常："+ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return  respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }

}
