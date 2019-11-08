package com.notes.boot.dict.mybatis.mapper;

import com.notes.boot.dict.beans.User;

import java.util.List;

/**
 * @author code
 * @Title: UserMapper
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/3012:41 PM
 */
public interface UserMapper {

    List<User> findAll();
    User selectById(long id);
    User selectByPrimaryKey(long id);
}
