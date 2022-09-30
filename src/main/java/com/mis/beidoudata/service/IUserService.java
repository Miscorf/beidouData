package com.mis.beidoudata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mis.beidoudata.pojo.User;
import com.mis.beidoudata.vo.LoginVo;
import com.mis.beidoudata.vo.RespBean;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lhk
 * @since 2022-07-22
 */
public interface IUserService extends IService<User> {

    RespBean login(LoginVo loginVo);
}
