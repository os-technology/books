package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 无xml映射文件
 * @author code
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午12:42
 */
public interface UserDAO {
    @Select("select * from user order by create_time desc")
    public List<User> list();
}
