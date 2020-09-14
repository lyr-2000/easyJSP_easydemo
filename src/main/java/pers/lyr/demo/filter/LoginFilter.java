package pers.lyr.demo.filter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/9/14 10:10
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        // System.out.println("heeh");
        if(passRequest((HttpServletRequest) request,(HttpServletResponse)response)) {
            chain.doFilter(request,response);
        }
        else if(session.getAttribute("login")==null) {
            //没有就要登录
            ((HttpServletResponse)response).sendRedirect("login.do");
        }else {
            //有就放行
            chain.doFilter(request, response);
        }

    }


    @Override
    public void destroy() {

    }


    /**
     * 放行静态资源
     * @param request
     * @param response
     * @return
     */
    private boolean passRequest(HttpServletRequest request,HttpServletResponse response) {
        String uri = request.getRequestURI();
        log.info("uri  {}",uri);
        if(uri.startsWith("/assets")||uri.startsWith("/login")||uri.length()<=1) {
            return true;
        }
        return false;

    }
}
