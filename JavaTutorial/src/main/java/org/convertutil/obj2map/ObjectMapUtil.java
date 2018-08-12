package org.convertutil.obj2map;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author code
 * @Title: ObjectMapUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/12上午10:38
 */
public class ObjectMapUtil {


    public static Map object2Map(Object obj){
        Map<String,Object> map = new HashMap<>();

        String json = JSON.toJSONString(obj);

        map = JSON.parseObject(json,HashMap.class);

        return map;
    }




    public static <T> T map2Object(Map map,Class<T> clazz){
        String json = JSON.toJSONString(map);

        return JSON.parseObject(json,clazz);
    }
    /**
     * 递归遍历JSON对象。
     *
     * @param JsonToMap
     * @return
     *
     *
     */
//    public static Map<String,Object> IteratorHash(JSONObject JsonToMap){
//        Iterator<?> it = JsonToMap.keys();
//        HashMap<String, Object> RMap = new HashMap<String, Object>();
//        while(it.hasNext()){
//            String key = String.valueOf(it.next());
//            if(JsonToMap.get(key).getClass() == JSONArray.class){//判是否为列表
//
//                if(JsonToMap.getJSONArray(key).isEmpty()){//判列表是否为空
//                    RMap.put(key,null);
//                }else{
//
//                    List<Map<String,Object>> MapListObj=new ArrayList<Map<String,Object>>();
//                    for(Object JsonArray : JsonToMap.getJSONArray(key)){
//                        HashMap<String, Object> TempMap = new HashMap<String, Object>();
//                        TempMap.putAll(IteratorHash(JSONObject.fromObject(JsonArray)));
//                        MapListObj.add(TempMap);
//                    }
//                    RMap.put(key, (Object) MapListObj);
//                }
//            }else if(JsonToMap.get(key).getClass() == JSONObject.class){
//
//                RMap.putAll(IteratorHash(JsonToMap.getJSONObject(key)));
//
//            }else if(JsonToMap.get(key).getClass() == String.class){
//
//                RMap.put(key, JsonToMap.get(key));
//
//            }
//        }
//
//        return RMap;
//    }
}
