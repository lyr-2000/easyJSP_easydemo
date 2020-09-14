package pers.lyr.demo.pojo.po;

import pers.lyr.demo.common.annontation.DbField;
import pers.lyr.demo.common.annontation.DbFieldId;
import pers.lyr.demo.common.annontation.DbTable;

import java.util.Date;

/**
 * @Author lyr
 * @create 2020/9/13 14:52
 */
@DbTable(tableName = "t_student")
public class Student {
    @DbFieldId
    @DbField("student_id")
    private Integer studentId;
    @DbField("student_name")
    private String studentName;
    @DbField("student_password")
    private String studentPassword;
    @DbField("student_id_card")
    private String studentIdCard;
    @DbField("sex")
    private Integer sex;
    @DbField("is_deleted")
    private Integer deleted;
    @DbField("gmt_create")
    private Date gmtCreate;
    @DbField("gmt_modified")
    private Date  gmtModified;

    public Integer getStudentId() {
        return studentId;
    }

    public Student setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public Student setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
        return this;
    }

    public String getStudentIdCard() {
        return studentIdCard;
    }

    public Student setStudentIdCard(String studentIdCard) {
        this.studentIdCard = studentIdCard;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Student setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Student setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Student setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public Student setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentIdCard='" + studentIdCard + '\'' +
                ", sex=" + sex +
                ", deleted=" + deleted +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
