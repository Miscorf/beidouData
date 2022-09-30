package com.mis.beidoudata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mis.beidoudata.exception.GlobalException;
import com.mis.beidoudata.mapper.UserMapper;
import com.mis.beidoudata.pojo.User;
import com.mis.beidoudata.service.IUserService;
import com.mis.beidoudata.utils.MD5Util;
import com.mis.beidoudata.utils.ValidatorUtil;
import com.mis.beidoudata.vo.LoginVo;
import com.mis.beidoudata.vo.RespBean;
import com.mis.beidoudata.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lhk
 * @since 2022-07-22
 */
@Service
@Primary
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /*
     * @Author Li HuiKun
     * @Description 登录
     * @Param loginVo
     * @return respBean
     **/
    @Override
    public RespBean login(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.hasLength(mobile)||StringUtils.hasLength(password)){
            return RespBean.error(RespBeanEnum.LOGINVO_ERROR,null);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR,null);
        }
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null==user){
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }
        //校验密码
        if
        (!MD5Util.formPassToDBPass(password).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.BIND_ERROR);
        }
        return RespBean.success();

    }
}
