package com.wisely.highlight.springmvc.ch4.c3_annotation;

/**
 * 此类用来演示获取request对象参数和返回此对象到response
 * @author yuijnshui@lxfintech.com
 * @Title: DemoObj
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/20下午6:41
 */

public class DemoObj {

    private Long id;
    private String name;

    public DemoObj() {//jackson对对象和JSON做转换时一定需要此空构造
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public DemoObj setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DemoObj setName(String name) {
        this.name = name;
        return this;
    }
}
