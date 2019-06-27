package com.notes.boot.dict.dao;

import com.notes.boot.dict.BaseAppTest;
import com.notes.boot.dict.beans.Category;
import com.notes.boot.dict.beans.CategoryDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author code
 * @Title: CategoryDaoTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/262:19 PM
 */
@RunWith(SpringRunner.class)
public class CategoryDaoTest extends BaseAppTest {

    @Autowired
    CategoryDao categoryDao;

    @Test
    public void getAllCategoryList(){
        List<CategoryDTO> list = categoryDao.getCategoryList(new Category());
        Assert.assertNotNull(list);
    }
}
