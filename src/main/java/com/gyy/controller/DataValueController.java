package com.gyy.controller;

import com.gyy.entity.po.DataValue;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.DataValueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/datavalue")
public class DataValueController {
    @Resource
    private DataValueService ds;

    /*
    作用：查询所有的属性值数据
    路径：  http://192.168.1.101:8080/api/datavalue/getvalueData
    请求：get请求
    参数：
    返回值：   {"code":200,"message":"提示",data:[{*}]}
    */
    @GetMapping("getvalueData")
    public ReponseData getvalueData(){
        List<DataValue> dlist= ds.getvalueData();
        return  ReponseData.success(dlist);
    }

}
