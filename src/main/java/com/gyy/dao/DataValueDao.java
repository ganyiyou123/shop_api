package com.gyy.dao;

import com.gyy.entity.po.DataValue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DataValueDao {
    @Select("select a.nameCH,d.nameCH from  shop_datavalue a LEFT JOIN shop_data d  ON a.dataId=d.id where a.isDel=1" )
    List<DataValue> getvalueData();

    @Insert("insert into shop_datavalue (name,nameCH,dataId,isDel) value (#{name},#{nameCH},#{dataId},#{isDel})")
    void addvalueData(DataValue dd);

    @Select("select * from shop_datavalue where id=#{id} ")
    DataValue upShowvalueData(Integer id);

    @Update("update shop_datavalue set name=#{name},nameCH=#{nameCH} where id=#{id}")
    void upvalueData(DataValue da);


    @Update("update shop_datavalue set isDel=2 where id=#{id}")
    void delvalueData(Integer id);
}
