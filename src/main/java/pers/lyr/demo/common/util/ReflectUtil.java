package pers.lyr.demo.common.util;

import lombok.NonNull;

import pers.lyr.demo.common.annontation.DbField;
import pers.lyr.demo.common.annontation.DbFieldId;
import pers.lyr.demo.common.annontation.DbTable;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 利用反射 拼接 sql语句
 * @Author lyr
 * @create 2020/9/13 15:23
 */
public class ReflectUtil {
    public static <T> String getTableName(@NonNull T po) {
        DbTable table = po.getClass().getAnnotation(DbTable.class);
        return table.tableName();
    }

    public static <T> Map<String,Object> getPara(@NonNull T po) throws IllegalAccessException {
        Class clazz = po.getClass();
        Map<String, Object> map = new HashMap<>(16);
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(po);
            if(value!=null) {
                DbField dbField = f.getAnnotation(DbField.class);
                if(dbField!=null && dbField.exist()) {
                    map.put(dbField.value(),value);
                }
            }
        }
        return map;
    }
    public static <T> Map<String,Object> getParaForUpdate(@NonNull T po) throws IllegalAccessException {
        Class clazz = po.getClass();
        Map<String, Object> map = new HashMap<>(16);
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(po);
            if(value!=null) {
                DbFieldId dbFieldId = f.getAnnotation(DbFieldId.class);
                if(dbFieldId!=null) {
                    continue;
                }
                DbField dbField = f.getAnnotation(DbField.class);
                if(dbField!=null && dbField.exist()) {
                    map.put(dbField.value(),value);
                }
            }
        }
        return map;
    }
    public static <T> Object getById(T po) throws IllegalAccessException {
        for (Field f : po.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(po);
            if(value!=null) {
                DbFieldId dbFieldId = f.getAnnotation(DbFieldId.class);
                if(dbFieldId!=null) {
                    return value;
                }

            }
        }
        return null;
    }

    /**
     * 利用反射 拼接 sql
     * @param po   po对象
     * @param objectValueList 用来存储 po的值
     * @param <T> 动态类型
     * @return sql片段
     */
    public static <T>String getSqlFragment(@NonNull T po,final List<Object> objectValueList) {
        try {
            Map<String, Object> para = getPara(po);
            StringBuilder sb = new StringBuilder();

            para.forEach((field,value)->{
                sb.append(DbSqlUtil.andSql(field,value,objectValueList));
            });
            //返回拼接后的 sql , and name like '%小明%' and sex = 1
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 动态拼接 sql 语句 update t_teacher set name = ? , pwd = ?
     * @param po     po对象
     * @param objectValueList 存储value 的值
     * @param <T> 泛型
     * @return 返回sql语句
     */
    public static <T> String setSqlFragment(@NonNull T po, final List<Object> objectValueList) {
        try {
            Map<String, Object> para = getParaForUpdate(po);
            StringBuilder sb = new StringBuilder(" set ");
            Set<Map.Entry<String, Object>> entrySet  =para.entrySet();
            // final List<Object> list = new ArrayList();
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> cur =  iterator.next();
                //set name = "小白", pwd = "aa"
                sb.append(DbSqlUtil.setSql(cur.getKey(),cur.getValue(),objectValueList));
                if(iterator.hasNext()) {
                    //如果还有下一条 ，拼接 逗号
                    sb.append(" , ");
                }
            }
             // para.forEach((field,value)->{
            //     sb.append(DbSqlUtil.setSql(field,value,objectValueList));
            // });
            //返回拼接后的 sql , and name like '%小明%' and sex = 1
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }
}
