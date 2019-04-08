package com.itgo.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象转换
 */
public class BeanMapUtil {

    /**
     * 对象转map
     * @param t
     * @param clazz
     * @param <T>
     * @param boo 类型  true 大写， false 原始不动
     * @return
     */
    public static <T> Map<String,Object> toMap(T t,Class<T> clazz,Boolean boo){
        Field[] fields = clazz.getDeclaredFields();

        Map<String,Object> tmpMap = new HashMap<>(fields.length);
        for(Field field:fields){

            field.setAccessible(true);// class访问权限
            try {
                if(boo)
                    tmpMap.put(field.getName().toUpperCase(),field.get(t));
                else
                    tmpMap.put(field.getName(),field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return tmpMap;
    }


    public static <T> List<Map<String,Object>> toMapList(List<T> list, Class<T> clazz){
        if(list != null){
            List<Map<String,Object>> tmpMap = new ArrayList<>(clazz.getDeclaredFields().length);
            for(T t:list){
                Map<String, Object> map = toMap(t, clazz,true);
                tmpMap.add(map);
            }
            return tmpMap;
        }else{
            return new ArrayList<>();
        }
    }

    /**
     * map 转对象
     * @param tmp key 都为大写
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromMap(Map<String,Object> tmp, Class<T> clazz){

        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field[] declaredFields = clazz.getDeclaredFields();

        try {
            for(Field field:declaredFields){
                field.setAccessible(true);

                field.set(t,tmp.get(field.getName().toUpperCase()));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> List<T> fromMapList(List<Map<String,Object>> list, Class<T> clazz){
        if(list != null){
            List<T> tmpMap = new ArrayList<>(clazz.getDeclaredFields().length);
            for(Map<String,Object> tmp:list){
                T t = fromMap(tmp, clazz);
                tmpMap.add(t);
            }
            return tmpMap;
        }else{
            return new ArrayList<>();
        }
    }

}
