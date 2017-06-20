package io.renren.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import io.renren.entity.RecipestepEntity;
import io.renren.service.RecipestepService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;



@Controller
@RequestMapping("recipestep")
public class RecipestepController {
	@Autowired
	private RecipestepService recipestepService;
	
	@RequestMapping("/recipestep.html")
	public String list(){
		return "recipestep/recipestep.html";
	}
	
	
	
	
	/**
	 * 查询所有
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public void findAll(){
		
		recipestepService.findAll();
		
	}
	
	
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public R f(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<RecipestepEntity> recipestepList = recipestepService.queryList(map);
		int total = recipestepService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(recipestepList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		RecipestepEntity recipestep = recipestepService.queryObject(id);
		
		return R.ok().put("recipestep", recipestep);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ModelAndView save( RecipestepEntity recipestep
			,HttpSession httpSession
			,String[] foodstep){
		
		//获取session
		String foodName =  (String) httpSession.getAttribute("recipeName");
		
		ModelAndView mav = new ModelAndView();
		
		//String step = recipestep.getFoodstep();
		
		
		List<RecipestepEntity> list = new ArrayList<RecipestepEntity>();
		for (int i = 0; i < foodstep.length; i++) {
			RecipestepEntity recipestepEntity = new RecipestepEntity();
			recipestepEntity.setFoodstep(foodstep[i]);
			recipestepEntity.setFoodname(foodName);
			list.add(recipestepEntity);
			
		}
		
		
		recipestepService.saveBatch(list);
		
		
		System.out.println("食谱步骤------");
		
		
		mav.setViewName("/SuccessRecipe.jsp");
		
		//删除session
		httpSession.removeAttribute("recipeName");
		
		return mav;
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody RecipestepEntity recipestep){
		recipestepService.update(recipestep);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		recipestepService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
