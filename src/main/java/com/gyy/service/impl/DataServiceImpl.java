package com.gyy.service.impl;

import com.gyy.dao.DataDao;
import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;
import com.gyy.service.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {
    @Resource
    private DataDao dao;

    @Override
    public Map queryDatas(PinpaiParams params) {
        Map map =new HashMap();
        Integer count =dao.queryCounts(params);
        map.put("count",count);
        List<Data> dlist=dao.queryDatas(params);
        map.put("dlist",dlist);
        return map;
    }

    @Override
    public void addDatas(Data data) {
        dao.addDatas( data);
    }
}