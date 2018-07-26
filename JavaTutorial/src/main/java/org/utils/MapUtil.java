package org.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuijnshui
 * @Title: MapUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/26下午1:59
 */
public class MapUtil {

    public static Map<String,Object> toMap(Object clazz){
        Map<String,Object> map = new HashMap<>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            field.setAccessible(true);
            try {
                obj = field.get(clazz);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
