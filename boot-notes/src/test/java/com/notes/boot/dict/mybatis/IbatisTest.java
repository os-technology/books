package com.notes.boot.dict.mybatis;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.beans.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author code
 * @Title: IbatisTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/10/303:18 PM
 */
public class IbatisTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        //--------------------第一阶段---------------------------
        // 1.读取mybatis配置文件创SqlSessionFactory
        String resource = "ibatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.读取mybatis配置文件创SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }
    @Test
    public void selectList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> user = sqlSession.selectList("com.notes.boot.dict.mybatis.mapper.UserMapper.findList");
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void selectOne(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("com.notes.boot.dict.mybatis.mapper.UserMapper.selectByPrimaryKey",1L);
        System.out.println(JSON.toJSONString(user));
    }
}
