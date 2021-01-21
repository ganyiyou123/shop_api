package com.gyy.service;

import com.gyy.entity.po.Goods;

public interface GoodsService {
    void addGoods(Goods goo,String nosku,String sku);

    Goods updateShowGoods(Integer id);

    void updateGoods(Goods go);

    void deleteGoods(Integer id);
}
