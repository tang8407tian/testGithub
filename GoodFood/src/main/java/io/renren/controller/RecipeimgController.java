package io.renren.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import io.renren.entity.RecipeimgEntity;
import io.renren.service.RecipeimgService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;



@Controller
@RequestMapping("recipeimg")
public class RecipeimgController {
	@Autowired
	private RecipeimgService recipeimgService;
	
	/*@RequestMapping("/recipeimg.html")
	public String list(){
		return "recipeimg/recipeimg.html";
	}
	*/
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
		List<RecipeimgEntity> recipeimgList = recipeimgService.queryList(map);
		int total = recipeimgService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(recipeimgList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		RecipeimgEntity recipeimg = recipeimgService.queryObject(id);
		
		return R.ok().put("recipeimg", recipeimg);
	}
	
	/**
	 * 保存图片
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ModelAndView save(RecipeimgEntity recipeimg
			,@RequestParam("file1") MultipartFile file
			,HttpServletRequest request
			, HttpServletResponse response
			,HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		
		
		
		//
		String nowTime =System.currentTimeMillis() +"";
		
		System.out.println("   " +nowTime);
		//当前目录路径
		String currentPath=getClass().getResource(".").getFile().toString(); 
		System.out.println(" 目录路径 " + currentPath);
		
		
		
		//取得上传文件名字
		String fileName = file.getOriginalFilename() ;
		
		/*System.out.println("原图片名字：" + fileName);
		//确保图片名字唯一
		String fileName1 =nowTime + fileName ;*/
		
		
		//图片保存路径设置
		String filePath = request.getServletContext().getRealPath("/img");
		
		//图片保存路径       File.separator：文件路径分隔符用File.separator 代替
		String ImgfilePath = filePath + File.separator;
		//图片实际在地址
		String imgTruePath = ImgfilePath + fileName;
		
		
		
		
		//自定义路径
		//String myPath = "C:\Users\fish\workspace\GoodFood\src\main\webapp\img";
		
		System.out.println("图片名字：  " +fileName );
		
		
		System.out.println(" file(): " + filePath + File.separator );
		System.out.println(" img(): " + filePath + File.separator + fileName);
		
		// 上传文件到服务器
		try {
			file.transferTo(new File(imgTruePath));

			} catch (Exception e) {
				e.printStackTrace();
		}

		//把图片路径  名字  保存在RecipeimgEntity中
		//获取session
		String foodName = (String) httpSession.getAttribute("recipeName");
		System.out.println("foodName1" + fileName);
		System.out.println("pathName1" + imgTruePath);
		//public RecipeimgEntity(String imgfoodname, String imgfilepath)
		RecipeimgEntity img  =	new RecipeimgEntity();
		img.setImgfoodname(foodName);
		img.setImgfilepath(imgTruePath);
		System.out.println("foodName2" + img.getImgfoodname());
		System.out.println("pathName2" + img.getImgfilepath());
		recipeimgService.save(img);
		
		//删除session
		httpSession.removeAttribute("recipeName");
		
		System.out.println("Img session" + httpSession);
		mav.setViewName("/registSuccess.jsp");
		return mav;
	}
	
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/findImg")
	public ModelAndView findImg(HttpServletRequest request
			,HttpServletResponse response
			,HttpSession httpSession
			,ModelAndView mav){
		
		
		RecipeimgEntity recipeimg = recipeimgService.findImg();
		
		
		mav.setViewName("/index.jsp");
		
		return mav;
	}
	
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody RecipeimgEntity recipeimg){
		recipeimgService.update(recipeimg);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		recipeimgService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
