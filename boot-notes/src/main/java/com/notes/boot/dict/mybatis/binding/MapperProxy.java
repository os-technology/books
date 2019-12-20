package com.notes.boot.dict.mybatis.binding;

import com.notes.boot.dict.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author code
 * @Title: MapperProxy
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/7/138:08 AM
 */
public class MapperProxy implements InvocationHandler {

    /**
     * 由于所有的请求都要转发给sqlsession，所以在这里要将sqlsession传递进来
     */
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 第六步
     * 该方法只用于实现接口类的方法的业务逻辑(此处指Mapper接口类)
     * 实现过程：
     * 1. 找到session中对应的方法执行
     * 2. 找到命名空间和方法名
     * 3. 传递参数
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取返回类型信息
        Class<?> returnType = method.getReturnType();
        //判断返回类型是否为Collection的子类
        if (Collection.class.isAssignableFrom(returnType)) {
            return sqlSession.selectList(method.getDeclaringClass().getName() + "." + method.getName(),
                    args == null ? null : args[0]);//mybatis默认只支持一个参数，如果是多个参数，需要放入map中
        }
        return sqlSession.selectOne(method.getDeclaringClass().getName() + "." + method.getName(),
                args == null ? null : args[0]);//mybatis默认只支持一个参数，如果是多个参数，需要放入map中
    }
}
