package io.renren.dao;

import java.util.List;

import io.renren.entity.RecipebasicEntity;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public interface RecipebasicDao extends BaseDao<RecipebasicEntity> {

	List<RecipebasicEntity> findAndPage();

	List<RecipebasicEntity> findByPage(Integer offset, Integer limits);

	/**
	 * 搜索
	 * @param name
	 */
	RecipebasicEntity searchBySome(String name);

	RecipebasicEntity findName(String foodname);

	/**
	 * 随机获取一份食谱
	 * @return
	 */
	RecipebasicEntity findOneRecipe();

	/**
	 * 查询5条数据
	 * @return
	 */
	List<RecipebasicEntity> findByNumber();

	/**
	 * 根据用户名查询食谱
	 * @param string
	 * @return
	 */
	List<RecipebasicEntity> findByCustomerNamestring(String string);


	

	
	
}
