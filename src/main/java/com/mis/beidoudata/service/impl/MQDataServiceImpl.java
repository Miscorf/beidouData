package com.mis.beidoudata.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mis.beidoudata.mapper.MQDataMapper;
import com.mis.beidoudata.pojo.MQData;
import com.mis.beidoudata.service.MQDataService;
import com.mis.beidoudata.vo.RespBean;

@Service
@Primary
public class MQDataServiceImpl extends ServiceImpl<MQDataMapper, MQData> implements MQDataService {

    @Autowired MQDataMapper mqDataMapper;

    @Override
    public RespBean getAllMQdata() {
        // TODO Auto-generated method stub
        
        QueryWrapper<MQData> queryWrapper = new QueryWrapper<>();
        Timestamp d = new Timestamp(System.currentTimeMillis()); 
        
        queryWrapper.le("time", d);
        List<MQData> mqDatas = new ArrayList<>();
        mqDatas = mqDataMapper.selectList(queryWrapper);
        return RespBean.success(mqDatas);
    }
    
}
