package org.annotation.learn;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: AnnotationExample
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8上午9:24
 */

public class AnnotationExample {


    public static void main(String[] args) throws FileNotFoundException {

        genericsTest();
    }

    @MethodInfo(author = "annotation", date = "Nov 12 2017", comments = "test annotation", revision = 2)
    @Override
    public String toString() {

        return "Override toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
