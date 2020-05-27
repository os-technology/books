package org.lambda.net;

import com.alibaba.fastjson.JSON;

/**
 * @author code
 * @Title: Item
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/5/2614:51
 */
public class Item {
    public Item() {
        System.out.println("Item 无参构造函数");
    }

    public Item(int id, String name, double price) {
//        System.out.println("Item 带参构造函数 id=" + id + ",name=" + name + ",price=" + price);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public Item setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
