package pers.lyr.demo;

import org.junit.Test;
import pers.lyr.demo.common.util.ReflectUtil;
import pers.lyr.demo.pojo.po.Teacher;

/**
 * @Author lyr
 * @create 2020/9/13 15:31
 */
public class ReflectUtilTest {

    @Test
    public void printPara() {
        Teacher ll = new Teacher().setTeacherName("锐哥");
        try {
            System.out.println(ReflectUtil.getPara(ll));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
