package com.design.model.decorator.demo3door.patterntype;

import com.design.model.decorator.demo3door.AbstractDoorConfig;
import com.design.model.decorator.demo3door.Door;

/**
 * @author code
 * @Title: SquarePattern
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/28上午11:23
 */
public class SquarePattern extends AbstractDoorConfig {

    private final Door door;

    public SquarePattern(Door door){
        this.door = door;
    }
    @Override
    public String getPatternName() {
        return door.getPatternName()+" 方形图案";
    }


    @Override
    public String getPattern(){
        return door.getPattern()+" 庄重大气";
    }

}
