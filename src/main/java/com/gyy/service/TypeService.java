package com.gyy.service;

import com.gyy.entity.po.Type;

import java.util.List;

public interface TypeService {
    List<Type> getData();

    Type getDataByPid(Integer pid);

    Integer addTypeDate(Type type);

    Type upTypeDateByid(Integer id);

    void upTypeDate(Type ty);
}
