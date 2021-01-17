package com.gyy.service;

import com.gyy.entity.po.DataValue;

import java.util.List;

public interface DataValueService {
    List<DataValue> getvalueData();

    void addvalueData(DataValue dd);

    DataValue upShowvalueData(Integer id);

    void upvalueData(DataValue da);

    void delvalueData(Integer id);
}
