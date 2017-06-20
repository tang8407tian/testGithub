package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.dao.RecipebasicDao;
import io.renren.entity.RecipebasicEntity;
import io.renren.service.RecipebasicService;



@Service("recipebasicService")
public class RecipebasicServiceImpl implements RecipebasicService {
	@Autowired
	private RecipebasicDao recipebasicDao;
	
	@Override
	public RecipebasicEntity queryObject(Integer id){
		return recipebasicDao.queryObject(id);
	}
	
	@Override
	public List<RecipebasicEntity> queryList(Map<String, Object> map){
		System.out.println("service  map" + map);
		
		return recipebasicDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return recipebasicDao.queryTotal(map);
	}
	
	@Override
	public void save(RecipebasicEntity recipebasic){
		recipebasicDao.save(recipebasic);
	}
	
	@Override
	public void update(RecipebasicEntity recipebasic){
		recipebasicDao.update(recipebasic);
	}
	
	@Override
	public void delete(Integer id){
		recipebasicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		recipebasicDao.deleteBatch(ids);
	}

	@Override
	public List<RecipebasicEntity> selectList() {

		return recipebasicDao.selectList();
		
	
	}
	
	
	//查询所有
	@Override
	public List<RecipebasicEntity> findAll() {
		
		return recipebasicDao.findAll();
	}
	//随机查询
	@Override
	public List<RecipebasicEntity> findByRand() {
		return recipebasicDao.findByRand();
	}

	//根据名字查询
	@Override
	public RecipebasicEntity findByName(String name) {
		
		return	recipebasicDao.findRecipebyName(name);
		
		 
	}

	//查询数据总数
	@Override
	public Integer findAllRecipe() {

		
		return recipebasicDao.queryTotal();
	}

	//分页查询数据
	@Override
	public List<RecipebasicEntity> findAndPage(Map<String, Object> map) {
		
	
		System.out.println("进入  查询分页service ");
		System.out.println("service  mao" + map);
		
		List<RecipebasicEntity> list =recipebasicDao.queryList(map);
		
		/*List<RecipebasicEntity> list = recipebasicDao.findAndPage(map);*/
		
		return list;
	}

	/**
	 * 搜索
	 */
	@Override
	public RecipebasicEntity searchByName(String name) {
		
		return	recipebasicDao.searchBySome(name);
	
	}

	
	//检验食谱名是否存在
	@Override
	public boolean findName(String foodname) {
		
	RecipebasicEntity vo =	recipebasicDao.findName(foodname);
		
		return ( vo != null);
	}

	/**
	 * 随机读取一份食谱
	 */
	@Override
	public RecipebasicEntity findOne() {
		RecipebasicEntity oneRecipe =	recipebasicDao.findOneRecipe();
		return oneRecipe;
	}

	/**
	 * 查询5条数据
	 */
	@Override
	public List<RecipebasicEntity> finByNumber() {
		List<RecipebasicEntity> list = recipebasicDao.findByNumber();
		return list;
	}

	/**
	 * 根据用户名查询食谱
	 */
	@Override
	public List<RecipebasicEntity> findByCustmerName(String string) {
	List<RecipebasicEntity> list =	recipebasicDao.findByCustomerNamestring(string);
		return list;
	}

	
	
}
