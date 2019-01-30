package com.boot.group.dict.service;

import com.boot.group.dict.BootGroupTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author code
 * @Title: BlessRecordServiceTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/30下午2:16
 */
@RunWith(SpringRunner.class)
public class BlessRecordServiceTest extends BootGroupTest {

    @Autowired
    BlessRecordService blessRecordService;

    @Test
    public void save(){
        String data = blessRecordService.save("hello");
        Assert.assertNotNull(data);
    }
}
