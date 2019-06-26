package com.code.junit.mock.boot.dict.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhanggf
 * @Date: 2018/9/14 15:28
 */
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = -1365331719532097943L;

    /**
     * 父类id
     */
    private String pid;
    /**
     * 品类id
     */
    private String categoryId;
    /**
     * 品类id
     */
    private Integer status;
    /**
     * 品类id
     */
    private Integer type;
    /**
     * 品类级别 1一级2二级3三级
     */
    private Integer level;
    /**
     * 品类id
     */
    private Integer sort;

    /**
     * 品类名称
     */
    private String categoryName;
    /**
     * 品类分类
     */
    private String categoryCode;
    /**
     * 品类图片
     */
    private String imgUrl;
    /**
     * 子品类列表
     */
    private List<CategoryDTO> childList;


    public String getPid() {
        return pid;
    }

    public CategoryDTO setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public CategoryDTO setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public CategoryDTO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public CategoryDTO setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public CategoryDTO setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public CategoryDTO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryDTO setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public CategoryDTO setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CategoryDTO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public List<CategoryDTO> getChildList() {
        return childList;
    }

    public CategoryDTO setChildList(List<CategoryDTO> childList) {
        this.childList = childList;
        return this;
    }
}
