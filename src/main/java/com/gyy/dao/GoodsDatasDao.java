package com.gyy.dao;

import com.gyy.entity.po.GoodsDatas;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface GoodsDatasDao {

    @Insert("insert into shop_goodsdatas (goodsId,dataDatas,storcks,price) " +
            "value (#{goodsId},#{dataDatas},#{storcks},#{price})")
    void addGoodsDatas(GoodsDatas gg);

    @Insert("<script>insert into shop_goodsdatas (goodsId,dataDatas,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.goodsId},#{a.dataDatas},#{a.storcks},#{a.price} )  </foreach> </script>")
    void adds(List<GoodsDatas> dlist);
}
