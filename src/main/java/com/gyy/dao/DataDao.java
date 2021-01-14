package com.gyy.dao;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;

import java.util.List;

public interface DataDao {
    
    Integer queryCounts(PinpaiParams params);

    List<Data> queryDatas(PinpaiParams params);

    /*void addDatas(Data data);*/
}
