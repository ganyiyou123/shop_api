package com.gyy.controller;

import com.gyy.entity.po.Goods;
import com.gyy.entity.po.GoodsDatas;
import com.gyy.entity.vo.PinpaiParams;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/goods/")
@CrossOrigin
public class GoodsController {

    @Resource
    private GoodsService gs;

    /*
     * 查询
     * 路径为：api/goods/getGoods
     * 请求方式为：get
     * 请求参数为：PinpaiParams
     * 返回值为：{list}
     * */
    @GetMapping("getGoods")
    public  ReponseData getGoods(PinpaiParams params){
        if(params.getCurrPage()==null){
            return ReponseData.error(500,"访问错误");
        }
        if(params.getSize()==null){
            return  ReponseData.error(200,"访问报错");
        }
        Map  gg=gs.getGoods( params);
        return  ReponseData.success(gg);
    }


    /*
     * 新增
     * 路径为：api/goods/addGoods
     * 请求方式为：post
     * 请求参数为：Pinpai
     * 返回值为：{null}
     * */
    @PostMapping("addGoods")
    public ReponseData addGoods(Goods goo,String nosku,String sku){
        gs.addGoods(goo,nosku,sku);
        return  ReponseData.success(null);
    }



    /*
     * 修改回显
     * 路径为：api/goods/updateShowGoods
     * 请求方式为：get
     * 请求参数为：id;
     * 返回值为：{goods}
     * */
    @GetMapping("updateShowGoods")
    public ReponseData updateShowGoods(Integer id){

        Goods goo=gs.updateShowGoods(id);
        return  ReponseData.success(goo);
    }

    /*
     * 修改
     * 路径为：api/goods/updateGoods
     * 请求方式为：post
     * 请求参数为：Goods
     * 返回值为：{null}
     * */
    @PostMapping("updateGoods")
    public ReponseData updateGoods(Goods go){
        gs.updateGoods(go);
        return  ReponseData.success(null);
    }

    /*
     * 删除
     * 路径为：api/goods/deleteGoods
     * 请求方式为：post
     * 请求参数为：id
     * 返回值为：{null}
     * */
    @PostMapping("deleteGoods")
    public ReponseData deleteGoods(Integer id){
        gs.deleteGoods(id);
        return  ReponseData.success(null);
    }

    /*
     * 属性值回显
     * 路径为：api/goods/upShowgoodsDatas
     * 请求方式为：get
     * 请求参数为：goodsId
     * 返回值为：{GoodsDatas}
     * */
    @GetMapping("upShowgoodsDatas")
    public  ReponseData upShowgoodsDatas(Integer goodsId){

      return ReponseData.success(gs.upShowgoodsDatas( goodsId));
    }



}
