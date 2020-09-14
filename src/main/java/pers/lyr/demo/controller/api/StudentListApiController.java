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
import java.util.List;

/**
 * @Author lyr
 * @create 2020/9/13 22:19
 */
@WebServlet(urlPatterns = "/api/student/list")
public class StudentListApiController extends BaseController {
    StudentService studentService = ServiceFactory.getStudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer page = getPage(req, 1);
        Integer size = getSize(req, 5);
        List<Student> studentList = studentService.listStudent(new Student(), page, size);
        WebUtil.renderJson(resp, Result.from("ok", 200, studentList));
    }
}
