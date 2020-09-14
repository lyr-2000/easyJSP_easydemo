package pers.lyr.demo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.lyr.demo.common.factory.JdbcTemplateFactory;
import pers.lyr.demo.common.mapper.StudentTableMapper;

import java.util.Arrays;

/**
 * @Author lyr
 * @create 2020/9/13 21:06
 */
public class JdbcDemoTest {

    /**
     * 策略模式演示
     */
    @Test
    public void testSelect() {
        JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();
        jdbcTemplate.query("select * from t_student", new StudentTableMapper())
                .forEach(i -> System.out.println(i));
    }

    @Test
    public void arraySort() {
        Integer[] p = {1,2,44,5,2,-1,444,77};
        Arrays.sort(p, (i,j)-> i-j);
        System.out.println(Arrays.toString(p));
    }
}
