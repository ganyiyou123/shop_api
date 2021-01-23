package com.gyy.service;

import com.gyy.entity.po.Goods;
import com.gyy.entity.po.GoodsDatas;
import com.gyy.entity.vo.PinpaiParams;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    void addGoods(Goods goo,String nosku,String sku);

    Goods updateShowGoods(Integer id);

    void updateGoods(Goods go);

    void deleteGoods(Integer id);


    Map getGoods(PinpaiParams params);

    List<GoodsDatas> upShowgoodsDatas(Integer goodsId);
}
