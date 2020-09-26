package pers.lyr.demo.listener;


import com.zaxxer.hikari.HikariDataSource;
import pers.lyr.demo.common.util.JdbcUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器，和 和整个容器一样的生命周期
 * @Author lyr
 * @create 2020/9/13 13:52
 */
@WebListener
public class CommonListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
