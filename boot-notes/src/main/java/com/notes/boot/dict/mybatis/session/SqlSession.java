package com.notes.boot.dict.mybatis.session;

import java.util.List;

/**
 * mybatis 暴露给外部的接口，实现增删改查的能力
 *
 * @author code
 * @Title: SqlSession
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/3011:33 PM
 */
public interface SqlSession {
    /**
     * 根据传入的条件查询单一结果
     *
     * @param statement 方法对应的sql语句，namespace + id
     * @param parameter 要传入SQL语句的查询参数
     * @param <T>       返回指定的结果对象
     * @return
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 根据条件经过查询，返回泛型集合
     *
     * @param statement 方法对应的sql语句，namespace + id
     * @param parameter 要传入SQL语句的查询参数
     * @param <E>       返回指定的list
     * @return
     */
    <E> List<E> selectList(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
}
