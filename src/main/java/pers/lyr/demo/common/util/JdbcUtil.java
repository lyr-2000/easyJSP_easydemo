package pers.lyr.demo.common.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import java.io.IOException;
import java.util.Properties;

/**
 * @Author lyr
 * @create 2020/9/13 13:27
 */
public class JdbcUtil {
    private static Logger log = LoggerFactory.getLogger(JdbcUtil.class);
    private static HikariDataSource dataSource = null;
    private static DataSourceTransactionManager dataSourceTransactionManager = null;
    static {
        buildDataSource();
    }
    private static void buildDataSource() {
        //配置文件
        HikariConfig hikariConfig = new HikariConfig();
        Properties prop = load();
//        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");//mysql
        hikariConfig.setJdbcUrl(prop.getProperty("db.url"));//oracle
        hikariConfig.setDriverClassName(prop.getProperty("db.driver"));
        hikariConfig.setUsername(prop.getProperty("db.username"));
        hikariConfig.setPassword(prop.getProperty("db.password"));
        // hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        // hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        // hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        log.info("{}",prop);
        dataSource = new HikariDataSource(hikariConfig);
        dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);


    }
    private static Properties load() {
        Properties prop = new Properties();
        try {
            prop.load(JdbcUtil.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    public static HikariDataSource getDataSource() {
        return dataSource;
    }

    public static DataSourceTransactionManager getDataSourceTransactionManager() {
        return dataSourceTransactionManager;
    }
}
