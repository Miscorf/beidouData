package com.mis.beidoudata.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author Li HuiKun
 * @Date 2022/9/22 15:52
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mq_data")
public class MQData implements Serializable {
    private static final long serialVersionUID = 1L;

    String fromCard;
    String toCard;
    Timestamp time;
    String content;
}
