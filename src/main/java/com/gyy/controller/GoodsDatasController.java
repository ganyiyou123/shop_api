package com.gyy.controller;

import com.gyy.entity.po.GoodsDatas;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.GoodsDatasService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/GoodsDatas/")
public class GoodsDatasController {
    @Resource
    private GoodsDatasService gd;

    /*
     * 新增
     * 路径为：api/GoodsDatas/addGoodsDatas
     * 请求方式为：post
     * 请求参数为：GoodsDatas
     * 返回值为：{null}
     * */
    @PostMapping("addGoodsDatas")
    public ReponseData addGoodsDatas(GoodsDatas gg){
        gd.addGoodsDatas( gg);
        return  ReponseData.success(null);
    }
}
