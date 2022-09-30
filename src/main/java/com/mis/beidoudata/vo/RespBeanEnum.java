package com.mis.beidoudata.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author Li HuiKun
 * @Date 2022/7/22 10:03
 **/
@ToString
@Getter
@AllArgsConstructor

public enum RespBeanEnum {
    SUCCESS(200,"success"),
    ERROR(500,"服务端异常"),

    //BIND ERROR
    BIND_ERROR(500100,"绑定异常"),


    //登录模块5002xx
    SESSION_ERROR(500210,"session不存在或者已经失效"),
    LOGINVO_ERROR(500211,"用户名或者密码错误"),
    MOBILE_ERROR(500212,"手机号码格式错误"),

    //读取Contour文件
    FILE_NOT_FOUND(902,"系统找不到文件"),
    READ_FAIL(901,"读取文件失败"),

    CONTOUR_SETTINGS_ERROR(903,"等高线图配置错误"),
    CONTOUR_SETTINGS_EMPTY(904,"等高线配置为空");
    private final Integer code;
    private final String message;
}
