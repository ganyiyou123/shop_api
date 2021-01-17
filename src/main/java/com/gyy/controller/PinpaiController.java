package com.gyy.controller;

import com.gyy.entity.po.Pinpai;
import com.gyy.entity.vo.PinpaiParams;
import com.gyy.entity.vo.ReponseData;
import com.gyy.service.PinpaiService;
import com.gyy.util.FileSaveUtils;
import com.gyy.util.OssFileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/pinpai/")
@CrossOrigin
public class PinpaiController {
    @Resource
    private PinpaiService ps;

    /*
     * 查询
     * 路径为：api/pinpai/queryDatas
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
        Map pp=ps.queryDatas( params);
        return ReponseData.success(pp);
    }

    /*
     * 新增
     * 路径为：api/pinpai/addDatas
     * 请求方式为：post
     * 请求参数为：Pinpai
     * 返回值为：{null}
     * */
    @PostMapping("addDatas")
    public ReponseData addDatas(Pinpai pp){
        ps.addDatas(pp);
       return ReponseData.success(null);
    }

    /*
     * 文件上传
     * 路径为：api/pinpai/uploadFile
     * 请求方式为：post
     * 请求参数为：MultipartFile   HttpServletRequest
     * 返回值为：localhost:8080+图片路劲
     * */
    @PostMapping("uploadFile")
    public ReponseData uploadFile(MultipartFile file) throws IOException {


        String originalFilename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        newName="imgs/"+newName;
        return ReponseData.success(OssFileUtils.upFile(file.getInputStream(),newName));
    }

    /*
    * 修改回显
    * 路径：api/pinpai/upshowData
    * 请求方式：get
    * 请求参数：id
    * 返回值：pinpai对象
    * */
    @GetMapping("upshowData")
    public ReponseData upshowData(Integer id){
        Pinpai pp=ps.upshowData( id);
        return  ReponseData.success(pp);
    }

    /*
     * 修改
     * 路径：api/pinpai/upDatas
     * 请求方式：post
     * 请求参数：id
     * 返回值：{null}
     * */
    @PostMapping("upDatas")
    public ReponseData upDatas(Pinpai pp){

        ps.upDatas(pp);
        return  ReponseData.success(null);
    }

    /*
     * 删除
     * 路径：api/pinpai/delDatasByid
     * 请求方式：post
     * 请求参数：id
     * 返回值：{null}
     * */
    @PostMapping("delDatasByid")
    public ReponseData delDatasByid(Integer id){
        ps.delDatasByid(id);
        return ReponseData.success(null);
    }




}
