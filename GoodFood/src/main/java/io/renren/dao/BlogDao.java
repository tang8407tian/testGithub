package io.renren.dao;

import java.util.List;

import io.renren.entity.BlogEntity;
import io.renren.entity.CustomerEntity;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-21 18:11:19
 */
public interface BlogDao extends BaseDao<BlogEntity> {

	/**
	 * 通过博客名字检查博客名是否存在
	 * @param bolgname
	 * @return
	 */
	BlogEntity findByBlogName(String bolgname);

	int findAllByName(CustomerEntity vo);

	/**
	 * 倒序查询10条数据
	 * @return
	 */
	List<BlogEntity> findAllByNumber();
	
}
