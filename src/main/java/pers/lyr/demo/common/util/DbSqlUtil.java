package pers.lyr.demo.common.util;

import java.text.MessageFormat;
import java.util.List;

/**
 * 动态拼接 sql 语句
 * @Author lyr
 * @create 2020/9/13 15:08
 */
public class DbSqlUtil {
    /**
     * @param field 表的列名
     * @param value java 的 property的值
     * @param holder 将property 存入 holder
     * @return
     */
    public static String andFieldEqualTo(String field , Object value, List<Object> holder) {
        holder.add(value);
        return MessageFormat.format(" and {0} = ? " ,field);
    }

    /**
     * 如果是字符串 ，用 like ,否则 用 equal 等值查询
     * @param field
     * @param value
     * @param holder
     * @return
     */
    public static String andFieldLike(String field,Object value,List<Object> holder) {
        holder.add('%'+value.toString()+'%');
        return MessageFormat.format(" and {0} like ? " ,field);
    }

    /**
     *
     * @param value 值
     * @return 这个 field 是不是 字符串
     */
    public static boolean isStr(Object value) {
        return value instanceof String;
    }

    public static String andSql(String field, Object value,List<Object> holder) {
        if(isStr(value)) {
            return andFieldLike(field,value,holder);
        }
        return andFieldEqualTo(field,value,holder);
    }

    public static String setSql(String field,Object value,List<Object> holder) {
        holder.add(value);
        return field+" = ?";
    }
}
