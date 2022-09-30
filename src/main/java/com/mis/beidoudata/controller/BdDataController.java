package com.mis.beidoudata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.beidoudata.service.MQDataService;
import com.mis.beidoudata.vo.RespBean;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/mqdata")
public class BdDataController {
    @Autowired
    private MQDataService bdDataService;

    @RequestMapping("/get")
    public RespBean set_contour_settings(){
       
        return bdDataService.getAllMQdata();

    }

    
}
