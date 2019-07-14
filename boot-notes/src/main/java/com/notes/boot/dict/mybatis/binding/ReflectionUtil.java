package com.notes.boot.dict.mybatis.binding;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.beans.User;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author code
 * @Title: ReflectionUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/7/147:41 PM
 */
public class ReflectionUtil {

    /**
     * 为指定的bean的propName属性的值设为value
     *
     * @param bean     bean对象
     * @param propName 属性名
     * @param value    属性值
     */
    public static void setPropToBean(Object bean, String propName, Object value) {
        Field f = null;
        Class<?> clazz = bean.getClass();
        //针对当前类的属性赋值过程
        try {
            f = bean.getClass().getDeclaredField(propName);//获得对象指定的属性
            f.setAccessible(true);//将字段设置为可通过反射进行访问
            f.set(bean, value);//为属性赋值

        } catch (NoSuchFieldException e) {
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
        }

        //针对父类的属性赋值过程
        while (clazz != null) {
            clazz = clazz.getSuperclass();
            try {
                if (clazz == null) {
                    break;
                }
                f = clazz.getDeclaredField(propName);
            } catch (NoSuchFieldException e) {
                continue;
            } catch (SecurityException e) {
                e.printStackTrace();
            }

            try {
                f.setAccessible(true);//将字段设置为可通过反射进行访问
                f.set(bean, value);//为属性赋值
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 从ResultSet中读取一行数据，并填充至指定的实体bean
     *
     * @param entity    待填充的实体bean
     * @param resultSet 从数据库加载的数据
     * @throws SQLException
     */
    public static void setPropToBeanFromResultSet(Object entity, ResultSet resultSet) throws SQLException {
        //通过反射获取对象所有字段
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {//遍历所有字段，从ResultSet中读取相应的数据，并填充至对象的属性中
            if (fields[i].getType().getSimpleName().equals("String")) {//如果是字符串类型的数据
                setPropToBean(entity, fields[i].getName(), resultSet.getString(fields[i].getName()));
            } else if (fields[i].getType().getSimpleName().equals("Long")) {//如果是字符串类型的数据
                setPropToBean(entity, fields[i].getName(), resultSet.getLong(fields[i].getName()));
            } else if (fields[i].getType().getSimpleName().equals("Integer")) {//如果是字符串类型的数据
                setPropToBean(entity, fields[i].getName(), resultSet.getInt(fields[i].getName()));
            }
        }
    }

    public static void main(String[] args) {
        User user = new User();

        ReflectionUtil.setPropToBean(user, "username", "张三");
        ReflectionUtil.setPropToBean(user, "address", "北京");
        System.out.println(JSON.toJSONString(user));
    }
}
