package pers.lyr.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/9/13 10:36
 */
@WebFilter(urlPatterns = {"/*"})
public class EncodingFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 执行 servlet 的 service 之前
        chain.doFilter(request, response); //进入 servlet 执行方法

        //视图渲染之后，
    }


    @Override
    public void destroy() {

    }
}
