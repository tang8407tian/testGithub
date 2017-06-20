package io.renren.service;

import io.renren.entity.RecipeimgEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 10:58:18
 */
public interface RecipeimgService {
	
	RecipeimgEntity queryObject(Integer id);
	
	List<RecipeimgEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RecipeimgEntity recipeimg);
	
	void update(RecipeimgEntity recipeimg);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	RecipeimgEntity findImg();
}
