package com.notes.boot.dict.dao;

import com.notes.boot.dict.beans.Category;
import com.notes.boot.dict.beans.CategoryDTO;

import java.util.List;


public interface CategoryDao {

    Long insert(Category category);

    Long updateById(Category category);

    Category selectById(String id);

    void deleteById(String id);


    List<CategoryDTO> getCategoryList(Category category);

}
