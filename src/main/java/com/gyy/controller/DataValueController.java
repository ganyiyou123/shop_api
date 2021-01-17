package com.gyy.controller;

import com.gyy.entity.po.DataValue;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.DataValueService;
import org.springframework.web.bind.annotation.*;

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

    /*
    作用：新增属性值数据
    路径：  http://192.168.1.101:8080/api/datavalue/addvalueData
    请求：post请求
    参数：DataValue对象
    返回值：   null
    */
    @PostMapping("addvalueData")
    public ReponseData addvalueData(DataValue dd){
        ds.addvalueData(dd);
        return ReponseData.success(null);
    }

    /*
    作用：修改回显
    路径：  http://192.168.1.101:8080/api/datavalue/upShowvalueData
    请求：get请求
    参数：id
    返回值：   DataValue对象
    */
    @GetMapping("upShowvalueData")
    public  ReponseData upShowvalueData(Integer id){
        DataValue dd=ds.upShowvalueData( id);
        return ReponseData.success(dd);
    }

    /*
    作用：修改
    路径：  http://192.168.1.101:8080/api/datavalue/upvalueData
    请求：post请求
    参数：DataValue对象
    返回值：   null
    */
    @PostMapping("upvalueData")
    public  ReponseData upvalueData(DataValue da){
        ds.upvalueData( da);
        return ReponseData.success(null);
    }


    /*
    作用：删除
    路径：  http://192.168.1.101:8080/api/datavalue/delvalueData
    请求：post请求
    参数：id
    返回值：   null
    */

    @PostMapping("delvalueData")
    public ReponseData delvalueData(Integer id){
        ds.delvalueData(id);
        return ReponseData.success(null);
    }

}
