package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.RecipestepDao;
import io.renren.entity.RecipestepEntity;
import io.renren.service.RecipestepService;



@Service("recipestepService")
public class RecipestepServiceImpl implements RecipestepService {
	@Autowired
	private RecipestepDao recipestepDao;
	
	@Override
	public RecipestepEntity queryObject(Integer id){
		return recipestepDao.queryObject(id);
	}
	
	@Override
	public List<RecipestepEntity> queryList(Map<String, Object> map){
		return recipestepDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return recipestepDao.queryTotal(map);
	}
	
	@Override
	public void save(RecipestepEntity recipestep){
		recipestepDao.save(recipestep);
	}
	
	@Override
	public void update(RecipestepEntity recipestep){
		recipestepDao.update(recipestep);
	}
	
	@Override
	public void delete(Integer id){
		recipestepDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		recipestepDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<RecipestepEntity> list) {

		recipestepDao.saveBatch(list);
	}
	
	
	//查询所有
	@Override
	public List<RecipestepEntity> findAll() {
		
		
		
		return  recipestepDao.findAll();
	}
	
	
	//根据食谱名字查询食谱原料信息
	@Override
	public List<RecipestepEntity> findMessageByName(String name) {
		return recipestepDao.findRecipebyNameList(name);
	}
	
}
