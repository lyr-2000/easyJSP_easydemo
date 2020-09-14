package pers.lyr.demo;

import org.junit.Test;
import org.springframework.util.Assert;
import pers.lyr.demo.common.factory.ServiceFactory;
import pers.lyr.demo.pojo.po.Teacher;
import pers.lyr.demo.service.TeacherService;

/**
 * @Author lyr
 * @create 2020/9/13 19:37
 */
public class ServiceTest {

    TeacherService teacherService = ServiceFactory.getTeacherService();

    @Test
    public void insertWithError() {
        Assert.notNull( teacherService
                .getByTeacherId(new Teacher().setTeacherId(1)));

    }

    @Test
    public void testListstu() {
        Assert.notNull(
                teacherService.listTeacherByQuery(new Teacher().setTeacherName("林"),1,43)
        );
    }
}
