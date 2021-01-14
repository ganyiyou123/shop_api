package com.gyy.dao;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DataDao {
    
    Integer queryCounts(PinpaiParams params);

    List<Data> queryDatas(PinpaiParams params);

    @Insert("insert into shop_data (name,nameCH,typeId,type,isSku,isDel,createDate,createPeople) value" +
            "(#{name},#{nameCH},#{typeId},#{type},#{isSku},#{isDel},#{createDate},#{createPeople})")
    void addDatas(Data data);

    @Select("select * from shop_data where id=#{id}")
    Data upShowData(Integer id);

    @Update("update shop_data set name=#{name},nameCH=#{nameCH},typeId=#{typeId},type=#{type},isSku=#{isSku},isDel=#{isDel},updateDate=#{updateDate},createPeople=#{createPeople} " +
            "where id=#{id}")
    void updateDatas(Data data);
}
