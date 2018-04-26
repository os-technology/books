package com.springcloud.feign.upload.client.app;

import com.springcloud.feign.upload.client.dict.service.UploadService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: UploadTests
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9上午8:18
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadTests {

    @Autowired
    private UploadService uploadService;
//    @Autowired
//    private UploadServiceTmp uploadServiceTmp;

    @Test
    @SneakyThrows
    public void testHandleFileUpload() {

        File file = new File("src/test/resources/tmp.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("upload_success",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());
//        File file = new File("upload.jpg");
//        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
//                MediaType.IMAGE_JPEG_VALUE,true,file.getName());
        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(inputStream, os);


        } catch (Exception e) {
            e.printStackTrace();
        }

        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        System.out.println("返回结果信息："+uploadService.handleUploadFile(multipartFile));
    }

    @Test
    public void testPrint() {
        System.out.println("Junit test is ok");
    }

}
