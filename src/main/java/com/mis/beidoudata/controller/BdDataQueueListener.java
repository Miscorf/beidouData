package com.mis.beidoudata.controller;

import com.alibaba.fastjson.JSONObject;
import com.mis.beidoudata.mapper.MQDataMapper;
import com.mis.beidoudata.pojo.MQData;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Li HuiKun
 * @Date 2022/9/22 15:06
 **/

@Slf4j
@Component
public class BdDataQueueListener {

    @Autowired
    private MQDataMapper mqDataMapper;

    @RabbitHandler
    @RabbitListener(queues = "bd_data_queue")
    public void handleData(String json, Channel channel, Message message) throws Exception {

        log.info("收到消息:" + json);

        try {

            JSONObject data = JSONObject.parseObject(json);
            System.out.println(data);
            MQData mqData  = JSONObject.toJavaObject(data, MQData.class);
            System.out.println(mqData);
            mqDataMapper.insert(mqData);
            //todo  解析处理


        }catch (Exception e){
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);  //处理过程异常，重回队列
            log.error(e.getMessage());
            return;
        }

        // channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//确认的已正常消费处理
    }
}
