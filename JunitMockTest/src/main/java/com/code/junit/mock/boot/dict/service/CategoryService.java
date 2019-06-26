package com.code.junit.mock.boot.dict.service;

import com.code.junit.mock.boot.dict.beans.CategoryDTO;

import java.util.List;

/**
 * @author code
 * @Title: CategoryService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/262:17 PM
 */
public interface CategoryService {

    List<CategoryDTO> getAllCategoryList();
}
