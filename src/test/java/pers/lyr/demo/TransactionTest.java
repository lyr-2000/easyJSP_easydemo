package pers.lyr.demo;

import org.junit.Test;
import pers.lyr.demo.common.factory.ServiceFactory;
import pers.lyr.demo.pojo.po.Teacher;
import pers.lyr.demo.service.TeacherService;

/**
 * @Author lyr
 * @create 2020/9/13 20:27
 */
public class TransactionTest {


    TeacherService teacherService = ServiceFactory.getTeacherService();


    @Test
    public void insertError() {
        try {
            teacherService.hasErrorInsert(new Teacher().setTeacherName("这个不能被插入"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
