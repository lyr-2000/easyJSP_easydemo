package pers.lyr.demo.common.util;

import pers.lyr.demo.common.bean.ProxyWrapper;
import pers.lyr.demo.common.bean.ServiceTransactionProxyWrapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于反射来控制事务，一种实现 aop的思路
 *
 * @Author lyr
 * @create 2020/9/13 19:54
 */
public class ProxyUtil {

    /**
     * 获取代理后的对象
     * @param clazz    类对象
     * @param proxyWrapper 包裹 执行对象的 实现接口
     * @param <T> 泛型
     * @return 创建一个被代理后的对象
     */
    public static <T>T getInstance(Class<T> clazz, ProxyWrapper proxyWrapper) {
       return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                proxyWrapper
        );
    }

    public static <T> T getProxyForTransaction(T toBeProxy) {
        return (T) getInstance(toBeProxy.getClass(),ServiceTransactionProxyWrapper.create(toBeProxy));
    }

}
