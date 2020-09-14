package pers.lyr.demo.common.annontation;

import java.lang.annotation.*;

/**
 * @Author lyr
 * @create 2020/9/13 15:11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DbField {
    String value() ;
    boolean exist() default true;
}
