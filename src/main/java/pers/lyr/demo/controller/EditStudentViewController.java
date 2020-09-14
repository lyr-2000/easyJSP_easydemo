package pers.lyr.demo.controller;

import lombok.extern.slf4j.Slf4j;
import pers.lyr.demo.common.factory.ServiceFactory;
import pers.lyr.demo.common.util.WebUtil;
import pers.lyr.demo.pojo.po.Student;
import pers.lyr.demo.service.StudentService;

import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author lyr
 * @create 2020/9/14 13:13
 */
@Slf4j
@WebServlet(urlPatterns = "/editStudent")
public class EditStudentViewController extends BaseController{
    StudentService studentService = ServiceFactory.getStudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        if(studentId!=null) {
            req.setAttribute("student",studentService.selectStudentById(studentId));
        }
        renderView(req,"editStudent.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtil.getForm(req,Student.class);
        log.info("student {}",student);
        if(student.getStudentId()==null) {
            //如果没有 ，插入
            studentService.addOneStudent(student.setGmtCreate(new Date()).setGmtModified(new Date()));
        }else {
            //如果有 ，就更新
            studentService.updateById(student);
        }
        renderView(req,"success.jsp");
    }
}
