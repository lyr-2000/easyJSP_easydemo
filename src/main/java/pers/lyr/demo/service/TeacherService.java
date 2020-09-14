package pers.lyr.demo.service;

import pers.lyr.demo.pojo.po.Teacher;

import java.util.List;

/**
 * @Author lyr
 * @create 2020/9/13 19:25
 */
public interface TeacherService extends BaseService{
    /**
     * 按照 id 查询结果
     * @param teacher
     * @return
     */
    Teacher getByTeacherId(Teacher teacher);

    List<Teacher> listTeacherByQuery(Teacher query,Integer page,Integer size);

    void hasErrorInsert(Teacher teacher) throws Exception;

}

