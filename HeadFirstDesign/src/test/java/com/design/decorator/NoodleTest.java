package com.design.decorator;

import com.design.model.decorator.demo2noodle.BeefNoodle;
import com.design.model.decorator.demo2noodle.Noodle;
import com.design.model.decorator.demo2noodle.condiment.Beef;
import com.design.model.decorator.demo2noodle.condiment.Vegetable;
import org.junit.Test;

public class NoodleTest {

    @Test
    public void createNoodle() {
        Noodle bn = new BeefNoodle();
        bn = new Beef(bn);
        bn = new Beef(bn);
        bn = new Vegetable(bn);
        System.out.println(bn.cost() + bn.getName());

    }

}
