package io.renren.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import io.renren.entity.RecipematerailEntity;
import io.renren.service.RecipematerailService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;



@Controller
@RequestMapping("recipematerail")
public class RecipematerailController {
	@Autowired
	private RecipematerailService recipematerailService;
	
	/*@RequestMapping("/recipematerail.html")
	public String list(){
		return "recipematerail/recipematerail.html";
	}*/
	
	
	
	/**
	 * 查询所有
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestBody Integer[] ids){
		recipematerailService.findAll();
		
		return null;
	}
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<RecipematerailEntity> recipematerailList = recipematerailService.queryList(map);
		int total = recipematerailService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(recipematerailList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		RecipematerailEntity recipematerail = recipematerailService.queryObject(id);
		
		return R.ok().put("recipematerail", recipematerail);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ModelAndView save( RecipematerailEntity recipematerail
			,HttpSession httpSession,String[] materailname,String[] meterailnumber){
		
		
	
		
		ModelAndView modelAndView  = new ModelAndView();
		
		String  recipematerailName= recipematerail.getMaterailname();
		String recipematerailNumber = recipematerail.getMeterailnumber();
		//获取session中的菜谱名
		String recipeName = (String)httpSession.getAttribute("recipeName");
		
		
		System.out.println("美食材料名：" + recipematerail.getMaterailname() + "美食原料数量 ：" + recipematerail.getMeterailnumber());
		System.out.println("美食原料："+ recipeName);
		//把菜谱名加入到实体中
		//recipematerail = new RecipematerailEntity(recipematerailName,recipematerailNumber,recipeName);
		//保存原料内容
		
		//批量增加到集合中
		List<RecipematerailEntity> list = new  ArrayList<RecipematerailEntity>();
		for (int i = 0; i < materailname.length; i++) {
			
		RecipematerailEntity recipematerailEntitys  =	new RecipematerailEntity();
			recipematerailEntitys.setFoodname(recipeName);
			recipematerailEntitys.setMaterailname(materailname[i]);
			recipematerailEntitys.setMeterailnumber(meterailnumber[i]);
			list.add(recipematerailEntitys);
		}
			
		recipematerailService.saveBatch(list);
		
		System.out.println("菜的名字： " + recipematerail.getMaterailname());
		System.out.println("菜谱名字： " + recipematerail.getFoodname());
		System.out.println("菜的数量： " + recipematerail.getMeterailnumber());
		
		
		
		//recipematerailService.save(recipematerail);
		
		System.out.println("食谱材料-------");
		
		//销毁session
		//	httpSession.removeAttribute("recipeName");
		
		modelAndView.setViewName("/submit_recipe_step.jsp");
		
		return modelAndView;
		
		
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody RecipematerailEntity recipematerail){
		recipematerailService.update(recipematerail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		recipematerailService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
