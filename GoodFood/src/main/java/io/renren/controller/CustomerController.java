package io.renren.controller;
import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.renren.entity.CustomerEntity;
import io.renren.service.BlogService;
import io.renren.service.CommentService;
import io.renren.service.CustomerService;
import io.renren.service.RecipebasicService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CommentService commentService;
	
	
	//美食基本信息
		@Autowired
		private RecipebasicService recipebasicService;
	
	//没有注释容易在跳转其他页面时路径添加一个customer/
	/*@RequestMapping("/customer.html")
	public String list(){
		return "customer/customer.html";
	}*/
	
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
		List<CustomerEntity> customerList = customerService.queryList(map);
		int total = customerService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(customerList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	
	
	/**
	 * 保存   注册
	 */
	@ResponseBody
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public ModelAndView save( CustomerEntity customer,Model model){
		
		ModelAndView mav = new ModelAndView();
		
		//判断账号密码是否为空
		if (!customer.getCustomerName().isEmpty()
				&& !customer.getCustomerPassword().isEmpty()
				)
				 {
			
			//验证密码是否正确
			if (customer.getCustomerPassword().equals(customer.getRepeatCustomerPassword())) {
				if (!customer.getCustomerName().isEmpty()
						&& !customer.getCustomerPassword().isEmpty()) {
						
					} else {

					}
					boolean flage = customerService.findByName(customer);
					if (flage == false) {
						//添加用户  默认用户状态为0   0：普通用户   1：管理员
						customer.setStatus(0);
						
						customerService.save(customer);	
						mav.setViewName("/SuccessRegist.jsp");

					} else {
						model.addAttribute("errorMesRegister", "用户名已存在！！！");
						mav.setViewName("/register.jsp");
					}
				
			} else {
				model.addAttribute("errorMessage", "密码验证错误");
				mav.setViewName("/register.jsp");

			}				
			
		}else {
			model.addAttribute("errorMessage", "账号密码不能为空");
			mav.setViewName("/register.jsp");
		}
		
		return mav;
		
	}
	
	

	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login( CustomerEntity customer
			,Model model
			,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//判断用户名密码是否为空
		if (customer.getCustomerName() != ""
			&&	customer.getCustomerName() != null	
			&& !customer.getCustomerName().isEmpty()
			&&	 !customer.getCustomerPassword().isEmpty()
					) {
			
					boolean flag = customerService.login(customer);	
			
					
			//登陆成功
			if (flag == true) {
				
				//把用户名放入session中
				session.setAttribute("username", customer.getCustomerName());
				//页面跳转
				mav.setViewName("/recipebasic/findSomeNub");
			}
			//登录失败
			else {
				model.addAttribute("errorMesLogin", "用户名或密码错误");
				mav.setViewName("forward:/login.jsp");
				
			
				
			}					
			
		}else {
			//为空
			model.addAttribute("errorMesLogin", "用户名或密码不能为空");
			mav.setViewName("redirect:/login.jsp");
		}
		
		String string = mav+"";
		System.out.println("mav   " + string);
		return mav;
		
	}
	
	/**
	 * 获取页面参数并像页面返回参数
	 * @param customer
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/git", method = RequestMethod.POST)
	public ModelAndView  git( CustomerEntity customer,Model model){
		ModelAndView mav = new ModelAndView();

		
		
		System.out.println("name:  " + customer.getCustomerName());
		mav.addObject("在jsp页面使用的名字", "查询到的对象名");
		mav.addObject("customer", customer);
		model.addAttribute("message", "你好");
		mav.setViewName("/register.jsp");
		return mav;
		
	}
	
	
	
	
	/**
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/randRecipe", method = RequestMethod.POST)
	public R loginss( CustomerEntity customer){
		
		System.out.println("name:" + customer.getCustomerName());
		
		return null;
		
	}
	
	/**
	 *<input id="customerName" /input>   id对应query 
	 * 从页面直接获取参数   与文本框里的   name属性相对应<input name="customerName" id="customerName" /input> == String customerName
	 */
	@ResponseBody
	@RequestMapping(value="/savea", method = RequestMethod.POST)
	public R savea( String customerName,String customerPassword){
		
		System.out.println("name:"+ customerName);
		
		return null;
		
	}
	
	
	/**
	 * 修改个人信息1--通过ID查询信息
	 */
	@ResponseBody
	@RequestMapping("/update1")
	public ModelAndView update(Integer id,ModelAndView mav){

		CustomerEntity customerEntity =	customerService.queryObject(id);
		
		mav.addObject("oneCustomerMessage", customerEntity);
		mav.setViewName("/meInfoToUpdate.jsp");
	
		return mav;
	}
	
	
	/**
	 * 修改个人密码1--通过ID查询信息
	 */
	@ResponseBody
	@RequestMapping("/modifypassword1")
	public ModelAndView modifypassword(Integer id,ModelAndView mav){

		CustomerEntity customerEntity =	customerService.queryObject(id);
		System.out.println("修改密码Id ； " + customerEntity.getId());
		mav.addObject("ids", customerEntity.getId());
		mav.setViewName("/modifyPassword.jsp");
	
		return mav;
	}
	
	

	/**
	 * 修改个人信息密码2--通过邮箱、密码检验信息
	 */
	@ResponseBody
	@RequestMapping("/modifypassword2")
	public ModelAndView modifypasswordT(CustomerEntity customerEntity,ModelAndView mav){
		Integer oldid = customerEntity.getId();
		
		System.out.println("idss : " + customerEntity.getId());
		System.out.println("oldid1 : " + oldid);

		CustomerEntity oldcustomerEntity =	customerService.queryObject(customerEntity.getId());

		System.out.println("用户：" + customerEntity.toString());
		CustomerEntity iscustomerEntity2 = customerService.findByPassAndEmeil(customerEntity);
		
		if (iscustomerEntity2 == null) {
						
			mav.addObject("ids", customerEntity.getId());
			mav.addObject("errormodify", "邮箱或密码错误");
			mav.setViewName("/modifyPassword.jsp");
		} else {
			
			mav.addObject("ids", oldid);
			mav.setViewName("/modifyPasswordNow.jsp");

		}
		
		
		System.out.println("查询用户是否存在：  " + iscustomerEntity2 );
		//mav.addObject("ids", customerEntity.getId());
		//mav.setViewName("/modifyPassword.jsp");
	
		return mav;
	}
	
	/**
	 * 修改个人密码3--通过ID查询信息
	 */
	@ResponseBody
	@RequestMapping("/modifypassword3")
	public ModelAndView modifypasswordthree(CustomerEntity customerEntity,ModelAndView mav){

		
		System.out.println("修改密码Id 实体详情：  " + customerEntity);
		mav.addObject("ids", customerEntity.getId());
		mav.setViewName("/modifyPassword.jsp");
	
		return null;
	}
	
	
	/**
	 *添加个人信息
	 */
	@ResponseBody
	@RequestMapping("/addMe")
	public ModelAndView addMe( CustomerEntity customer
							,@RequestParam("file1")  MultipartFile file
							,HttpServletRequest request
							,HttpSession session){
		ModelAndView mav = new ModelAndView();

		String user = (String) session.getAttribute("username");
		
		System.out.println(user);
		
		
		//上传图片
		//当前目录路径
		String currentPath=getClass().getResource(".").getFile().toString(); 
		System.out.println(" 目录路径 " + currentPath);
		//取得上传文件名字
		String fileName = file.getOriginalFilename() ;
		//图片保存路径设置
		String filePath = request.getServletContext().getRealPath("/headImg");
		
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
		String dirName 	= "/headImg/";
		String ImgPath	= dirName+fileName;
		
		//向实体域中添加图片路径
		customer.setHeadimg(ImgPath);
		//添加用户名
		customer.setCustomerName(user);
		
		
		System.out.println(customer.toString());
		
		customerService.update(customer);
		
		CustomerEntity customerEntity =	new CustomerEntity();
		customerEntity.setCustomerName(user);
		
		CustomerEntity vo =	customerService.findByOneName(customerEntity);

		mav.addObject("myInfo", vo);
		mav.setViewName("/my_profile.jsp");
		
		return mav;
	}
	
	
	/**
	 * 查看个人信息
	 */
	@ResponseBody
	@RequestMapping("/findMe")
	public ModelAndView findMe( CustomerEntity customer,HttpSession session){
		ModelAndView mav = new ModelAndView();
		String user = (String) session.getAttribute("username");
		
		if (user != null) {
			
		CustomerEntity customerEntity =	new CustomerEntity();
		customerEntity.setCustomerName(user);
		//通过用户名查询用户信息
		CustomerEntity vo =	customerService.findByOneName(customerEntity);
		
		System.out.println("findMe : " + vo.toString());
		//统计发的帖子数
		//int blogtotal = blogService.findAllByName(vo);
		//System.out.println("发的帖子数" + blogtotal);
		//统计发的帖子数
		
		//查询发的菜谱信息
		
		
			mav.addObject("myInfo", vo);
			mav.setViewName("/my_profile.jsp");/*my_profile.jsp*/
		} else {
			
			System.out.println("么有查询到");
			mav.addObject("noSearcha","你没有登录请登录后在查看" );
			mav.setViewName("/errorPage.jsp");

		}
		
		
		
		return mav;
	}
	
	
	/**
	 * 查看个人发布的菜谱信息
	 */
	@ResponseBody
	@RequestMapping("/findMeRecipe")
	public ModelAndView findMeRecipe( CustomerEntity customer,HttpSession session){
		ModelAndView mav = new ModelAndView();
		String user = (String) session.getAttribute("username");
		
		if (user != null) {
			
		CustomerEntity customerEntity =	new CustomerEntity();
		customerEntity.setCustomerName(user);
		
		CustomerEntity vo =	customerService.findByOneName(customerEntity);
		
		System.out.println("findMe : " + vo.toString());
		//统计发的帖子数
		//int blogtotal = blogService.findAllByName(vo);
		//System.out.println("发的帖子数" + blogtotal);
		//统计发的帖子数
		
			mav.addObject("myInfo", vo);
			mav.setViewName("/my_profile.jsp");/*my_profile.jsp*/
		} else {
			
			System.out.println("么有查询到");
			mav.addObject("noSearcha","你没有登录请登录后在查看" );
			mav.setViewName("/errorPage.jsp");

		}
		
		
		
		return mav;
	}
	
	/**
	 * 删除  退出
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ModelAndView delete(HttpSession session){
		ModelAndView  mav = new ModelAndView();
		
		session.removeAttribute("username");
  		
		mav.setViewName("/recipebasic/findSomeNub");
		
		return mav;
	}
	
}
