package org.annotation.basic;

import java.lang.annotation.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Easy
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/5/30下午1:35
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface Easy {


    String value() default  "Annotation is Success";
}
