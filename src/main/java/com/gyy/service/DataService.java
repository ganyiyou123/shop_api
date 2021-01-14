package com.gyy.service;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;

import java.util.Map;

public interface DataService {
    Map queryDatas(PinpaiParams params);

    /*void addDatas(Data data);*/
}
