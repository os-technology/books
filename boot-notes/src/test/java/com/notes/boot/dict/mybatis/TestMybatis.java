package com.notes.boot.dict.mybatis;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.beans.User;
import com.notes.boot.dict.mybatis.mapper.UserMapper;
import com.notes.boot.dict.mybatis.session.SqlSession;
import com.notes.boot.dict.mybatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

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
    public void page() {
//        System.out.println("分页总数：3 - " + ((7 - 1) / 3 + 1 == 3));
//        System.out.println("分页总数：2 - " + ((4 - 1) / 3 + 1 == 2));
//        System.out.println("分页总数：2 - " + ((6 / 3) == 2));
//        System.out.println("分页总数：3 - " + ((8 + 1) / 3 == 3));

        int totalCount = 12;//总记录数
        int pageSize = 2;//每页记录数
        System.out.println(((totalCount-1)/pageSize+1));


    }

    @Test
    public void testFactory() {

        //1. 实例化 SqlSessionFactory，加载数据库配置文件以及mapper.xml文件到 MybatisConfiguration 对象
        SqlSessionFactory factory = new SqlSessionFactory();
        //2. 获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);

    }


    @Test
    public void testFactory2() {

        //1. 实例化 SqlSessionFactory，加载数据库配置文件以及mapper.xml文件到 MybatisConfiguration 对象
        SqlSessionFactory factory = new SqlSessionFactory();
        //2. 获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //3. 通过动态代理跨越面向接口编程和 ibatis 编程模型的鸿沟
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4. 遵循jdbc规范，通过底层的四大对象的合作完成数据查询和数据转化
        List<User> userList = userMapper.findAll();
        System.out.println("userList 查询结果：" + JSON.toJSONString(userList));

        User user  = userMapper.selectById(1);
        System.out.println("user查询结果：" + JSON.toJSONString(userList));



    }
    @Test
    public void testFactory3() {

        //1. 实例化 SqlSessionFactory，加载数据库配置文件以及mapper.xml文件到 MybatisConfiguration 对象
        SqlSessionFactory factory = new SqlSessionFactory();
        //2. 获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //3. 通过动态代理跨越面向接口编程和 ibatis 编程模型的鸿沟
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4. 遵循jdbc规范，通过底层的四大对象的合作完成数据查询和数据转化
        List<User> userList = userMapper.findAll();
        System.out.println("userList 查询结果：" + JSON.toJSONString(userList));

        User user  = userMapper.selectById(1);
        System.out.println("user查询结果：" + JSON.toJSONString(userList));



    }

    public void testAutoMapping() {
        SqlSessionFactory factory = new SqlSessionFactory();
        //2. 获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        sqlSession.getMapper(UserMapper.class);
    }
}
