package com.gyy.controller;

import com.gyy.entity.po.Data;
import com.gyy.entity.vo.PinpaiParams;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.DataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/data/")
@CrossOrigin
public class DataController {
    @Resource
    private DataService ds;

    /*
     * 查询
     * 路径为：api/data/queryDatasBytypeId
     * 请求方式为：get
     * 请求参数为：typeId
     * 返回值为：{"code":200,"message":"提示",data:[{*}]}
     * */
    @GetMapping("queryDatasBytypeId")
    public  ReponseData queryDatasBytypeId(Integer typeId){
        List<Data> ddlist=ds.queryDatasBytypeId( typeId);
        return  ReponseData.success(ddlist);
    }




    /*
     * 查询
     * 路径为：api/data/queryDatas
     * 请求方式为：get
     * 请求参数为：currpage  size name
     * 返回值为：{"code":200,"message":"提示",data:[{*}]}
     * */
    @GetMapping("queryDatas")
    public ReponseData queryDatas(PinpaiParams params){
        if(params.getCurrPage()==null){
            return ReponseData.error(500,"访问错误");
        }
        if(params.getSize()==null){
            return  ReponseData.error(200,"访问报错");
        }
        Map dd =ds.queryDatas( params);
        return  ReponseData.success(dd);
    }

    /*
     * 新增
     * 路径为：api/data/addDatas
     * 请求方式为：post
     * 请求参数为：data对象
     * 返回值为：{"code":200,"message":"提示",data:null}
     * */
    @PostMapping("addDatas")
    public  ReponseData addDatas(Data data){
        ds.addDatas(data);
        return ReponseData.success(null);
    }

    /*
     * 查询回显
     * 路径为：api/data/upShowData
     * 请求方式为：get
     * 请求参数为：id
     * 返回值为：{"code":200,"message":"提示",data对象}
     * */
    @GetMapping("upShowData")
    public ReponseData upShowData(Integer id){
        Data da=ds.upShowData( id);
        return ReponseData.success(da);
    }

    /*
     * 修改
     * 路径为：api/data/updateDatas
     * 请求方式为：post
     * 请求参数为：data对象
     * 返回值为：{"code":200,"message":"提示",data：null}
     * */
    @PostMapping("updateDatas")
    public  ReponseData updateDatas(Data data){
        ds.updateDatas(data);
        return ReponseData.success(null);
    }

    /*
     * 删除
     * 路径为：api/data/dleDatasByid
     * 请求方式为：delete
     * 请求参数为：id
     * 返回值为：{"code":200,"message":"提示",data：null}
     * */
    @DeleteMapping("dleDatasByid")
    public  ReponseData dleDatasByid(Integer id){
        ds.dleDatasByid(id);
        return ReponseData.success(null);
    }

}
