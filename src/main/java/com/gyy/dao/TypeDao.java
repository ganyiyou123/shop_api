package com.gyy.dao;

import com.gyy.entity.po.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TypeDao {
    @Select("select * from shop_type where isDel=1")
    List<Type> getData();

    @Select("select * from shop_type where pid=#{pid}")
    Type getDataByPid(Integer pid);

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into shop_type  (pid,name,createDate,isDel) values (#{pid},#{name},#{createDate},#{isDel})")
    Integer addTypeDate(Type type);

    @Select("select * from shop_type where id=#{id}")
    Type upTypeDateByid(Integer id);

    @Update("update shop_type set pid=#{pid},name=#{name},isDel=#{isDel},updateDate=#{updateDate} where id=#{id}  ")
    void upTypeDate(Type ty);





}
