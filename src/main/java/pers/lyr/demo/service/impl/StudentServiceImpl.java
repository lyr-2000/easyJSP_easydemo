package pers.lyr.demo.service.impl;

import lombok.NonNull;
import pers.lyr.demo.common.factory.DaoFactory;
import pers.lyr.demo.dao.StudentDAO;
import pers.lyr.demo.pojo.po.Student;
import pers.lyr.demo.service.StudentService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lyr
 * @create 2020/9/13 19:26
 */
public class StudentServiceImpl implements StudentService {
    StudentDAO studentDAO = DaoFactory.getStudentDAO();
    @Override
    public Student selectOneById(Student s) {
        return studentDAO.selectById(s);
    }

    @Override
    public Student selectStudentById(Serializable id) {
        return studentDAO.selectById(id);
    }

    @Override
    public List<Student> listStudent(Student query, Integer page, Integer size) {
        return studentDAO.listByObject(query,page,size);

    }

    /**
     * 添加一个 Student
     *
     * @param s
     * @return
     */
    @Override
    public int addOneStudent(@NonNull Student s) {
        return studentDAO.insertOne(s);
    }

    @Override
    public Long countStudentByQuery(Student query) {
        return studentDAO.countByQuery(query);
    }

    @Override
    public int updateById(Student student) {
        return studentDAO.updateById(student);
    }
}
