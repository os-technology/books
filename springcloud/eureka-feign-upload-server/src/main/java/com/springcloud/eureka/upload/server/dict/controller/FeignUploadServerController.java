package com.springcloud.eureka.upload.server.dict.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: FeignUploadServerController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9上午7:47
 */
@RestController
public class FeignUploadServerController {


//    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@RequestMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,method = RequestMethod.POST)
    public String uploadFile(@RequestPart(value = "file")MultipartFile file){
        System.out.println("上传文件名称："+file.getName());
        System.out.println(JSON.toJSONString(file));
        return file.getName();

    }
}
