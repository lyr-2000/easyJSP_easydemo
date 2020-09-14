package pers.lyr.demo.pojo.po;

import pers.lyr.demo.common.annontation.DbField;
import pers.lyr.demo.common.annontation.DbFieldId;
import pers.lyr.demo.common.annontation.DbTable;

import java.util.Date;

/**
 * @Author lyr
 * @create 2020/9/13 13:58
 */
@DbTable(tableName = "t_teacher")
public class Teacher {
    @DbFieldId
    @DbField("teacher_id")
    private Integer teacherId;
    /**
     * 名字
     */
    @DbField("teacher_name")
    private String teacherName;
    /**
     * 密码
     */
    @DbField("teacher_password")
    private String teacherPassword;
    @DbField("sex")
    private Integer sex;
    /**
     * 逻辑删除
     */
    @DbField("is_deleted")
    private Integer deleted;

    private Date gmtCreate;
    private Date gmtModified;


    public Integer getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public Teacher setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Teacher setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Teacher setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Teacher setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public Teacher setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", sex=" + sex +
                ", deleted=" + deleted +
                '}';
    }
}
