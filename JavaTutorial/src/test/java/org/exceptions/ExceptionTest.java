package org.exceptions;

import org.junit.Test;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ExceptionTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/2上午11:11
 */

public class ExceptionTest {
    @Test
    public void testExcecption(){

        System.out.println(tryCatch());
    }

    private String tryCatch(){
        String out ="right";
        try {
            int a = Integer.parseInt("a");
        } catch (NumberFormatException e) {
            out = "error";
            throw new RuntimeException();
        }

        return out;
    }

}
