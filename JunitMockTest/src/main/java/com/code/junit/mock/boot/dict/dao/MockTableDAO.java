package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.MockTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 映射mapper.xml文件操作数据库
 * @author code
 * @Title: MockTableDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:04
 */
public interface MockTableDAO {

//    @Insert("insert into mocktable (name,data) values( #{name},#{data})")
    public Long save(MockTable mockTable);
//    @Select("select * from mocktable where id=#{id}")
    public MockTable selectById(Integer id);
//    @Update("update mocktable set name=#{name},data=#{data} where id=#{id}")
    public int updateById(MockTable mockTable);
}
