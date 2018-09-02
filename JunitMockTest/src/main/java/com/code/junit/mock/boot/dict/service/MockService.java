package com.code.junit.mock.boot.dict.service;

import com.code.junit.mock.boot.dict.beans.MockTable;

/**
 * @author code
 * @Title: MockService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:03
 */
public interface MockService {

    public void saveMock();

    MockTable add(MockTable mockTable);

    MockTable getById(Long id);
}
