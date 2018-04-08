package org.annotation.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: AnnotationTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/30下午1:40
 */

public class AnnotationTest {

    public static void main(String[] args) {


        try {
            Class class0 = Class.forName("org.annotation.basic.AnnotationClass");
            //获取类注解信息
            Annotation[] annos = class0.getAnnotations();
            for (Annotation an:annos){
                if (an instanceof Easy){
                    System.out.println(
                "AnnotationClass:"+((Easy) an).value());
                }
            }

            //获取方法注解信息
            Method[] methods = class0.getMethods();

            for (Method method:methods){
                if (method.isAnnotationPresent(Easy.class)){
                    Easy methodAnnotation = method.getAnnotation(Easy.class);
                    System.out.println("method annotation:"+methodAnnotation.value());
                }
            }

            //获取AnnotationClass类的子类AnnotationSubClass的注解
            Class class1 = AnnotationSubClass.class;
            if (class1.isAnnotationPresent(Easy.class)){
                Easy subAnnotation = (Easy) class1.getAnnotation(Easy.class);
                System.out.println("AnnotationSubClass :"+subAnnotation.value());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
