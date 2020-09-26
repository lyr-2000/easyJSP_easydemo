package pers.lyr.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/9/14 18:37
 */
@WebServlet(urlPatterns = { "/index","/index.html","/index.jsp","/login.do"})
public class LoginController extends BaseController{

    private Logger log = LoggerFactory.getLogger(getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // log.error(req.getParameter("name"));
        if(session.getAttribute("login")==null) {
            renderView(req,"login.jsp");
        }else {
            renderView(req,"hello");
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        //这里为了方便，就不演示 数据库读取了，直接默认 登录成功
        log.info("登录信息 {}",username);
        req.getSession().setAttribute("login","ok");
        // req.getRequestDispatcher("/student").forward(req, resp);
        resp.sendRedirect("/student");

    }
}
