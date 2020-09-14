package pers.lyr.demo.common.annontation;

import java.lang.annotation.*;

/**
 * @Author lyr
 * @create 2020/9/13 15:12
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DbTable {
    String tableName();
}
