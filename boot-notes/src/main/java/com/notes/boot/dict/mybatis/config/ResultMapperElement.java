package com.notes.boot.dict.mybatis.config;

import java.util.Map;

/**
 * 负责resultMap处理，暂不深入完善
 * @author code
 * @Title: ResultMapperElement
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/7/284:00 PM
 */
public class ResultMapperElement {
private String id;

private String type;

private Map<String,String> columnProperty;

    public String getId() {
        return id;
    }

    public ResultMapperElement setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public ResultMapperElement setType(String type) {
        this.type = type;
        return this;
    }

    public Map<String, String> getColumnProperty() {
        return columnProperty;
    }

    public ResultMapperElement setColumnProperty(Map<String, String> columnProperty) {
        this.columnProperty = columnProperty;
        return this;
    }
}
