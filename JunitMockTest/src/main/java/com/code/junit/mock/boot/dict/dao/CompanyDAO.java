package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.Company;
import com.code.junit.mock.boot.dict.beans.MockTable;

/**
 * @author code
 * @Title: CompanyDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/16下午7:10
 */
public interface CompanyDAO {

    public Long save(Company company);
    public Company selectById(Long id);
    public int updateById(Company company);
}
