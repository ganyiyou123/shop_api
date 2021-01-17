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
}
