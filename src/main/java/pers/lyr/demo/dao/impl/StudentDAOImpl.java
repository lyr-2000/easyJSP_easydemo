package pers.lyr.demo.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pers.lyr.demo.common.factory.JdbcTemplateFactory;
import pers.lyr.demo.common.mapper.StudentTableMapper;

import pers.lyr.demo.dao.BaseDAOImpl;
import pers.lyr.demo.dao.StudentDAO;
import pers.lyr.demo.pojo.po.Student;

/**
 * @Author lyr
 * @create 2020/9/13 19:02
 */
public class StudentDAOImpl extends BaseDAOImpl<Student> implements StudentDAO  {
    JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();
    /**
     * 获取 T 表的名字
     *
     * @return 数据库表的名字
     */
    @Override
    public String getTableName() {
        return "t_student";
    }

    /**
     * 返回映射 的实现
     *
     * @return jdbcTemplate 定义的 映射接口
     */
    @Override
    public RowMapper<Student> getRowMapper() {
        return StudentTableMapper.INSTANCE;
    }

    @Override
    public String getTableIdField() {
        return "student_id";
    }

    /**
     * 根据ID 查找
     *
     * @param query query对象
     * @return
     */
    @Override
    public Student selectById(Student query) {
        return super.selectById(query.getStudentId());
    }

    @Override
    public int insertOne(Student object) {
        String l = "insert into " +
                "t_student( student_name,student_password,student_id_card,sex,is_deleted,gmt_create,gmt_modified) values(?,?,?,?,?,?,?)";
        int row =  jdbcTemplate.update(l,
                     object.getStudentName(),
                object.getStudentPassword(),
                object.getStudentIdCard(),
                object.getSex(),
                object.getDeleted(),
                object.getGmtCreate(),
                object.getGmtModified()
                );
        if(row >0) {
            return super.getLastInsertId();
        }
        return row;
    }
}
