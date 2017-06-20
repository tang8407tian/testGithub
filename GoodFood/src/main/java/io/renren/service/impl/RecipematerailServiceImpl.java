package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.RecipematerailDao;
import io.renren.entity.RecipematerailEntity;
import io.renren.service.RecipematerailService;



@Service("recipematerailService")
public class RecipematerailServiceImpl implements RecipematerailService {
	@Autowired
	private RecipematerailDao recipematerailDao;
	
	@Override
	public RecipematerailEntity queryObject(Integer id){
		return recipematerailDao.queryObject(id);
	}
	
	@Override
	public List<RecipematerailEntity> queryList(Map<String, Object> map){
		return recipematerailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return recipematerailDao.queryTotal(map);
	}
	
	@Override
	public void save(RecipematerailEntity recipematerail){
		recipematerailDao.save(recipematerail);
	}
	
	@Override
	public void update(RecipematerailEntity recipematerail){
		recipematerailDao.update(recipematerail);
	}
	
	@Override
	public void delete(Integer id){
		recipematerailDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		recipematerailDao.deleteBatch(ids);
	}
	/**
	 * 批量保存
	 */
	@Override
	public void saveBatch(List<RecipematerailEntity> list) {
		
		recipematerailDao.saveBatch(list);
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<RecipematerailEntity> findAll() {
		
		return recipematerailDao.findAll();
	}

	@Override
	public List<RecipematerailEntity> findMessgeByName(String name) {
		List<RecipematerailEntity> materailList =  recipematerailDao.findRecipebyNameList(name);
		
		return materailList;
	}
	
}
