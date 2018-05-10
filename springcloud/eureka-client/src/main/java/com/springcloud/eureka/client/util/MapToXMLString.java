package com.springcloud.eureka.client.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by pengying on 2016/7/22.
 */
public class MapToXMLString {

    public static String Coverter(Map<Object,Object> Param, String Rootstr) throws Exception {
        StringBuilder XMLStr = new StringBuilder();
        XMLStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        XMLStr.append("<"+Rootstr+">");
        for (Object key : Param.keySet()){
            XMLStr.append("<").append(key.toString()).append(">");
            XMLStr.append(covertStr((Object) Param.get(key)));
            XMLStr.append("</"+key.toString()+">");
        }
        XMLStr.append("</"+Rootstr+">");
        return XMLStr.toString();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static String covertStr(Object Param) throws Exception {
        StringBuilder XMLStr = new StringBuilder();
        if(Param == null){
            return "";
        }
        else if(Param.getClass() ==  String.class){
            return Param.toString();
        }else if(Param.getClass() == ArrayList.class){
            List<Object> MapList= (List<Object>) Param;
            Iterator ItList = MapList.iterator();
            while(ItList.hasNext()){
                XMLStr.append(covertStr((Object) ItList.next()));
            }
        }else if(Param.getClass() == HashMap.class){
            Map MapTemp = (HashMap) Param;
            for (Object key : MapTemp.keySet()){
                XMLStr.append("<").append(key.toString()).append(">");
                XMLStr.append(covertStr(MapTemp.get(key)));
                XMLStr.append("</").append(key.toString()).append(">");
            }
        }else{
            throw new Exception("不能识别的数据类型：" + Param.getClass().toString());
        }
        return XMLStr.toString();
    }

    public static String converter(Map<String, Object> dataMap, String Rootstr)
    {
        synchronized (MapToXMLString.class)
        {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            strBuilder.append("<"+Rootstr+">");
            Set<String> objSet = dataMap.keySet();
            for (Object key : objSet)
            {
                if (key == null)
                {
                    continue;
                }
                strBuilder.append("<").append(key.toString()).append(">");
                Object value = dataMap.get(key);
                strBuilder.append(coverter(value));
                strBuilder.append("</"+key.toString()+">");
            }
            strBuilder.append("</"+Rootstr+">");
            return strBuilder.toString();
        }
    }

    public static String coverter(Object[] objects) {
        StringBuilder strBuilder = new StringBuilder();
        for(Object obj:objects) {
            strBuilder.append("<item className=").append(obj.getClass().getName()).append(">\n");
            strBuilder.append(coverter(obj));
            strBuilder.append("</item>\n");
        }
        return strBuilder.toString();
    }

    public static String coverter(Collection<?> objects)
    {
        StringBuilder strBuilder = new StringBuilder();
        for(Object obj:objects) {
            strBuilder.append("<item className=").append(obj.getClass().getName()).append(">\n");
            strBuilder.append(coverter(obj));
            strBuilder.append("</item>\n");
        }
        return strBuilder.toString();
    }

    /**
     * Coverter.
     *
     * @param object the object
     * @return the string
     */
    @SuppressWarnings("unused")
    public static String coverter(Object object)
    {
        if (object instanceof Object[])
        {
            return coverter((Object[]) object);
        }
        if (object instanceof Collection)
        {
            return coverter((Collection<?>) object);
        }
        StringBuilder strBuilder = new StringBuilder();
        if (isObject(object))
        {
            Class<? extends Object> clz = object.getClass();
            Field[] fields = clz.getDeclaredFields();

            for (Field field : fields)
            {
                field.setAccessible(true);
                if (field == null){
                    continue;
                }
                String fieldName = field.getName();
                Object value = null;
                try
                {
                    value = field.get(object);
                }
                catch (IllegalArgumentException e)
                {
                    continue;
                }
                catch (IllegalAccessException e)
                {
                    continue;
                }
                strBuilder.append("<").append(fieldName)
                        .append(" className=\"").append(
                        value.getClass().getName()).append("\">");
                if (isObject(value)) {
                    strBuilder.append(coverter(value));
                }else if (value == null){
                    strBuilder.append("null");
                }else{
                    strBuilder.append(value.toString() + "");
                }
                strBuilder.append("</").append(fieldName).append(">");
            }
        }else if (object == null){
            strBuilder.append("null");
        }else{
            strBuilder.append(object.toString() + "");
        }
        return strBuilder.toString();
    }

    /**
     * Checks if is object.
     *
     * @param obj the obj
     *
     * @return true, if is object
     */
    private static boolean isObject(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj instanceof String)
        {
            return false;
        }
        if (obj instanceof Integer)
        {
            return false;
        }
        if (obj instanceof Double)
        {
            return false;
        }
        if (obj instanceof Float)
        {
            return false;
        }
        if (obj instanceof Byte)
        {
            return false;
        }
        if (obj instanceof Long)
        {
            return false;
        }
        if (obj instanceof Character)
        {
            return false;
        }
        if (obj instanceof Short)
        {
            return false;
        }
        if (obj instanceof Boolean)
        {
            return false;
        }
        return true;
    }
}
