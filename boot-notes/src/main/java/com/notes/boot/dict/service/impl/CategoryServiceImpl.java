package com.notes.boot.dict.service.impl;

import com.notes.boot.dict.beans.CategoryDTO;
import com.notes.boot.dict.dao.CategoryDao;
import com.notes.boot.dict.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author code
 * @Title: CategoryServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/262:18 PM
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<CategoryDTO> getAllCategoryList() {
        return categoryDao.getCategoryList(null);
    }
}
