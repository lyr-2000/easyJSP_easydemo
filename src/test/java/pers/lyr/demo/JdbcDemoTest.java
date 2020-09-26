package pers.lyr.demo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.lyr.demo.common.factory.JdbcTemplateFactory;
import pers.lyr.demo.common.mapper.StudentTableMapper;
import pers.lyr.demo.pojo.po.Student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        List<Student> list = jdbcTemplate.query("select * from t_student", new StudentTableMapper());
        for(Student s:list ) {
            System.out.println(s);
        }
        // list.forEach(student -> System.out.println(student));

    }

    @Test
    public void print() {
        Integer []p = {1,3,1,222,1,1};
        Arrays.sort(p,(i,j)->j-i);
        System.out.println(Arrays.toString(p));
    }

    @Test
    public void arraySort() {
        Integer[] p = {1,2,44,5,2,-1,444,77};
        Arrays.sort(p, (i,j)-> j-i);
        System.out.println(Arrays.toString(p));
    }
    @Test
    public void arraySort1() {
        Integer[] p = {1,2,44,5,2,-1,444,77};

        Arrays.sort(p, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue()-o1.intValue();
            }
        });
        System.out.println(Arrays.toString(p));
    }

    @Test
    public void lll() {
        // new BufferedReader(new FileInputStream())
    }
}
