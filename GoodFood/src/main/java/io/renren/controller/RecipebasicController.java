package io.renren.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.attribute.FileTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.renren.entity.BlogEntity;
import io.renren.entity.RecipebasicEntity;
import io.renren.entity.RecipeimgEntity;
import io.renren.entity.RecipematerailEntity;
import io.renren.entity.RecipestepEntity;
import io.renren.service.BlogService;
import io.renren.service.CommentService;
import io.renren.service.CustomerService;
import io.renren.service.RecipebasicService;
import io.renren.service.RecipeimgService;
import io.renren.service.RecipematerailService;
import io.renren.service.RecipestepService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * InnoDB free: 10240 kB
 * 
 * 美食做法的一些操作    向首页添加数据
 * @date 2017-05-19 18:54:14
 */
@Controller
@RequestMapping("recipebasic")
public class RecipebasicController {
	//美食基本信息
	@Autowired
	private RecipebasicService recipebasicService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CommentService commentService;
	
	
	/*@RequestMapping("/recipebasic.html")
	public String list(){
		return "recipebasic/recipebasic.html";
	}
	*/
	
	

	
	/**
	 * 查询一份食谱并展示到首页
	 */
	@ResponseBody
	@RequestMapping("/findOne")
	public ModelAndView findOne( ){
		RecipebasicEntity OneRecipebasicEntity	 = recipebasicService.findOne();
		System.out.println(OneRecipebasicEntity);
		return null;
	}
	
	
	
	/**
	 * 保存   添加美食做法+图片保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ModelAndView save( RecipebasicEntity recipebasic,Model model
			,@RequestParam("file1") MultipartFile file
			,HttpServletRequest request
			, HttpServletResponse response
			,HttpSession httpSession){
			
		ModelAndView mav = new ModelAndView();
		
	//验证食谱名字是否为空
		if (!recipebasic.getFoodname().isEmpty() 
				&& recipebasic.getFoodname() != ""
				&& recipebasic.getFoodname() != null) {
			
			
			boolean isEmpty = recipebasicService.findName(recipebasic.getFoodname());
			
			if (isEmpty == true) {
				model.addAttribute("recipeErrorMsg", "食品名已经存在--请重新输入！！");
				mav.setViewName("forward:/submit_recipe.jsp");
				
			} else {
				
				//把内容添加到session域中
				httpSession.setAttribute("recipeName", recipebasic.getFoodname());
				
			//上传图片
				//当前目录路径
				String currentPath=getClass().getResource(".").getFile().toString(); 
				System.out.println(" 目录路径 " + currentPath);
				//取得上传文件名字
				String fileName = file.getOriginalFilename() ;
				//图片保存路径设置
				String filePath = request.getServletContext().getRealPath("/img");
				
				//图片保存路径       File.separator：文件路径分隔符用File.separator 代替
				//图片保存的文件名 C:\Users\fish\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\GoodFood\img\     
			
				
				String ImgfilePath = filePath + File.separator;
				//图片实际在地址
				String imgTruePath = ImgfilePath + fileName;

				// 上传文件到服务器
						try {
							file.transferTo(new File(imgTruePath));

							} catch (Exception e) {
								e.printStackTrace();
								
						}
						
				//保存到数据库里的路径
				String dirName 	= "/img/";
				String ImgPath	= dirName+fileName;
				
				//向实体域中添加图片路径
				recipebasic.setImgfilepath(ImgPath);
				
				//成功
				recipebasicService.save(recipebasic);
							
				mav.setViewName("/submit_recipe_materail.jsp");

			}
			
			
			
			
			
		} else {
			
			model.addAttribute("recipeErrorMsg", "食品名不能为空！！");
			mav.setViewName("forward:/submit_recipe.jsp");
			
		}
		
		return  mav;
	}
	
	
	
	
	/**
	 * 数据统计 
	 * 查询    随机10条    倒序查询    随机1条
	 */
	@ResponseBody
	@RequestMapping("/findSomeNub")
	public ModelAndView select(HttpServletRequest request
			,HttpServletResponse response
			,HttpSession httpSession){
		
		ModelAndView mav = new ModelAndView();
		//倒序查询
		List<RecipebasicEntity> recipebasicList = recipebasicService.selectList();
		//随机查询10条
		List<RecipebasicEntity> rand = recipebasicService.findByRand();
		//随机查询1条
		RecipebasicEntity OneRecipebasicEntity	 = recipebasicService.findOne();
		//查询5条食谱数据
		List<RecipebasicEntity> recipebasicByListNumber = recipebasicService.finByNumber();
		//根据用户名查询食谱
		List<RecipebasicEntity> customerList = recipebasicService.findByCustmerName("唐棒");
		
		for (RecipebasicEntity recipebasicEntity : customerList) {
			System.out.println("根据用户名查询： " + recipebasicEntity);
		}
		
		//倒序查询博客数据6条
		List<BlogEntity> bolgList = blogService.findByRand();
		//查询
		
		

		//用户成员总数
		Integer allCustomer = customerService.finAllCustomer();
		//食谱总数
		Integer allRecipe = recipebasicService.findAllRecipe();
		//博客总数
		Integer allBlog = blogService.findAllBlog();
		//评论总数
		Integer allComment = commentService.findAllCommentNumber();
		
		
		/**
		 * 插入轮换图的5条数据
		 */
		mav.addObject("lunhuan1", recipebasicByListNumber.get(0));
		mav.addObject("lunhuan2", recipebasicByListNumber.get(1));
		mav.addObject("lunhuan3", recipebasicByListNumber.get(2));
		mav.addObject("lunhuan4", recipebasicByListNumber.get(3));
		mav.addObject("lunhuan5", recipebasicByListNumber.get(4));
		
		//随机查询10条
		mav.addObject("recipeFindByRand", rand);
		//倒序查询
		mav.addObject("rcipeList",recipebasicList);
		//随机查询1条
		mav.addObject("rcipeOne",OneRecipebasicEntity);
		//倒序查询博客数据6条
		mav.addObject("bolgList",bolgList);
		
		//用户成员总数
		mav.addObject("allCustomer", allCustomer);
		//食谱总数
		mav.addObject("allRecipe", allRecipe);
		//博客总数
		mav.addObject("allBlog", allBlog);
		//评论总数
		mav.addObject("allComment", allComment);
		
		mav.setViewName("/index.jsp");

		return  mav;
		
	}
	

	
	

	
	
		
	


	
	
}
