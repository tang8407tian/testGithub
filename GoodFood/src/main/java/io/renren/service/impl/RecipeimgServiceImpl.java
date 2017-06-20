package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.RecipeimgDao;
import io.renren.entity.RecipeimgEntity;
import io.renren.service.RecipeimgService;



@Service("recipeimgService")
public class RecipeimgServiceImpl implements RecipeimgService {
	@Autowired
	private RecipeimgDao recipeimgDao;
	
	@Override
	public RecipeimgEntity queryObject(Integer id){
		return recipeimgDao.queryObject(id);
	}
	
	@Override
	public List<RecipeimgEntity> queryList(Map<String, Object> map){
		return recipeimgDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return recipeimgDao.queryTotal(map);
	}
	
	@Override
	public void save(RecipeimgEntity recipeimg){
		recipeimgDao.save(recipeimg);
	}
	
	@Override
	public void update(RecipeimgEntity recipeimg){
		recipeimgDao.update(recipeimg);
	}
	
	@Override
	public void delete(Integer id){
		recipeimgDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		recipeimgDao.deleteBatch(ids);
	}

	@Override
	public RecipeimgEntity findImg() {
		
		return null;
	}
	
}
