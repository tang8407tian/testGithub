package io.renren.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.renren.entity.CommentEntity;
import io.renren.entity.RecipebasicEntity;
import io.renren.entity.RecipematerailEntity;
import io.renren.entity.RecipestepEntity;
import io.renren.service.CommentService;
import io.renren.service.RecipebasicService;
import io.renren.service.RecipematerailService;
import io.renren.service.RecipestepService;
import io.renren.utils.R;

@RestController
@RequestMapping("recipeAllMessage")
public class RecipeAllMessage {
	
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

		
		/**
		 * 根据食谱名字获取一份食谱全部信息
		 */
		@RequestMapping("/findRecipeByName")
		public  ModelAndView findRecipeByName(String name){
			ModelAndView mav = new ModelAndView();
			
			System.out.println("name :" + name);
			
			//根据食谱名字查询食谱基本信息
			RecipebasicEntity recipebasicEntity = 	recipebasicService.findByName(name);
			//根据食谱名字查询食谱原料信息
			List<RecipematerailEntity> recipematerailEntity =	recipematerailService.findMessgeByName(name);
		
			//根据食谱名字查询食谱步骤信息
			List<RecipestepEntity> recipestepEntity = recipestepService.findMessageByName(name);
	
			
			//获取评论信息
			List<CommentEntity> commentlist =	commentService.findAllComment(name);
			
			/*for (CommentEntity commentEntity : commentlist) {
				System.out.println("评论信息：  " + commentEntity);
			}*/
		
			mav.addObject("recipeBasicMessage", recipebasicEntity);
			mav.addObject("recipeMaterailMessage", recipematerailEntity);
			mav.addObject("recipeStepMessage", recipestepEntity);
			mav.addObject("commentMessage", commentlist);
			
			mav.setViewName("/recipe.jsp");
		
		
			return mav;
			
			
		}
		
		//查询所有食谱
		@RequestMapping("/findAllRecipe")
		public ModelAndView findAllRecipe(@RequestParam(value="page",defaultValue="1") Integer page){
			
			ModelAndView mav = new ModelAndView();

		 
			Integer limit = 4;
			
			boolean isFirst = false;
			boolean isLast = false;
			
			//
			if(page <= 1){
				isFirst = true;
			}
			
			
		//查询食谱数据总数
		Integer count =	recipebasicService.findAllRecipe();
		
		//分页查询
		Map<String, Object> map = new HashMap<>();
		
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		List<RecipebasicEntity> list = recipebasicService.findAndPage(map);
		
		System.out.println("食谱总数： " + count);
		System.out.println("食谱分页： " + list);
		System.out.println("map   toString  " +map.toString());
		System.out.println("map" +map);
		for (RecipebasicEntity recipebasicEntity : list) {
			
			System.out.println("食谱分页详情： " + recipebasicEntity);
		}
		
		//总页数
		//Integer	totalPage = count/limit;
		Integer totalPage = count%limit==0? count/limit : (count/limit)+1;
		mav.addObject("totalPage", totalPage);
		//判断尾页
		if (page > totalPage ) {
			isLast = true;
		}
		//当前页数
		mav.addObject("pages", page);
		
		//总页数
		mav.addObject("totalPage", totalPage);
		
		//首页
		mav.addObject("isFirst", isFirst);
		
		//尾页
		mav.addObject("isLast", isLast);
		
		//当前集合信息
		mav.addObject("allPageList", list);
		
		mav.setViewName("forward:/recipesList.jsp");
		return mav;
			
		}
}
