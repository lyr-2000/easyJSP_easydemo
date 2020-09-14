package pers.lyr.demo.controller;

import pers.lyr.demo.common.factory.ServiceFactory;
import pers.lyr.demo.common.util.PageHelper;
import pers.lyr.demo.pojo.po.Student;
import pers.lyr.demo.service.StudentService;

import javax.servlet.ServletException;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/9/13 22:30
 */
@WebServlet(urlPatterns = "/student")
public class StudentViewController extends BaseController{
    StudentService studentService = ServiceFactory.getStudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        Student s =  new Student().setStudentName(studentName);
        req.setAttribute("rows",studentService.listStudent(s,getPage(req,1),getSize(req,5)));
        req.setAttribute("count",studentService.countStudentByQuery(s));
        PageHelper.of(req);
        super.renderView(req,"student.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
