package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.BlogDao;
import io.renren.entity.BlogEntity;
import io.renren.entity.CustomerEntity;
import io.renren.service.BlogService;



@Service("blogService")
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	
	@Override
	public BlogEntity queryObject(Integer id){
		return blogDao.queryObject(id);
	}
	
	@Override
	public List<BlogEntity> queryList(Map<String, Object> map){
		return blogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return blogDao.queryTotal(map);
	}
	
	@Override
	public void save(BlogEntity blog){
		blogDao.save(blog);
	}
	
	@Override
	public void update(BlogEntity blog){
		blogDao.update(blog);
	}
	
	@Override
	public void delete(Integer id){
		blogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		blogDao.deleteBatch(ids);
	}

	/**
	 * 通过博客名字检查博客名是否存在
	 */
	@Override
	public BlogEntity findByName(String bolgname) {
		
		BlogEntity isBlogEntity =	blogDao.findByBlogName(bolgname);
		return isBlogEntity;
	}

	/**
	 * 查询blog总数
	 */
	@Override
	public Integer findAll() {
		int allBlog =	blogDao.queryTotal();
		return allBlog;
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<BlogEntity> findAllAndPage(Map<String, Object> map) {
		
		List<BlogEntity> list = blogDao.queryList(map);
		return list;
	}

	/**
	 * 通过用户名统计博客总数
	 */
	@Override
	public int findAllByName(CustomerEntity vo) {
		int blog = blogDao.findAllByName(vo);
		return 0;
	}

	/**
	 * 统计博客总数
	 */
	@Override
	public Integer findAllBlog() {
		Integer all = blogDao.queryTotal();
		return all;
	}

	/**
	 * 倒序查询6条数据
	 */
	@Override
	public List<BlogEntity> findByRand() {
		List<BlogEntity> list = blogDao.findAllByNumber();
		return list;
	}
	
}
