package com.gyy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gyy.dao.GoodsDao;
import com.gyy.dao.GoodsDatasDao;
import com.gyy.entity.po.Goods;
import com.gyy.entity.po.GoodsDatas;
import com.gyy.service.GoodsService;




import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao dao;

    @Resource
    private GoodsDatasDao gdao;

    @Override
    public void addGoods(Goods goo,String nosku,String sku) {
         goo.setCreateDate(new Date());
         goo.setIsDel(1);
         //需要返回主键
        dao.addGoods( goo);
        //声明属性数据的对象
        List<GoodsDatas> dlist=new ArrayList<>();
        //批量新增
        //将nosku的josn数组 转换为json对象
        JSONArray objects = JSONObject.parseArray(nosku);
        for (int i = 0; i <objects.size() ; i++) {
            //属性对象
            GoodsDatas gd=new GoodsDatas();
            //设置对应商品的id；
            gd.setGoodsId(goo.getId());
            gd.setDataDatas(objects.get(i).toString());
            //放入集合
            dlist.add(gd);

        }
        //将sku的json数组字符串 转为json数组对象
        JSONArray objectsku = JSONObject.parseArray(sku);
        for (int i = 0; i <objectsku.size() ; i++) {
            //得到一个具体的json对象
            JSONObject dataJs = (JSONObject) objectsku.get(i);
            //构建属性数据对象
            GoodsDatas gd=new GoodsDatas();
            //设置对应商品的id
            gd.setGoodsId(goo.getId() );
            gd.setPrice(dataJs.getDouble("pricess"));
            gd.setStorcks(dataJs.getInteger("stockss"));
            dataJs.remove("price");
            dataJs.remove("storcks");
            gd.setDataDatas(objectsku.get(i).toString());
            //放到集合
            dlist.add(gd);

        }
        gdao.adds(dlist);


    }

    @Override
    public Goods updateShowGoods(Integer id) {
        return dao.updateShowGoods(id);
    }

    @Override
    public void updateGoods(Goods go) {
        go.setUpdateDate(new Date());
        dao.updateGoods( go);
    }

    @Override
    public void deleteGoods(Integer id) {
        dao.deleteGoods(id);
    }
}
