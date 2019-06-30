package com.notes.boot.dict.mybatis.session;

import com.notes.boot.dict.mybatis.config.MybatisConfiguration;

import java.util.List;

/**
 * @author code
 * @Title: DefaultSqlSession
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/3011:36 PM
 */
public class DefaultSqlSession implements SqlSession {

    private MybatisConfiguration mybatisConfiguration;

    public DefaultSqlSession(MybatisConfiguration mybatisConfiguration) {
        this.mybatisConfiguration = mybatisConfiguration;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return null;
    }
}
