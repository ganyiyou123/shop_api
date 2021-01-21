package com.gyy.service;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;

import java.util.List;
import java.util.Map;

public interface DataService {
    Map queryDatas(PinpaiParams params);

    void addDatas(Data data);

    Data upShowData(Integer id);

    void updateDatas(Data data);

    void dleDatasByid(Integer id);

    List<Data> queryDatasBytypeId(Integer typeId);
}
