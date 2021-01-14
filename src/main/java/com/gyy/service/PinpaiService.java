package com.gyy.service;

import com.gyy.entity.po.Pinpai;
import com.gyy.entity.vo.PinpaiParams;

import java.util.List;
import java.util.Map;

public interface PinpaiService {

    Map queryDatas(PinpaiParams params);

    void addDatas(Pinpai pp);

    Pinpai upshowData(Integer id);

    void upDatas(Pinpai pp);


    void delDatasByid(Integer id);
}
