package io.renren.dao;

import java.util.Map;

import io.renren.entity.CustomerEntity;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 11:56:33
 */
public interface CustomerDao extends BaseDao<CustomerEntity> {

	/**
	 * 更新用户昵称
	 * @param nickname
	 */
	void updateOne(Map<String, Object> map);

	CustomerEntity findToCustName(CustomerEntity customerEntity);

	CustomerEntity findByPassAndEmail(CustomerEntity customerEntity);

	void regist(CustomerEntity customer);

	void regists(Map<String, Object> map);
	
	//注册验证
	CustomerEntity findByName(String customerName);

	
}
