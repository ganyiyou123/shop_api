package com.gyy.dao;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface DataDao {
    
    Integer queryCounts(PinpaiParams params);

    List<Data> queryDatas(PinpaiParams params);

    @Insert("insert into shop_data (name,nameCH,typeId,type,isSku,isDel,createDate,createPeople) value" +
            "(#{name},#{nameCH},#{typeId},#{type},#{isSku},#{isDel},#{createDate},#{createPeople})")
    void addDatas(Data data);
}
