package pers.lyr.demo.controller;

import pers.lyr.demo.common.dto.Result;
import pers.lyr.demo.common.util.WebUtil;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author lyr
 * @create 2020/9/13 12:37
 */
@WebServlet(urlPatterns = "/json")
public class HelloJsonController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebUtil.renderJson(resp,  Result.from("ok",200));
    }
}
