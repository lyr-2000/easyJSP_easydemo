package pers.lyr.demo.dao;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import pers.lyr.demo.common.factory.JdbcTemplateFactory;

import pers.lyr.demo.common.util.ReflectUtil;


import java.awt.image.AreaAveragingScaleFilter;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author lyr
 * @create 2020/9/13 15:54
 */

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
    private Logger log = LoggerFactory.getLogger(BaseDAOImpl.class);
    /**
     * 获取 T 表的名字
     * @return 数据库表的名字
     */
    public abstract String getTableName();

    /**
     * 返回映射 的实现
     * @return jdbcTemplate 定义的 映射接口
     */
    public  abstract RowMapper<T> getRowMapper();

    public abstract String getTableIdField();


    @Override
    public  T selectOne(@NonNull T query) {
        String base = "select * from {0} where 1=1 {1} {2}";
        List<Object> valueHolder = new ArrayList<>();
        String realSQL  = MessageFormat.format(base , getTableName(),ReflectUtil.getSqlFragment(query,valueHolder)," limit 1");
        log.info("sql {}",realSQL);
        T result = null;
        try{
           result = JdbcTemplateFactory.getJdbcTemplate().queryForObject(realSQL, getRowMapper(),valueHolder.toArray());
        }catch (Exception ex) {
            log.warn("出现异常 {}",ex.getMessage());
        }
        return result;
    }

    /**
     * select count(*) from xxx where xx=xx
     * @param query 查询对象
     * @return 记录数
     */
    @Override
    public Long countByQuery(@NonNull T query) {
        String base = "select count(*) from {0} where 1=1 {1}";
        List valueHolder = new ArrayList();
        String realSql = MessageFormat.format(base,getTableName(),ReflectUtil.getSqlFragment(query,valueHolder));
        return JdbcTemplateFactory.getJdbcTemplate().queryForObject(realSql,(rs,i) -> rs.getLong(1));
    }


    /**
     * 根据ID 查找
     *
     * @param id
     * @return 查询的单条记录
     */
    @Override
    public T selectById(Serializable id) {
        String sql = MessageFormat.format("select * from {0} where {1} = ?",getTableName(),getTableIdField() );
        return JdbcTemplateFactory.getJdbcTemplate().queryForObject(sql,getRowMapper(),id);
    }

    /**
     * 更新对象
     *
     * @param object
     * @return
     */
    @Override
    public int updateById(T object) {
        List<Object> list  = new ArrayList();
        // log.info(getTableName());
        // log.info(getTableIdField());
        // log.info(ReflectUtil.setSqlFragment(object,list));
        String sql = MessageFormat.format("update {0} {1}  where {2} = ?",getTableName(),  ReflectUtil.setSqlFragment(object,list), getTableIdField() );
        log.info("sql {}",sql);
        log.info("{}",list);
        try {
            list.add(ReflectUtil.getById(object));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return JdbcTemplateFactory.getJdbcTemplate().update(sql,list.toArray());
    }

    /**
     * 根据 object 的条件查询
     *
     * @param object
     * @return
     */
    @Override
    public List<T> listByObject(T object,int page,int size) {
        String base = "select * from {0} where 1=1 {1}  limit ?,?";
        List<Object> valueHolder = new ArrayList<>();
        String realSQL  = MessageFormat.format(base , getTableName(),ReflectUtil.getSqlFragment(object,valueHolder));
        log.info("sql {}",realSQL);
        //添加分页参数
        valueHolder.add( (page-1) *size);
        valueHolder.add(size);
        return  JdbcTemplateFactory.getJdbcTemplate().query(realSQL, getRowMapper(),valueHolder.toArray() );
    }
    @Override
    public int getLastInsertId() {
        return JdbcTemplateFactory.getJdbcTemplate().queryForObject("SELECT LAST_INSERT_ID()", (rs,i) -> rs.getInt("LAST_INSERT_ID()"));

    }
    @Override
    public Object getLastInsertPrimaryKey() {
        return JdbcTemplateFactory.getJdbcTemplate()
                .queryForObject("select LAST_INSERT_ID()",(rs,i)->rs.getObject(1));
    }


}
