package io.renren.service;

import io.renren.entity.RecipestepEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public interface RecipestepService {
	
	RecipestepEntity queryObject(Integer id);
	
	List<RecipestepEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	//保存数据
	void save(RecipestepEntity recipestep);
	
	void update(RecipestepEntity recipestep);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveBatch(List<RecipestepEntity> list);
	
	//查询所有
	List<RecipestepEntity> findAll();

	List<RecipestepEntity> findMessageByName(String name);
}
