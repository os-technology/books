package com.spring.source.code.beans.ch5.circle_dependency;

/**
 * @author code
 * @Title: TestA
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午3:39
 */
public class TestA {

    private TestB testB;

    public TestA(TestB testB){
        this.testB =testB;
    }

    public void a(){
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public TestA setTestB(TestB testB) {
        this.testB = testB;
        return this;
    }
}
