package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.MockTable;

/**
 * 映射mapper.xml文件操作数据库
 * @author code
 * @Title: MockTableDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:04
 */
public interface MockTableDAO {

    public Long save(MockTable mockTable);
    public MockTable selectById(Long id);
    public int updateById(MockTable mockTable);
}
