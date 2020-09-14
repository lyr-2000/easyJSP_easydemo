package pers.lyr.demo.common.mapper;


import org.springframework.jdbc.core.RowMapper;
import pers.lyr.demo.pojo.po.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author lyr
 * @create 2020/9/13 14:37
 */
public class TeacherTableMapper implements RowMapper<Teacher> {
    public static final TeacherTableMapper INSTANCE = new TeacherTableMapper();

    @Override
    public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(resultSet.getInt("teacher_id"))
                .setDeleted(resultSet.getInt("is_deleted"))
                .setSex(resultSet.getInt("sex"))
                .setTeacherName(resultSet.getString("teacher_name"))
                .setTeacherPassword(resultSet.getString("teacher_password"))
                .setGmtCreate(resultSet.getDate("gmt_create"))
                .setGmtModified(resultSet.getDate("gmt_modified"));

        return teacher;
    }
}
