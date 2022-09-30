package com.mis.beidoudata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mis.beidoudata.pojo.MQData;
import com.mis.beidoudata.vo.RespBean;

public interface MQDataService extends IService<MQData> {
    public RespBean getAllMQdata();
}
