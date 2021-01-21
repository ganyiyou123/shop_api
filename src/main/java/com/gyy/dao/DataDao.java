package com.gyy.dao;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;
import org.apache.ibatis.annotations.Delete;
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

    @Update("update shop_data set name=#{name},nameCH=#{nameCH},typeId=#{typeId},type=#{type},isSku=#{isSku},updateDate=#{updateDate},createPeople=#{createPeople} " +
            "where id=#{id}")
    void updateDatas(Data data);

    @Update("update shop_data set isDel=2 where id=#{id}")
    void dleDatasByid(Integer id);

    @Select("select * from shop_data where typeId=#{typeId}")
    List<Data> queryDatasBytypeId(Integer typeId);
}
