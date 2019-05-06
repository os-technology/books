package com.boot.group.dict.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author code
 * @Title: BlessRecordService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/30下午2:07
 */
public interface BlessRecordService {

    void asyncMethod(Object obj);

    public String save(String name);
}
