package pers.lyr.demo.dao;

import lombok.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author lyr
 * @create 2020/9/13 12:37
 */
public interface BaseDAO<T> {
    /**
     * 查找一个
     * @param query 根据 query 查找
     * @return
     */
    T selectOne(T query);

    /**
     * 根据ID 查找
     * @param query query对象
     * @return
     */
    T selectById(T query);

    Long countByQuery(@NonNull T query);

    /**
     * 根据ID 查找
     * @param id
     * @return
     */
    T selectById(Serializable id);

    /**
     * 更新对象
     * @param object
     * @return
     */
    int updateById(T object);


    /**
     * 根据 object 的条件查询
     * @param object
     * @return
     */
    List<T> listByObject(T object,int page,int size);

    int insertOne(T object);


    int getLastInsertId();

    Object getLastInsertPrimaryKey();
}
