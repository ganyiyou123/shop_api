package com.gyy.service.impl;

import com.gyy.dao.GoodsDatasDao;
import com.gyy.entity.po.GoodsDatas;
import com.gyy.service.GoodsDatasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsDatasServiceImpl implements GoodsDatasService {
    @Resource
    private GoodsDatasDao dao;

    @Override
    public void addGoodsDatas(GoodsDatas gg) {
        dao.addGoodsDatas( gg);
    }
}
