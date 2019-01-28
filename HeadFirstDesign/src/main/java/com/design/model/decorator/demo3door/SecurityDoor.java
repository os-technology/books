package com.design.model.decorator.demo3door;

/**
 * @author code
 * @Title: SecurityDoor
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/28上午11:32
 */
public class SecurityDoor extends Door {
    @Override
    public String getPattern() {
        return " 防盗门空图案";
    }

    @Override
    public String getPatternName(){
        return " 白板";
    }
}
