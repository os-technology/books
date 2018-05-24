package com.wisely.highlight.springmvc.ch4.c4_basicconfig.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ViewController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/23下午2:28
 */
@Controller
public class UploadController {

    //http://localhost:8080/boot/springmvc4/toUpload
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){//使用 MultipartFile 接受上传的文件

        try {
            //使用 FileUtils.writeByteArrayToFile 快速写文件到磁盘，中文乱码未解决
            FileUtils.writeByteArrayToFile(new File("/Users/yujinshui/Desktop/个人处理/upload/"+file.getOriginalFilename()),file.getBytes());
            return "OK";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }

}
