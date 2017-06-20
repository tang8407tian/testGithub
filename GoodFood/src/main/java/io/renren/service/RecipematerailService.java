package io.renren.service;

import io.renren.entity.RecipematerailEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public interface RecipematerailService {
	
	RecipematerailEntity queryObject(Integer id);
	
	List<RecipematerailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RecipematerailEntity recipematerail);
	
	void update(RecipematerailEntity recipematerail);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveBatch(List<RecipematerailEntity> list);
	//查询所有
	List<RecipematerailEntity> findAll();

	List<RecipematerailEntity> findMessgeByName(String name);
}
