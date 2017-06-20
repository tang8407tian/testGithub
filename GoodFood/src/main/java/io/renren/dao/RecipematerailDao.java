package io.renren.dao;

import java.util.List;

import io.renren.entity.RecipematerailEntity;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public interface RecipematerailDao extends BaseDao<RecipematerailEntity> {
	
	//根据名字查询食谱原料集合
	List<RecipematerailEntity> findRecipebyNameList(String name);
	
}
