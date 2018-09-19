package com.code.junit.mock.boot.dict.dao;

import com.code.junit.mock.boot.dict.beans.User;
import com.code.junit.mock.boot.dict.beans.UserData;
import com.code.junit.mock.boot.dict.dao.provider.UserMapperProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * useGeneratedKeys 保证插入数据后可以返回主键ID
     * @param user
     * @return
     */
    @Options(useGeneratedKeys=true, keyProperty="id")
    @InsertProvider(type = UserMapperProvider.class,method = "addUser")

    Long save(User user);

    @SelectProvider(type = UserMapperProvider.class,method = "getUserDataList")
    List<UserData> getUserDataList();
}
