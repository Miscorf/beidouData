package com.mis.beidoudata.utils;

import org.springframework.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Li HuiKun
 * @Date 2022/7/22 10:06
 **/
public class ValidatorUtil {
    private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");
    public static boolean isMobile(String mobile){
        if (StringUtils.hasLength(mobile)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }

}
