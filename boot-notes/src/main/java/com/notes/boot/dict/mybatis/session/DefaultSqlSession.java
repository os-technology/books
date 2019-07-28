package com.notes.boot.dict.mybatis.session;

import com.notes.boot.dict.mybatis.binding.MapperProxy;
import com.notes.boot.dict.mybatis.config.MapperStatement;
import com.notes.boot.dict.mybatis.executor.DefaultMybatisExecutor;
import com.notes.boot.dict.mybatis.executor.MybatisExecutor;
import com.notes.boot.dict.mybatis.config.MybatisConfiguration;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 1. 对外提供服务，同时把请求转发给executor
 * 2. 给mapper接口生成实现类
 *
 * @author code
 * @Title: DefaultSqlSession
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/3011:36 PM
 */
public class DefaultSqlSession implements SqlSession {

    private MybatisConfiguration mybatisConfiguration;

    private MybatisExecutor executor;

    public DefaultSqlSession(MybatisConfiguration mybatisConfiguration) {
        this.mybatisConfiguration = mybatisConfiguration;
        executor = new DefaultMybatisExecutor(mybatisConfiguration);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = this.selectList(statement, parameter);
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        throw new RuntimeException("too many result ");

    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        MapperStatement ms = mybatisConfiguration.getMapperStatementMap().get(statement);
        return executor.query(ms, parameter);
    }

    /**
     * 动态代理完成mapper接口实现类的生成
     *
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> type) {
        MapperProxy mp = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, mp);
    }
}
