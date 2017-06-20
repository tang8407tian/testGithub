package io.renren.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import io.renren.entity.BlogEntity;
import io.renren.entity.CommentEntity;
import io.renren.entity.CustomerEntity;
import io.renren.entity.RecipebasicEntity;
import io.renren.service.BlogService;
import io.renren.service.CommentService;
import io.renren.service.CustomerService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * InnoDB free: 10240 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-21 18:11:19
 */
@Controller
@RequestMapping("blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/blog.html")
	public String list(){
		return "blog/blog.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",defaultValue="1") Integer page){
		
		ModelAndView mav = new ModelAndView();

		 
		Integer limit = 4;
		
		boolean isFirst = false;
		boolean isLast = false;
		
		//
		if(page <= 1){
			isFirst = true;
		}
		
		
		//查询博客数据总数
		Integer allBlog =	blogService.findAll();
		
		//分页查询
				Map<String, Object> map = new HashMap<>();
				
				map.put("offset", (page - 1) * limit);
				map.put("limit", limit);
				
				List<BlogEntity> blogList =	blogService.findAllAndPage(map);
				
				System.out.println("食谱总数： " + allBlog);
				System.out.println("食谱分页： " + blogList);
				System.out.println("map   toString  " +map.toString());
				System.out.println("map" +map);
				
				
				//总页数
				//Integer	totalPage = count/limit;
				Integer totalPage = allBlog%limit==0? allBlog/limit : (allBlog/limit)+1;
				
				//判断尾页
				if (page >= totalPage ) {
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
				mav.addObject("allPageList", blogList);
				
				
				System.out.println("首页  ：" +  isFirst);
				System.out.println("尾页  ：" + isLast );
				System.out.println("当前页  ：" + page );
				
				mav.setViewName("forward:/blogList.jsp");
		
		return mav;
	}
	
	
	/**
	 * 信息  根据ID查询博客信息
	 */
	@ResponseBody
	@RequestMapping("/findByid")
	public ModelAndView findByid(ModelAndView mav,Integer id){
		
		BlogEntity blog = blogService.queryObject(id);
		
		//根据博客名字获取评论信息
		List<CommentEntity> commentlist =	commentService.findAllCommentByBlogName(blog.getBolgname());

		mav.addObject("commentBlogMessage", commentlist);
		mav.addObject("blogMessage", blog);
		mav.setViewName("/bolgOne.jsp");
		return mav;
	}
	
	/**
	 * 添加博客
	 */
	@ResponseBody
	@RequestMapping("/save")
	public ModelAndView save( BlogEntity blog
							,ModelAndView mav
							,@RequestParam("file1")  MultipartFile file
							,HttpServletRequest request
							,HttpSession session){
		//从session中获取用户名
		String user = (String) session.getAttribute("username");

		
		//检查博客名字是否存在		
		BlogEntity isBlogEntity =	blogService.findByName(blog.getBolgname());
		
		//blogService.save(blog);
		
		//检验用户是否登录
		if (user != null) {
			//通过用户名获取用户信息	
			CustomerEntity customerEntity =	customerService.findOne(user);
			System.out.println("博客：" + customerEntity.toString());
			blog.setHeadimg(customerEntity.getHeadimg());
			
			//检验博客名是否存在
			if (isBlogEntity != null) {
				System.out.println("博客已存在,请重新输入！！！！");
				
			} else {
				
				
				
			//上传图片
				//当前目录路径
				String currentPath=getClass().getResource(".").getFile().toString(); 
				System.out.println(" 目录路径 " + currentPath);
				//取得上传文件名字
				String fileName = file.getOriginalFilename() ;
				//图片保存路径设置
				String filePath = request.getServletContext().getRealPath("/BlogImgs");
				
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
				String dirName 	= "/BlogImgs/";
				String ImgPath	= dirName+fileName;
				
				//向实体域中添加图片路径
				
				blog.setHeadimg(ImgPath);
			//上传图片结束
				
				//添加用户名	
				if (customerEntity.getNickname() != null) {
					//用户昵称存在使用昵称
					blog.setCustomername(customerEntity.getNickname());
				} else {
					//用户昵称不存在使用用户名
					blog.setCustomername(user);

				}
			//获取时间
				/*获取系统当前时间*/
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd ");
				String time=format.format(date);
				System.out.println(time);
				String[] times = time.split("-");
				blog.setCreatetimeyear(times[0]);
				blog.setCreatetimemouth(times[1]);
				blog.setCreatetimeday(times[2]);
				
				
				blog.setCustomerImg(customerEntity.getHeadimg());
					
				System.out.println(blog.toString());
				
				blogService.save(blog);
				mav.setViewName("/recipebasic/findSomeNub");
				

			}
			
			
			
		} else {
			
			System.out.println("么有登录不能发布博客");
			mav.addObject("noSearcha","你没有登录请登录后在发布博客" );
			mav.setViewName("/errorPage.jsp");

		}
		
		
		return mav;
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody BlogEntity blog){
		blogService.update(blog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		blogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
