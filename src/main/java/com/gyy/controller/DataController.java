package com.gyy.controller;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/data/")
public class DataController {
    @Resource
    private DataService ds;

    /*
     * 查询
     * 路径为：api/data/queryDatas
     * 请求方式为：get
     * 请求参数为：currpage  size name
     * 返回值为：{"code":200,"message":"提示",data:[{*}]}
     * */
    @GetMapping("queryDatas")
    public ReponseData queryDatas(PinpaiParams params){
        if(params.getCurrPage()==null){
            return ReponseData.error(500,"访问错误");
        }
        if(params.getSize()==null){
            return  ReponseData.error(200,"访问报错");
        }
        Map dd =ds.queryDatas( params);
        return  ReponseData.success(dd);
    }

    /*
     * 新增
     * 路径为：api/data/addDatas
     * 请求方式为：post
     * 请求参数为：data对象
     * 返回值为：{"code":200,"message":"提示",data:null}
     * */
    /*@PostMapping("addDatas")
    public  ReponseData addDatas(Data data){
        ds.addDatas(data);
        return ReponseData.success(null);
    }*/
}
