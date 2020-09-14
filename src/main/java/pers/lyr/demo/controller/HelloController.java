package pers.lyr.demo.controller;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author lyr
 * @create 2020/9/13 10:12
 */
@WebServlet(urlPatterns = {"/hello"})
public class HelloController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        req.setAttribute("hello","world");
        req.setAttribute("list", Arrays.asList(1,2,3,4,5,6,6,7,9));

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
