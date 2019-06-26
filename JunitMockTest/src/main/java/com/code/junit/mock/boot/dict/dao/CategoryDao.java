package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.Category;
import com.code.junit.mock.boot.dict.beans.CategoryDTO;

import java.util.HashMap;
import java.util.List;


public interface CategoryDao {

    Long insert(Category category);

    Long updateById(Category category);

    Category selectById(String id);

    void deleteById(String id);


    List<CategoryDTO> getCategoryList(Category category);

}
