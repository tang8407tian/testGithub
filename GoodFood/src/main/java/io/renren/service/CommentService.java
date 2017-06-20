package io.renren.service;

import io.renren.entity.CommentEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 10:57:52
 */
public interface CommentService {
	
	CommentEntity queryObject(Integer id);
	
	List<CommentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommentEntity comment);
	
	void update(CommentEntity comment);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<CommentEntity> findAllComment(String name);
	
	String findTime();

	List<CommentEntity> findAllCommentByBlogName(String bolgname);
	
	int queryTotalByName(String name);

	Integer findAllCommentNumber();

}
