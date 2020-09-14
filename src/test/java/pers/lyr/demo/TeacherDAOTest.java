package pers.lyr.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import pers.lyr.demo.common.factory.DaoFactory;
import pers.lyr.demo.pojo.po.Student;
import pers.lyr.demo.pojo.po.Teacher;

import java.util.Date;

/**
 * @Author lyr
 * @create 2020/9/13 14:21
 */

public class TeacherDAOTest {

    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void selectOneTeacher() {
        // Integer id = null;
        Teacher t = DaoFactory.getTeacherDAO()
                .selectOne(new Teacher().setTeacherName("小"));
        // log.info("{}",t);
        System.out.println(t);
        Assert.notNull(t);
    }


    @Test
    public void updateByID() {
        DaoFactory.getTeacherDAO()
                .updateById(new Teacher().setTeacherId(1).setTeacherName("afajfla"));

    }

    @Test
    public void insertTeacher() {
        Teacher t = new Teacher().setTeacherName("hello world");
        int row = DaoFactory.getTeacherDAO()
                .insertOne(t);
        System.out.println(t);
        System.out.println(row);
    }

    @Test
    public void insertStudent() {
        Student s = new Student()
                .setStudentName("林东")
                .setStudentPassword("123")
                .setGmtCreate(new Date())
                .setGmtModified(new Date());
        int id = DaoFactory.getStudentDAO()
                .insertOne(s);
        System.out.println(id);
        System.out.println(s);
    }
}
