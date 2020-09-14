package pers.lyr.demo.common.mapper;


import org.springframework.jdbc.core.RowMapper;
import pers.lyr.demo.pojo.po.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author lyr
 * @create 2020/9/13 14:52
 */
public class StudentTableMapper implements RowMapper<Student> {
    public static final StudentTableMapper INSTANCE = new StudentTableMapper();
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student()
                .setStudentId(resultSet.getInt("student_id"))
                .setStudentIdCard(resultSet.getString("student_id_card"))
                .setStudentName(resultSet.getString("student_name"))
                .setStudentPassword(resultSet.getString("student_password"))
                .setDeleted(resultSet.getInt("is_deleted"))
                .setSex(resultSet.getInt("sex"))
                .setGmtCreate(resultSet.getDate("gmt_create"))
                .setGmtModified(resultSet.getDate("gmt_modified"));
        return student;
    }
}
