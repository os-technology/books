package org.annotation.basic;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: AnnotationClass
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/30下午1:37
 */
@Easy
public class AnnotationClass {

    @Easy("父类方法注解")
    public String createMsg(){
return "msg is ok";
    }
}
