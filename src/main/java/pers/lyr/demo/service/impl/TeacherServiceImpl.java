package pers.lyr.demo.service.impl;


import org.springframework.transaction.annotation.Transactional;
import pers.lyr.demo.common.factory.DaoFactory;
import pers.lyr.demo.dao.TeacherDAO;

import pers.lyr.demo.pojo.po.Teacher;
import pers.lyr.demo.service.TeacherService;

import java.util.List;

/**
 * @Author lyr
 * @create 2020/9/13 19:26
 */
public class TeacherServiceImpl implements TeacherService {

    TeacherDAO teacherDAO = DaoFactory.getTeacherDAO();

    /**
     * 按照 id 查询结果
     *
     * @param teacher
     * @return
     */
    @Override
    public Teacher getByTeacherId(Teacher teacher) {
        return teacherDAO.selectById(teacher.getTeacherId());
    }

    @Override
    public List<Teacher> listTeacherByQuery(Teacher query, Integer page, Integer size) {
        return teacherDAO.listByObject(query,page,size);
    }



    @Override
    public void hasErrorInsert(Teacher teacher) {
        teacherDAO.insertOne(teacher);
        //出现异常，需要回滚
        int i = 0;
        int j = 1/i;
    }
}
