package io.renren.dao;

import java.util.List;

import io.renren.entity.RecipestepEntity;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-19 18:54:14
 */
public interface RecipestepDao extends BaseDao<RecipestepEntity> {

	//根据名字查询食谱步骤集合
	List<RecipestepEntity> findRecipebyNameList(String name);
	
}
