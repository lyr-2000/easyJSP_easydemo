package pers.lyr.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  基于模板方法设计模式 的一种 AOP 编程实现思路
 * @Author lyr
 * @create 2020/9/13 10:09
 */
public abstract class BaseController extends HttpServlet {
    private Logger log = LoggerFactory.getLogger(BaseController.class);
    protected void beforeService(HttpServletRequest request,HttpServletResponse response) {

    }

    protected void afterService(HttpServletRequest request,HttpServletResponse response) {

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //执行前
        beforeService(req,resp);
        //执行 doGet 等 方法
        try{
            super.service(req, resp);
        }catch (Exception ex) {
            log.error("服务运行异常 {}",ex.getMessage());
            renderView(req,"505.jsp");
        }
        //执行完成之后回调
        afterService(req,resp);
        //最后渲染 视图
        doRender(req,resp);
    }

    protected Integer getPage(HttpServletRequest request, Integer defaultValue) {
        String pageStr = request.getParameter("page");
        if(pageStr==null) {
            return defaultValue;
        }
        Integer page = Integer.valueOf(pageStr);
        if(page<=0) {
            return defaultValue;
        }
        return page;
    }
    protected Integer getSize(HttpServletRequest req,Integer defaultValue) {
        String pageStr = req.getParameter("size");
        if(pageStr==null) {
            return defaultValue;
        }
        Integer page = Integer.valueOf(pageStr);
        if(page<=0) {
            return defaultValue;
        }
        return page;
    }

    /**
     * 渲染视图
     * @param request 请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    private void doRender(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = (String) request.getAttribute("__view_name");
        if(viewName!=null) {
            //如果 设置了 转发视图，才 转发
            request.getRequestDispatcher(viewName).forward(request, response);
        }
    }

    /**
     * 给子类调用的钩子方法，用来最后渲染视图
     * @param request
     * @param viewName
     */
    protected final void renderView(HttpServletRequest request,String viewName) {
        request.setAttribute("__view_name",viewName);
    }

}
