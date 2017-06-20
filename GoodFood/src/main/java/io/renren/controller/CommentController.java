package io.renren.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import io.renren.entity.BlogEntity;
import io.renren.entity.CommentEntity;
import io.renren.entity.CustomerEntity;
import io.renren.entity.RecipebasicEntity;
import io.renren.entity.RecipematerailEntity;
import io.renren.entity.RecipestepEntity;
import io.renren.service.BlogService;
import io.renren.service.CommentService;
import io.renren.service.CustomerService;
import io.renren.service.RecipebasicService;
import io.renren.service.RecipematerailService;
import io.renren.service.RecipestepService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 10:57:52
 */
@Controller
@RequestMapping("comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	//美食基本信息
			@Autowired
			private RecipebasicService recipebasicService;
		//美食原料信息
			@Autowired
			private RecipematerailService recipematerailService;
		//美食步骤信息	
			@Autowired
			private RecipestepService recipestepService;
		//用户	
			@Autowired
			private CustomerService customerService;
			
			@Autowired
			private BlogService blogService;

	
	/**
	 * 保存获取食谱页面评论内容     添加评论
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ModelAndView save(String foodName,CommentEntity comment,String articlename
			,HttpSession session){
		ModelAndView mav = new ModelAndView();
		/*@RequestBody CommentEntity comment,String foodname, String articalName*/

		
		//从session中获取用户名
		String username = (String) session.getAttribute("username");
		
		
		
		/*获取系统当前时间*/
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		System.out.println(time);
		
		comment.setFoodname(foodName);
		comment.setCreateTime(time);
		comment.setArticlename(articlename);
		
		if (username != null) {
			//通过用户名查询用户信息
			CustomerEntity vo =	customerService.findOne(username);
			
			//System.out.println("添加评论王菲王菲王菲： " +vo.toString());		
			//添加用户头像
			comment.setCustomerimg(vo.getHeadimg());

			
			if (vo.getNickname() != null) {
				
				comment.setCustomername(vo.getNickname());
			} else {
				
				comment.setCustomername(username);

			}
			
		} else {
			comment.setCustomername("游客");

		}

		commentService.save(comment);
		
		
		//根据食谱名字查询食谱基本信息
		RecipebasicEntity recipebasicEntity = 	recipebasicService.findByName(foodName);
		
		System.out.println("三生三世  ---评论 食谱基本信息： " + recipebasicEntity);
		//根据食谱名字查询食谱原料信息
		List<RecipematerailEntity> recipematerailEntity =	recipematerailService.findMessgeByName(foodName);
	
		//根据食谱名字查询食谱步骤信息
		List<RecipestepEntity> recipestepEntity = recipestepService.findMessageByName(foodName);
	
		
		//获取评论信息
		List<CommentEntity> commentlist =	commentService.findAllComment(foodName);
		
		for (CommentEntity commentEntity : commentlist) {
			System.out.println("评论信息：  " + commentEntity);
		}
	
		mav.addObject("recipeBasicMessage", recipebasicEntity);
		mav.addObject("recipeMaterailMessage", recipematerailEntity);
		mav.addObject("recipeStepMessage", recipestepEntity);
		mav.addObject("commentMessage", commentlist);
		
		mav.setViewName("/recipe.jsp");
		
		
		return mav;
	}
	
	
	
	
	/**
	 * 保存获取博客页面评论内容     添加评论
	 */
	@ResponseBody
	@RequestMapping("/saveBlog")
	public ModelAndView saveBlog(CommentEntity comment,String articlename
			,HttpSession session){
		ModelAndView mav = new ModelAndView();
		/*@RequestBody CommentEntity comment,String foodname, String articalName*/

		
		//从session中获取用户名
		String username = (String) session.getAttribute("username");
		//通过用户名查询用户信息
		CustomerEntity vo =	customerService.findOne(username);
		
		System.out.println("添加评论王菲王菲王菲： " +vo.toString());
		
		/*获取系统当前时间*/
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		System.out.println(time);

		comment.setCreateTime(time);
		comment.setArticlename(articlename);
		
		if (username != null) {
			if (vo.getNickname() != null) {
				comment.setCustomername(vo.getNickname());
			} else {
				comment.setCustomername(username);

			}
			
		} else {
			comment.setCustomername("游客");

		}

		comment.setCustomerimg(vo.getHeadimg());
		
		commentService.save(comment);
		
		
		//根据博客名字查询博客信息
		BlogEntity blogEntity = blogService.findByName(articlename);
				
		//获取评论信息
		List<CommentEntity> commentlist =	commentService.findAllCommentByBlogName(articlename);

		mav.addObject("blogMessage", blogEntity);
		mav.addObject("commentBlogMessage", commentlist);
		
		mav.setViewName("/bolgOne.jsp");
		
		
		return mav;
	}
	
	
	/**
	 * 获取评论
	 */
	@ResponseBody
	@RequestMapping("/findComment")
	public void findComment(String name){
		
		List<CommentEntity> list =	commentService.findAllCommentByBlogName(name);
	
		for (CommentEntity commentEntity : list) {
			System.out.println(commentEntity);
		}
	}
	

	/**
	 * 获取评论
	 */
	@ResponseBody
	@RequestMapping("/findTime")
	public void findTime(){
		String name= "水煮鱼片";
	
	
			System.out.println(commentService.findTime());
	
	}
	
	
}
