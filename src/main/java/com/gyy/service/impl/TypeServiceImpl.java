package com.gyy.service.impl;

import com.gyy.dao.TypeDao;
import com.gyy.entity.po.Type;
import com.gyy.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao dao;

    @Override
    public List<Type> getData() {
        return dao.getData();
    }

    @Override
    public Type getDataByPid(Integer pid) {
        return dao.getDataByPid( pid);
    }

    @Override
    public Integer addTypeDate(Type type) {

        type.setCreateDate(new Date());
        type.setIsDel(1);
        return dao.addTypeDate(type);
    }

    @Override
    public Type upTypeDateByid(Integer id) {
        return dao.upTypeDateByid(id);
    }

    @Override
    public void upTypeDate(Type ty) {
        ty.setUpdateDate(new Date());
        dao.upTypeDate( ty);
    }


}
