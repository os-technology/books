package com.notes.boot.dict.mybatis.executor;

import com.notes.boot.dict.mybatis.config.MapperStatement;

import java.util.List;

/**
 * @author code
 * @Title: MybatisExecutor
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/7/812:57 PM
 */
public interface MybatisExecutor {

    /**
     * 查询接口
     *
     * @param ms     封装SQL语句的 MappedStatement 对象
     * @param params 传入SQL的参数
     * @param <E>
     * @return 将数据转换成指定对象结果集返回
     */
    <E> List<E> query(MapperStatement ms, Object params);
}
