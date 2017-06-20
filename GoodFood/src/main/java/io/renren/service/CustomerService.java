package io.renren.service;

import io.renren.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 11:56:33
 */
public interface CustomerService {
	
	CustomerEntity queryObject(Integer id);
	
	List<CustomerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	//注册
	void save(CustomerEntity customer);
	//根据用户名进行注册验证
	boolean findByName(CustomerEntity customer);

	//登录
	boolean login(CustomerEntity customer);
	
	
	
	void update(CustomerEntity customer);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	CustomerEntity findOne(String username);

	CustomerEntity findByOneName(CustomerEntity user);

	CustomerEntity findByPassAndEmeil(CustomerEntity customerEntity);

	Integer finAllCustomer();
}
