package com.gyy.service.impl;

import com.gyy.dao.DataValueDao;
import com.gyy.entity.po.DataValue;
import com.gyy.service.DataValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataValueServiceImpl implements DataValueService {
    @Resource
    private DataValueDao dao;

    @Override
    public List<DataValue> getvalueData() {
        return dao.getvalueData();
    }

    @Override
    public void addvalueData(DataValue dd) {
        dd.setIsDel(1);
        dao.addvalueData(dd);
    }

    @Override
    public DataValue upShowvalueData(Integer id) {
        return dao.upShowvalueData( id);
    }

    @Override
    public void upvalueData(DataValue da) {
        dao.upvalueData( da);
    }

    @Override
    public void delvalueData(Integer id) {
        dao.delvalueData(id);
    }
}
