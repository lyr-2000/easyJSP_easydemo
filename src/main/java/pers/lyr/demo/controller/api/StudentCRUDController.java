package pers.lyr.demo.controller.api;

import pers.lyr.demo.common.dto.Result;
import pers.lyr.demo.common.factory.ServiceFactory;
import pers.lyr.demo.common.util.WebUtil;
import pers.lyr.demo.controller.BaseController;
import pers.lyr.demo.pojo.po.Student;
import pers.lyr.demo.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/9/13 21:45
 */

@WebServlet(urlPatterns = "/api/student")
public class StudentCRUDController extends BaseController {
    StudentService studentService = ServiceFactory.getStudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuId = req.getParameter("studentId");
        Student student = studentService.selectStudentById(stuId);
        WebUtil.renderJson(resp, Result.from("ok", 200, student));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtil.getJson(req, Student.class);
        //返回主键
        int pk = studentService.addOneStudent(student);
        if (pk <= 0) {
            WebUtil.renderJson(resp, Result.from("添加失败", 400));
        } else {
            WebUtil.renderJson(resp, Result.from("添加成功", 200, pk));
        }
    }
}
