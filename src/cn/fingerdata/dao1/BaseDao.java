package cn.fingerdata.dao1;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 根据主键id查找到一条数据
	 * @param id
	 * @return
	 */
	T    getById(int id);
	
	
	
	/**
	 * 根据主键查找到一条数据
	 * @param id 主键
	 * @return 查找到的实体 
	 */
	T get(Serializable  id);
	
	
	
	/**
	 * 添加到数据库
	 * @param entity实体
	 * @return 返回添加成功的实体，null代表失败
	 */
	T  add(T entity);
	
	
	
	/**
	 * 根据主键删除数据
	 * @param  id
	 */
	void  deletById(Serializable id);
	
	
	
	/**
	 * 更新数据
	 * @param  entity是传入将要更新的实体(注意：主键不允许修改)
	 */
	void update(T entity);
	
	
	/**
	 * 查找数据
	 * @param  sql是select打头的sql语句
	 * @return 查询到的结果
	 */
    List<T> find(String  sql);
    
    
    /**
     * 查找数据
     * @param condition
     * @return
     */
    List<T> find(T condition);
    
    
     /**
      * 查找数据
      * @param propertyName  建是（表的字段）
      * @param value  值（查找的数据）
      * @return
      */
    List<T> findByProperty(String  propertyName,String  value);
    
    
    /**
     * 查询所有的数据
     * @return  查找到的结果  
     */
    List<T>  getAll();
}
