package io.renren.service;

import io.renren.entity.BlogEntity;
import io.renren.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-21 18:11:19
 */
public interface BlogService {
	
	BlogEntity queryObject(Integer id);
	
	List<BlogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BlogEntity blog);
	
	void update(BlogEntity blog);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	BlogEntity findByName(String bolgname);

	Integer findAll();

	List<BlogEntity> findAllAndPage(Map<String, Object> map);

	int findAllByName(CustomerEntity vo);

	Integer findAllBlog();

	List<BlogEntity> findByRand();
}
