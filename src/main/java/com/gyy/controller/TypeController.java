package com.gyy.controller;

import com.gyy.entity.po.Type;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.TypeService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/type/")
@CrossOrigin
public class TypeController {

    @Resource
    private TypeService ts;

    /*
    作用：查询所有的分类数据
    路径：  http://192.168.1.101:8080/api/type/getData
    请求：get请求
    参数：
    返回值：   {"code":200,"message":"提示",data:[{*}]}
    */
    @GetMapping("getData")
    public ReponseData getData(){
        List<Type> tlist=ts.getData();
        return ReponseData.success(tlist);
    }

    /*
    作用：查询指定pid的数据
    路径：  http://192.168.1.101:8080/api/type/getDataByPid
    请求：post请求
    参数：
    返回值：   {"code":200,"message":"提示",data:[{*}]}
    */
    @PostMapping("getDataByPid")
    public ReponseData getDataByPid(Integer pid){
        Type ty=ts.getDataByPid( pid);
        return ReponseData.success(ty);
    }

    /*
    作用：新增分类数据
    路径：  http://192.168.1.101:8080/api/type/addTypeDate
    请求： post请求
    参数： pid    name
    返回值：   {"code":200,"message":"提示",data:[{*}]}
    */
    @PostMapping("addTypeDate")
    public ReponseData addTypeDate(Type type){
        Integer id=ts.addTypeDate(type);
        return ReponseData.success(type.getId());
    }

    /*
    作用：修改分类数据
    路径：  http://192.168.1.101:8080/api/type/upTypeDate
    请求： post请求
    参数： id （必传）     pid   name  isDel
    返回值：    {code:"",message:""}
    */
    @PostMapping("upTypeDate")
    public ReponseData upTypeDate(Type type ){//pid
        //id非空判断
        if (type.getId()==null){
            return ReponseData.error(200,"访问报错");
        }

        //根据id查出单行数据
        Type ty=ts.upTypeDateByid(type.getId());

        //如果传过来的pid name idDel 不是空的话 把通过id查出来的数据覆盖
        if(type.getPid()!=null){
            ty.setPid(type.getPid());
        }
        if(type.getName()!=null){
            ty.setName(type.getName());
        }
        if(type.getIsDel()!=null){
            ty.setIsDel(type.getIsDel());
        }
        ts.upTypeDate(ty);

        return ReponseData.success(null);
    }














}
