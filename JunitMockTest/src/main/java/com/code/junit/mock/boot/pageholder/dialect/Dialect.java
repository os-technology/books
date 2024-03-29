package com.code.junit.mock.boot.pageholder.dialect;

import com.code.junit.mock.boot.pageholder.model.Order;
import com.code.junit.mock.boot.pageholder.model.PageBounds;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.SimpleTypeRegistry;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.util.*;

/**
 * @author code
 * @Title: Dialect
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2上午10:03
 */
public class Dialect {


    protected TypeHandlerRegistry typeHandlerRegistry;
    protected MappedStatement mappedStatement;
    protected PageBounds pageBounds;
    protected Object parameterObject;
    protected BoundSql boundSql;
    protected List<ParameterMapping> parameterMappings;
    protected Map<String, Object> pageParameters = new HashMap<String, Object>();

    private String pageSQL;
    private String countSQL;

    public Dialect(MappedStatement mappedStatement, Object parameterObject,
                   PageBounds pageBounds) {
        this.mappedStatement = mappedStatement;
        this.parameterObject = parameterObject;
        this.pageBounds = pageBounds;
        this.typeHandlerRegistry = mappedStatement.getConfiguration()
                .getTypeHandlerRegistry();

        init();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void init() {
        boundSql = mappedStatement.getBoundSql(parameterObject);
        parameterMappings = new ArrayList<ParameterMapping>(
                boundSql.getParameterMappings());
        if (parameterObject instanceof Map) {
            pageParameters.putAll((Map) parameterObject);
        } else if (parameterObject != null) {
            Class cls = parameterObject.getClass();
            if (cls.isPrimitive() || cls.isArray()
                    || SimpleTypeRegistry.isSimpleType(cls)
                    || Enum.class.isAssignableFrom(cls)
                    || Collection.class.isAssignableFrom(cls)) {
                for (ParameterMapping parameterMapping : parameterMappings) {
                    pageParameters.put(parameterMapping.getProperty(),
                            parameterObject);
                }
            } else {
                MetaObject metaObject = mappedStatement.getConfiguration()
                        .newMetaObject(parameterObject);
                ObjectWrapper wrapper = metaObject.getObjectWrapper();
                for (ParameterMapping parameterMapping : parameterMappings) {
                    PropertyTokenizer prop = new PropertyTokenizer(
                            parameterMapping.getProperty());
                    pageParameters.put(parameterMapping.getProperty(),
                            wrapper.get(prop));
                }
            }

        }

        StringBuffer bufferSql = new StringBuffer(boundSql.getSql().trim());
        if (bufferSql.lastIndexOf(";") == bufferSql.length() - 1) {
            bufferSql.deleteCharAt(bufferSql.length() - 1);
        }
        String sql = bufferSql.toString();
        pageSQL = sql;
        if (pageBounds.getOrders() != null && !pageBounds.getOrders().isEmpty()) {
            pageSQL = getSortString(sql, pageBounds.getOrders());
        }
        if (pageBounds.getOffset() != RowBounds.NO_ROW_OFFSET
                || pageBounds.getLimit() != RowBounds.NO_ROW_LIMIT) {
            pageSQL = getLimitString(pageSQL, "__offset",
                    pageBounds.getOffset(), "__limit", pageBounds.getLimit());
        }

        countSQL = getCountString(sql);
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public Object getParameterObject() {
        return pageParameters;
    }

    public String getPageSQL() {
        return pageSQL;
    }

    @SuppressWarnings("rawtypes")
    protected void setPageParameter(String name, Object value, Class type) {
        ParameterMapping parameterMapping = new ParameterMapping.Builder(
                mappedStatement.getConfiguration(), name, type).build();
        parameterMappings.add(parameterMapping);
        pageParameters.put(name, value);
    }

    public String getCountSQL() {
        return countSQL;
    }

    /**
     * 将sql变成分页sql语句
     */
    protected String getLimitString(String sql, String offsetName, int offset,
                                    String limitName, int limit) {
        throw new UnsupportedOperationException("paged queries not supported");
    }

    /**
     * 将sql转换为总记录数SQL
     *
     * @param sql
     *            SQL语句
     * @return 总记录数的sql
     */
    protected String getCountString(String sql) {
        return "select count(1) from (" + sql + ") tmp_count";
    }

    /**
     * 将sql转换为带排序的SQL
     *
     * @param sql
     *            SQL语句
     * @return 总记录数的sql
     */
    protected String getSortString(String sql, List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return sql;
        }

        StringBuffer buffer = new StringBuffer("select * from (").append(sql)
                .append(") temp_order order by ");
        for (Order order : orders) {
            if (order != null) {
                buffer.append(order.toString()).append(", ");
            }

        }
        buffer.delete(buffer.length() - 2, buffer.length());
        return buffer.toString();
    }
}
