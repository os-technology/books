package com.notes.boot.dict.mybatis.config;

/**
 * mapper.xml解析类
 *
 * @author code
 * @Title: MapperStatement
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/3012:37 PM
 */
public class MapperStatement {
    /**
     * mapper.xml中的namespace属性
     */
    private String namespace;
    /**
     * 标签中的ID属性
     */
    private String sourceId;
    /**
     * 返回的对象类型
     */
    private String resultType;
    /**
     * 返回map类型
     */
    private ResultMapperElement resultMap;
    /**
     * 要执行的SQL语句
     */
    private String sql;

    public String getNamespace() {
        return namespace;
    }

    public MapperStatement setNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public String getSourceId() {
        return sourceId;
    }

    public MapperStatement setSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public String getResultType() {
        return resultType;
    }

    public MapperStatement setResultType(String resultType) {
        this.resultType = resultType;
        return this;
    }

    public String getSql() {
        return sql;
    }

    public MapperStatement setSql(String sql) {
        this.sql = sql;
        return this;
    }

    public ResultMapperElement getResultMap() {
        return resultMap;
    }

    public MapperStatement setResultMap(ResultMapperElement resultMap) {
        this.resultMap = resultMap;
        return this;
    }
}
