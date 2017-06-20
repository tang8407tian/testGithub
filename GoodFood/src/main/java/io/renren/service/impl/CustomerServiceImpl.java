package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.dao.CustomerDao;
import io.renren.entity.CustomerEntity;
import io.renren.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public CustomerEntity queryObject(Integer id) {
		return customerDao.queryObject(id);
	}

	@Override
	public List<CustomerEntity> queryList(Map<String, Object> map) {
		return customerDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return customerDao.queryTotal(map);
	}

	// 注册
	@Override
	public void save(CustomerEntity customer) {
		//customerDao.regist(customer);
		//customerDao.save(customer);
		
		Map<String, Object> map = new HashMap<>();
		map.put("customerName", customer.getCustomerName());
		map.put("customerPassword", customer.getCustomerPassword());
		map.put("customweEmail", customer.getCustomweEmail());
		
		customerDao.regists(map);
		
	}

	// 注册验证
	@Override
	public boolean findByName(CustomerEntity customer) {
		
		CustomerEntity custName = customerDao.findToCustName(customer);
		
		
		
		return (custName != null);
		//return false;
	}

	// 登录
	@Override
	public boolean login(CustomerEntity customer) {
		CustomerEntity customerEntity = customerDao.login(customer);
		return (customerEntity != null);
	}

	@Override
	public void update(CustomerEntity customer) {
		System.out.println("service  : " + customer);
		String nickname = customer.getNickname();
		String customerName = customer.getCustomerName();
		
		Map<String, Object> map =	new HashMap<>();
		map.put("nickname", nickname);
		map.put("customerName", customerName);
		
		
		//customerDao.updateOne(map);
		
		
		System.out.println("昵称：" + nickname   + "  用户名：  " + customerName);
		customerDao.update(customer);
		
	}

	@Override
	public void delete(Integer id) {
		customerDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		customerDao.deleteBatch(ids);
	}

	@Override
	public CustomerEntity findOne(String customerName) {
	
		return customerDao.findByName(customerName);
		
		//return customerEntity;
		
		
	}

	@Override
	public CustomerEntity findByOneName(CustomerEntity user) {
		
		//CustomerEntity customerEntity =customerDao.findByName(user);

		CustomerEntity onEntity =	customerDao.findToCustName(user);
		//System.out.println("service: " + customerEntity);
		System.out.println("通过用户名：service: " + onEntity);
		
		return onEntity;
	}

	@Override
	public CustomerEntity findByPassAndEmeil(CustomerEntity customerEntity) {

		CustomerEntity cEntity = customerDao.findByPassAndEmail(customerEntity);
		
		return null;
	}

	/**
	 * 统计用户总量
	 */
	@Override
	public Integer finAllCustomer() {
		Integer all =	customerDao.queryTotal();
		return all;
	}

}
