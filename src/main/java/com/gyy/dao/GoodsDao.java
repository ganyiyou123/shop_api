package com.gyy.dao;

import com.gyy.entity.po.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface GoodsDao {

    @Insert("insert  into shop_goods  (name,title,pinpaiId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,author,isDel)" +
            " value (#{name},#{title},#{pinpaiId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addGoods(Goods goo);

    @Select("select * from shop_goods where id=#{id}")
    Goods updateShowGoods(Integer id);

    @Update("update shop_goods set name=#{name},title=#{title},pinpaiId=#{pinpaiId},typeId=#{typeId},productdecs=#{productdecs},price=#{price},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum},updateDate=#{updateDate},author=#{author},isDel=#{isDel} where id=#{id}")
    void updateGoods(Goods go);

    @Update("update shop_goods set idDel=2 where id=#{id}")
    void deleteGoods(Integer id);
}
