package com.boot.group.dict.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

/**
 * @author code
 * @Title: Address
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29上午10:17
 */
@Entity
@DynamicUpdate(true)
public class Address extends BaseEntity{


    private String addressName;


    public String getAddressName() {
        return addressName;
    }

    public Address setAddressName(String addressName) {
        this.addressName = addressName;
        return this;
    }


}
