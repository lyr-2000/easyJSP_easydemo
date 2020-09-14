package pers.lyr.demo.common.factory;

import pers.lyr.demo.dao.StudentDAO;
import pers.lyr.demo.dao.TeacherDAO;
import pers.lyr.demo.dao.impl.StudentDAOImpl;
import pers.lyr.demo.dao.impl.TeacherDAOImpl;

/**
 * @Author lyr
 * @create 2020/9/13 13:15
 */
public class DaoFactory {
    public static TeacherDAO getTeacherDAO() {
        return new TeacherDAOImpl();
    }

    public static StudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }
}
