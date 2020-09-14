package pers.lyr.demo.common.factory;

import pers.lyr.demo.common.util.ProxyUtil;
import pers.lyr.demo.service.StudentService;
import pers.lyr.demo.service.TeacherService;
import pers.lyr.demo.service.impl.StudentServiceImpl;
import pers.lyr.demo.service.impl.TeacherServiceImpl;

/**
 * @Author lyr
 * @create 2020/9/13 13:15
 */
public class ServiceFactory {
    public static TeacherService getTeacherService() {
        return ProxyUtil.getProxyForTransaction(new TeacherServiceImpl());
    }

    public static StudentService getStudentService() {

        return ProxyUtil.getProxyForTransaction(new StudentServiceImpl());
    }
}
