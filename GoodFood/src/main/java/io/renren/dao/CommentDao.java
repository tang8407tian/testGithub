package io.renren.dao;

import java.util.List;

import io.renren.entity.CommentEntity;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 10:57:52
 */
public interface CommentDao extends BaseDao<CommentEntity> {

	List<CommentEntity> findAllByName(String name);

	List<String> findTime();

	//博客名字查询
	List<CommentEntity> findAllCommentByBlogName(String bolgname);
	
}
