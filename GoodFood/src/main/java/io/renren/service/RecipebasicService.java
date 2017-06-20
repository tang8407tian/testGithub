package io.renren.service;

import io.renren.entity.RecipebasicEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public interface RecipebasicService {
	
	RecipebasicEntity queryObject(Integer id);
	
	List<RecipebasicEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RecipebasicEntity recipebasic);
	
	void update(RecipebasicEntity recipebasic);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	//倒序查询  10条
	List<RecipebasicEntity> selectList();
	//查询所有
	List<RecipebasicEntity> findAll();

	List<RecipebasicEntity> findByRand();

	RecipebasicEntity findByName(String name);

	Integer findAllRecipe();

	List<RecipebasicEntity> findAndPage(Map<String, Object> map);

	RecipebasicEntity searchByName(String name);

	boolean findName(String foodname);

	RecipebasicEntity findOne();

	List<RecipebasicEntity> finByNumber();

	List<RecipebasicEntity> findByCustmerName(String string);

}
