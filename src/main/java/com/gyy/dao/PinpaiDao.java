package com.gyy.dao;

import com.gyy.entity.po.Pinpai;
import com.gyy.entity.vo.PinpaiParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PinpaiDao {



    Integer queryCount(PinpaiParams params);


    List<Pinpai> queryDatas(PinpaiParams params);

    @Insert("insert into shop_pinpai (name,bandE,imgPath,bandDesc,ord,isDel,createDate) " +
            "value (#{name},#{bandE},#{imgPath},#{bandDesc},#{ord},#{isDel},#{createDate})")
    void addDatas(Pinpai pp);

    @Select("select * from shop_pinpai where id=#{id}")
    Pinpai upshowData(Integer id);

    @Update("update shop_pinpai set name=#{name},bandE=#{bandE},imgPath=#{imgPath},bandDesc=#{bandDesc},ord=#{ord},updateDate=#{updateDate} where id=#{id}")
    void upDatas(Pinpai pp);


    @Update("update shop_pinpai set isDel=2 where id=#{id}")
    void delDatasByid(Integer id);
}
