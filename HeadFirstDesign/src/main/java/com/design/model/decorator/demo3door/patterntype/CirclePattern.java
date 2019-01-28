package com.design.model.decorator.demo3door.patterntype;

import com.design.model.decorator.demo3door.AbstractDoorConfig;
import com.design.model.decorator.demo3door.Door;

/**
 * @author code
 * @Title: CirclePattern
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/28上午11:21
 */
public class CirclePattern extends AbstractDoorConfig {

    private final Door door;

    public CirclePattern(Door door){
        this.door = door;
    }

    @Override
    public String getPatternName() {
        return door.getPatternName()+" 圆形图案";
    }


    @Override
    public String getPattern(){
        return door.getPattern()+" 小巧玲珑";
    }
}
