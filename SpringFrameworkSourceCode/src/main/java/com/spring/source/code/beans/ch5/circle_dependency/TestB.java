package com.spring.source.code.beans.ch5.circle_dependency;

/**
 * @author code
 * @Title: TestB
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午3:39
 */
public class TestB {

    private TestC testC;

    public TestB(TestC testC){
        this.testC = testC;
    }

    public void b() {
        testC.c();
    }

    public TestC getTestC() {
        return testC;
    }

    public TestB setTestC(TestC testC) {
        this.testC = testC;
        return this;
    }
}
