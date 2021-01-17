package com.gyy.dao;

import com.gyy.entity.po.DataValue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataValueDao {
    @Select("select a.nameCH,d.nameCH from  shop_datavalue a LEFT JOIN shop_data d  ON a.dataId=d.id")
    List<DataValue> getvalueData();
}
