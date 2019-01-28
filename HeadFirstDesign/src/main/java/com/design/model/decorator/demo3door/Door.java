package com.design.model.decorator.demo3door;

/**
 * @author code
 * @Title: Door
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/28上午11:17
 */
public abstract class Door {
    public String patternName="普通门无图案";

    public String getPatternName() {
        return patternName;
    }

    /**
     * 门的图案
     * @return
     */
    public abstract String getPattern();
}
