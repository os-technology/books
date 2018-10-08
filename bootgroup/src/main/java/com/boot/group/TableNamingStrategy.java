package com.boot.group;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * NamingStrategy 被移除了，使用经过优化设计后的新 API:
 * org.hibernate.boot.model.naming.ImplicitNamingStrategy
 * 和
 * org.hibernate.boot.model.naming.PhysicalNamingStrategy
 * 表映射策略
 * 表结构，table_name  -->TableName.java
 */
public class TableNamingStrategy extends DefaultNamingStrategy {

    private static final long serialVersionUID = 1L;



    /**
     * 库表以及字段解析规则
     * <p>
     * 库表以及字段命名方式namea_nameb,对应的Java名称为nameaNameb(create_time-->createTime)
     *
     * @param original
     * @return
     */
    private String splitAndDown(String original) {
        if (original == null) {
            return null;
        }
        String[] words = original.split("(?=[A-Z])");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            if (word.length() > 0)
                sb.append(word.toLowerCase() + "_");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

	@Override
	public String classToTableName(String className) {
		return splitAndDown(className);
	}

	@Override
	public String propertyToColumnName(String propertyName) {
		return splitAndDown(propertyName);
	}
}
