package pers.lyr.demo.common.annontation;

import java.lang.annotation.*;

/**
 * @Author lyr
 * @create 2020/9/13 16:24
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DbFieldId   {


}
