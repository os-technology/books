package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.Company;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author code
 * @Title: CompanyDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/16下午7:10
 */
public interface CompanyDAO {
    @Transactional
    public Long save(Company company);
    public Company selectById(Long id);
    @Transactional
    public int updateById(Company company);
}
