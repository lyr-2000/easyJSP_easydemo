package pers.lyr.demo.common.bean;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import pers.lyr.demo.common.util.JdbcUtil;

import java.lang.reflect.Method;

/**
 * 基于动态代理实现 自动事务回滚
 * @Author lyr
 * @create 2020/9/13 20:05
 */

@Slf4j
public class ServiceTransactionProxyWrapper implements ProxyWrapper {
    public static <T> ServiceTransactionProxyWrapper create(@NonNull T toBeProxy) {
        return new ServiceTransactionProxyWrapper(toBeProxy);
    }
    private Object serviceRunner;
    private ServiceTransactionProxyWrapper(Object serviceRunner) {
        this.serviceRunner = serviceRunner;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();
        // jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
        DataSourceTransactionManager transactionManager = JdbcUtil.getDataSourceTransactionManager();
        TransactionStatus status = null;
        Object value = null;
        try{
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            status = transactionManager.getTransaction(def);
            //事务执行
            value = method.invoke(serviceRunner,args);
        }catch (Exception ex) {

            transactionManager.rollback(status);
            //事务回滚
            log.error("事务执行出现异常了");
            throw ex;
            // jdbcTemplate.getDataSource().getConnection().rollback();
        }finally {
            //事务提交
            ;
            if(!status.isCompleted()) {

                transactionManager.commit(status);
            }
        }


        return value;
    }
}
