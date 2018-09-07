package com.springcloud.feign.upload.client.dict.service;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: UploadService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9上午8:04
 */
//@FeignClient("123")
@FeignClient(name = "eureka-feign-upload-server", configuration = UploadService.MultipartSupportConfig.class)
public interface UploadService {

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleUploadFile(@RequestPart(value = "file") MultipartFile file);


    @Configuration
    class MultipartSupportConfig {


        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
