package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.MockTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author code
 * @Title: MockTableDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:04
 */

//@Mapper
public interface MockTableDAO {

    @Insert("insert into mocktable (name,data) values( #{name},#{data})")
    public int save(MockTable mockTable);
    @Select("select * from mocktable where id=#{id}")
    public MockTable selectById(Integer id);
}
