package com.design.model.decorator.demo3door;

/**
 * @author code
 * @Title: AbstractDoorConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/28上午11:19
 */
public abstract class AbstractDoorConfig extends Door {
    @Override
    public String getPattern() {
        return "无图案";
    }

    @Override
    public abstract String getPatternName();
}
