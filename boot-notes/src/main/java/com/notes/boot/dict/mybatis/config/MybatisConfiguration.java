package com.notes.boot.dict.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义mybatis数据库连接解析配置
 *
 * @author code
 * @Title: MybatisConfiguration
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/301:02 PM
 */
public class MybatisConfiguration {

    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;
    /**
     * 存储SQL语句需要使用
     */
    private Map<String, MapperStatement> mapperStatementMap = new HashMap<>();


    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public MybatisConfiguration setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
        return this;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public MybatisConfiguration setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        return this;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public MybatisConfiguration setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
        return this;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public MybatisConfiguration setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
        return this;
    }

    public Map<String, MapperStatement> getMapperStatementMap() {
        return mapperStatementMap;
    }

    public MybatisConfiguration setMapperStatementMap(Map<String, MapperStatement> mapperStatementMap) {
        this.mapperStatementMap = mapperStatementMap;
        return this;
    }
}
