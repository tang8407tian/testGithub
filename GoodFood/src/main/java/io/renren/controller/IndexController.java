package io.renren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.renren.entity.RecipebasicEntity;
import io.renren.entity.RecipematerailEntity;
import io.renren.entity.RecipestepEntity;
import io.renren.service.RecipebasicService;
import io.renren.service.RecipematerailService;
import io.renren.service.RecipestepService;

/**
 * 搜索功能
 * @author fish
 *
 */

@Controller
@RequestMapping("findBy")
public class IndexController {

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
		 * 条件搜索
		 */
		@ResponseBody
		@RequestMapping("/indexSearch")
		public ModelAndView search(String names){
			
			ModelAndView mav =	new ModelAndView();
			System.out.println("页面参数 ： " +names);
			
			
			//根据食谱名字查询食谱基本信息
			RecipebasicEntity recipebasicEntity = 	recipebasicService.findByName(names);		
			if (recipebasicEntity == null) {
				System.out.println("么有查询到");
				mav.addObject("noSearcha","查询结果无法找到或已从数据库中删除" );
				mav.setViewName("/errorPage.jsp");
			} else {

				System.out.println("查询到了");
				
				
				//根据食谱名字查询食谱原料信息
				List<RecipematerailEntity> recipematerailEntity =	recipematerailService.findMessgeByName(names);
			
				//根据食谱名字查询食谱步骤信息
				List<RecipestepEntity> recipestepEntity = recipestepService.findMessageByName(names);
			
				mav.addObject("recipeBasicMessage", recipebasicEntity);
				mav.addObject("recipeMaterailMessage", recipematerailEntity);
				mav.addObject("recipeStepMessage", recipestepEntity);
			
				mav.setViewName("/recipe.jsp");
				
				
			}
		
			System.out.println("搜索 ：   " + recipebasicEntity);


			return mav;
		}
		
		
		
}
