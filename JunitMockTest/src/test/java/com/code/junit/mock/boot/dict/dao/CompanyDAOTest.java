package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.BaseAppTest;
import com.code.junit.mock.boot.dict.beans.Company;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author code
 * @Title: CompanyDAOTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/16下午7:06
 */
@RunWith(SpringRunner.class)
public class CompanyDAOTest extends BaseAppTest {

    @Autowired
    private CompanyDAO companyDAO;

    @Test
    public void save() {
        Company company = getCompany();
        companyDAO.save(company);
        Assert.assertNotNull(company.getId());
    }

    @Test
    public void selectById() {
        Company company = getCompany();
        companyDAO.save(company);
        company = companyDAO.selectById(company.getId());
        Assert.assertNotNull(company.getCreateTime());
    }


    private Company getCompany() {
        return Company.builder().address("山东")
                .companyName("教师培训公司").build();
    }
}
