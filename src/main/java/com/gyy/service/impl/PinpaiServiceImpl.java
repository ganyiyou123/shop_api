package com.gyy.service.impl;

import com.gyy.dao.PinpaiDao;
import com.gyy.entity.po.Pinpai;
import com.gyy.entity.vo.PinpaiParams;
import com.gyy.service.PinpaiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PinpaiServiceImpl implements PinpaiService {
    @Resource
    private PinpaiDao dao;


    @Override
    public Map queryDatas(PinpaiParams params) {
        Map p=new HashMap();
        Integer count =dao.queryCount(params);
        p.put("count",count);
        List<Pinpai> clist =dao.queryDatas(params);
        p.put("clist",clist);
        return p;
    }

    @Override
    public void addDatas(Pinpai pp) {
        pp.setCreateDate(new Date());
        pp.setIsDel(1);
        dao.addDatas( pp);
    }

    @Override
    public Pinpai upshowData(Integer id) {
        return dao.upshowData( id);
    }

    @Override
    public void upDatas(Pinpai pp) {
        pp.setUpdateDate(new Date());

        dao.upDatas( pp);
    }

    @Override
    public void delDatasByid(Integer id) {
        dao.delDatasByid(id);
    }


}
