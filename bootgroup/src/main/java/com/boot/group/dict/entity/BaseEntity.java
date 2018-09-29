package com.boot.group.dict.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author code
 * @Title: BaseEntity
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午2:53
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(insertable = false, updatable = false)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public BaseEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
