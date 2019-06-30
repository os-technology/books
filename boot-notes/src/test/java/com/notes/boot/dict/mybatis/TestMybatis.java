package com.notes.boot.dict.mybatis;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.beans.User;
import com.notes.boot.dict.mybatis.mapper.UserMapper;
import com.notes.boot.dict.mybatis.session.SqlSession;
import com.notes.boot.dict.mybatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author code
 * @Title: TestMybatis
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/3011:45 PM
 */
public class TestMybatis {

    /**
     * 初始化阶段
     * 读取xml配置文件和注解中的配置信息，创建配置对象，并完成各个模块的初始化工作
     */
    @Test
    public void initFactory() {
        //1. 实例化 SqlSessionFactory，加载数据库配置文件以及mapper.xml文件到 MybatisConfiguration 对象
        SqlSessionFactory factory = new SqlSessionFactory();
        //2. 获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
    }

    @Test
    public void testFactory() {

        //1. 实例化 SqlSessionFactory，加载数据库配置文件以及mapper.xml文件到 MybatisConfiguration 对象
        SqlSessionFactory factory = new SqlSessionFactory();
        //2. 获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //3. 通过动态代理跨越面向接口编程和 ibatis 编程模型的鸿沟
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4. 遵循jdbc规范，通过底层的四大对象的合作完成数据查询和数据转化
        User user = userMapper.findAll();
        System.out.println("查询结果：" + JSON.toJSONString(user));


    }
}
