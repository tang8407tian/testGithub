package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.CommentDao;
import io.renren.entity.CommentEntity;
import io.renren.service.CommentService;



@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public CommentEntity queryObject(Integer id){
		return commentDao.queryObject(id);
	}
	
	@Override
	public List<CommentEntity> queryList(Map<String, Object> map){
		return commentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commentDao.queryTotal(map);
	}
	
	@Override
	public void save(CommentEntity comment){
		commentDao.save(comment);
	}
	
	@Override
	public void update(CommentEntity comment){
		commentDao.update(comment);
	}
	
	@Override
	public void delete(Integer id){
		commentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		commentDao.deleteBatch(ids);
	}

	/**
	 * 查询所有评论
	 */
	@Override
	public List<CommentEntity> findAllComment(String name) {
		
	List<CommentEntity> list =	 commentDao.findAllByName(name);
	
	List< CommentEntity> list2 = commentDao.findAll();
	
	
		 return list;
	}

	@Override
	public String findTime() {
		
	List<String> list =	commentDao.findTime();
		for (String string : list) {
			System.out.println("时间： " + string);
		}
		return null;
	}

	/**
	 * 通过博客名查询评论
	 */
	@Override
	public List<CommentEntity> findAllCommentByBlogName(String bolgname) {
		List<CommentEntity> list = commentDao.findAllCommentByBlogName(bolgname);
		return list;
	}

	@Override
	public int queryTotalByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 统计评论总数
	 */
	@Override
	public Integer findAllCommentNumber() {
		Integer all =commentDao.queryTotal();
		return all;
	}
	
}
