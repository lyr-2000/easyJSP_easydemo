package pers.lyr.demo.dao.impl;

import com.mysql.jdbc.Statement;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pers.lyr.demo.common.factory.JdbcTemplateFactory;
import pers.lyr.demo.common.mapper.TeacherTableMapper;

import pers.lyr.demo.dao.BaseDAOImpl;
import pers.lyr.demo.dao.TeacherDAO;
import pers.lyr.demo.pojo.po.Teacher;

import java.sql.PreparedStatement;


/**
 * @Author lyr
 * @create 2020/9/13 13:56
 */
@Slf4j
public class TeacherDAOImpl extends BaseDAOImpl<Teacher> implements TeacherDAO  {
    private final JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();

    @Override
    public Teacher selectById( @NonNull Teacher query) {

        return super.selectById(query.getTeacherId());
    }

    /**
     * 获取 T 表的名字
     *
     * @return 数据库表的名字
     */
    @Override
    public String getTableName() {
        return "t_teacher";
    }

    /**
     * 返回映射 的实现
     *
     * @return jdbcTemplate 定义的 映射接口
     */
    @Override
    public RowMapper<Teacher> getRowMapper() {
        return TeacherTableMapper.INSTANCE;
    }

    /**
     * @return T 表 的 id字段
     */
    @Override
    public String getTableIdField() {
        return "teacher_id";
    }


    @Override
    public int insertOne(Teacher object) {

        int row = jdbcTemplate.update(
                "INSERT INTO `t_teacher`(`teacher_name`, `teacher_password`,`sex`,`is_deleted`,`gmt_create`,`gmt_modified`) VALUES (?,?,?,?,?,?)" ,
                object.getTeacherName(),object.getTeacherPassword(),object.getSex(),object.getDeleted(),object.getGmtCreate(),object.getGmtModified());
        if(row <=0) {
            return row;
        }
        int l = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", (rs,i) -> rs.getInt("LAST_INSERT_ID()"));
        return l;
    }
}
