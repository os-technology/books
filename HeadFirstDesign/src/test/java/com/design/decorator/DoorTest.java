package com.design.decorator;

import com.design.model.decorator.demo3door.Door;
import com.design.model.decorator.demo3door.SecurityDoor;
import com.design.model.decorator.demo3door.patterntype.CirclePattern;
import com.design.model.decorator.demo3door.patterntype.SquarePattern;
import org.junit.Test;

/**
 * @author code
 * @Title: DoorTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/28上午11:31
 */
public class DoorTest {

    @Test
    public void DoorCreateTest(){
        Door door = new SecurityDoor();

        door = new CirclePattern(door);
        door = new SquarePattern(door);

        System.out.println(door.getPatternName());
        System.out.println(door.getPattern());
    }
}
