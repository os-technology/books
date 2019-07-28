package com.notes.boot.dict.mybatis.executor;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.mybatis.binding.ReflectionUtil;
import com.notes.boot.dict.mybatis.config.MapperStatement;
import com.notes.boot.dict.mybatis.config.MybatisConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author code
 * @Title: DefaultMybatisExecutor
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/7/81:00 PM
 */
public class DefaultMybatisExecutor implements MybatisExecutor {

    private MybatisConfiguration conf;

    public DefaultMybatisExecutor(MybatisConfiguration configuration) {
        this.conf = configuration;
    }

//    @Override
//    public <E> List<E> query(MapperStatement ms, Object params) {
//        System.out.println("SQL输出：" + ms.getSql());
//        System.out.println("resultType输出：" + ms.getResultType());
//        return null;
//    }

    @Override
    public <E> List<E> query(MapperStatement ms, Object params) {
        System.out.println("SQL输出：" + ms.getSql());
//        System.out.println("resultType输出：" + ms.getResultType());
//        System.out.println("resultMap输出：" + JSON.toJSONString(ms.getResultMap()));
        //定义返回结果集
        List<E> result = new ArrayList<>();

        try {
            //加载驱动程序
            Class.forName(conf.getJdbcDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //获取连接，从MybatisConfiguration 获取数据库信息
            connection = DriverManager.getConnection(conf.getJdbcUrl(), conf.getJdbcUsername(), conf.getJdbcPassword());
            //创建 preparedStatement,从 MapperStatement 获取SQL语句
            preparedStatement = connection.prepareStatement(ms.getSql());
            //处理SQL语句中的占位符
            parameterize(preparedStatement, params);
            //执行查询操作，获取ResultSet
            resultSet = preparedStatement.executeQuery();
            //将结果集通过反射技术，填充到list中
            handleResultSet(resultSet, result, ms);

        } catch (SQLException e) {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


        return result;
    }

    /**
     * 对PreparedStatement中的占位符进行处理
     *
     * @param preparedStatement
     * @param params
     */
    private void parameterize(PreparedStatement preparedStatement, Object params) throws SQLException {
        if (params instanceof Integer) {
            preparedStatement.setInt(1, (int) params);
        } else if (params instanceof Long) {
            preparedStatement.setLong(1, (long) params);
        } else if (params instanceof String) {
            preparedStatement.setString(1, (String) params);
        }
    }

    /**
     * 读取resultSet中的数据，并转换为目标对象
     *
     * @param <E>
     */
    private <E> void handleResultSet(ResultSet resultSet, List<E> result, MapperStatement ms) {
        Class<E> clazz = null;
        String className = StringUtils.isNotEmpty(ms.getResultType()) ? ms.getResultType() : ms.getResultMap().getType();
        try {
            //通过反射获取类对象
            clazz = (Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                Object entity = clazz.newInstance();

                if (StringUtils.isNotEmpty(ms.getResultType())) {
                    ReflectionUtil.setPropToBeanFromResultSet(entity, resultSet);
                } else {
                    ReflectionUtil.setPropToBeanFromResultSet(entity, resultSet, ms.getResultMap());
                }
                result.add((E) entity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
