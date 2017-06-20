package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.CustomerEntity;


/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseDao<T> {
	//注册
	void save(T t);
	
	//登录
	CustomerEntity login(T t);
	
	void save(Map<String, Object> map);
	//批量保存
	void saveBatch(List<T> list);
	
	//食谱根据名字查询
	T findRecipebyName(String name);

	
	//查询所有
	List<T>  findAll();
	
	//recipebasicDao 倒序查询  10条记录
	List<T> selectList();
	
	//随机查询  10条数据
	List<T> findByRand();
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);

	T queryObject(Object id);
	
	List<T> queryList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	List<T> queryList();
	
	//List<T> selectList();
	
	int queryTotal(Map<String, Object> map);

	int queryTotal();
}
