package pers.lyr.demo.common.factory;

import org.springframework.jdbc.core.JdbcTemplate;
import pers.lyr.demo.common.util.JdbcUtil;

/**
 * 单例 + 工厂
 * @Author lyr
 * @create 2020/9/13 14:18
 */
public class JdbcTemplateFactory {
    private static final JdbcTemplate JDBCTEMPLATE
            = new JdbcTemplate(JdbcUtil.getDataSource());

    public static JdbcTemplate getJdbcTemplate() {
        return JDBCTEMPLATE;
    }

}
