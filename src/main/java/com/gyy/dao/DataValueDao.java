package com.gyy.dao;

import com.gyy.entity.po.DataValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataValueDao {
    @Select("select a.nameCH,d.nameCH from  shop_datavalue a LEFT JOIN shop_data d  ON a.dataId=d.id")
    List<DataValue> getvalueData();

    @Insert("insert into shop_datavalue (name,nameCH,dataId) value (#{name},#{nameCH},#{dataId})")
    void addvalueData(DataValue dd);

    @Select("select * from shop_datavalue where id=#{id} ")
    DataValue upShowvalueData(Integer id);
}
