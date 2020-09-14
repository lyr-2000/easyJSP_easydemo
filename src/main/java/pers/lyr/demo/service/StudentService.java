package pers.lyr.demo.service;

import pers.lyr.demo.pojo.po.Student;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lyr
 * @create 2020/9/13 19:24
 */
public interface StudentService extends BaseService{

    /**
     * 根据 student_id 查询
     * @param s
     * @return
     */
    Student selectOneById(Student s);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Student selectStudentById(Serializable id);

    /**
     * 返回分页数据
     * @param query
     * @param page
     * @param size
     * @return
     */
    List<Student> listStudent(Student query, Integer page, Integer size);

    Long  countStudentByQuery(Student query);

    /**
     * 添加一个 Student
     * @param s
     * @return
     */
    int addOneStudent(Student s);

    int updateById(Student student);

}
