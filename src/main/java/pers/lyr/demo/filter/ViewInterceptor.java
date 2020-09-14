package pers.lyr.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * 一般不能让 黑客知道 服务器是用什么 语言写的，像 jsp， php 什么的后缀，不能让他们请求，他们可能会用来分析，找漏洞
 * 拦截页面，让 控制器来处理这个页面的请求
 *
 * @Author lyr
 * @create 2020/9/13 10:46
 */
@WebFilter(urlPatterns = {"*.jsp","*.php" ,"*.asp"})
public class ViewInterceptor implements Filter {
    private Logger log = LoggerFactory.getLogger(ViewInterceptor.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
     @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         log.info("拦截到请求，不能放行");
    }


    @Override
    public void destroy() {

    }
}
