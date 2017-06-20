<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
    
<!--header-->
	<header class="head" role="banner">
		<!--wrap-->
		<div class="wrap clearfix">
		
		<!-- 设置图片大小 -->
<!--<img src="images/ico/logo1.jpg" 
		 设置图片大小
		style=" width:163px;height:45px;"
		 alt="SocialChef logo" />		 
 -->	
 		<a href="${pageContext.request.contextPath}/recipebasic/findSomeNub" title="SocialChef" class="logo"><img src="<%=request.getContextPath() %>/images/ico/logo1.jpg" style=" width:163px;height:45px;" alt="SocialChef logo" /></a>
			
			<nav class="main-nav" role="navigation" id="menu">
				<ul>
					<li class="current-menu-item"><a href="${pageContext.request.contextPath}/recipebasic/findSomeNub" title="Home"><span>首页</span></a></li>
					<!--Recipes：食谱-->
					<li><a href="${pageContext.request.contextPath }/recipes.jsp" title="Recipes"><span>食谱</span></a>
						<ul>
							<li><a href="${pageContext.request.contextPath }/recipebasic/findSomeNubre" title="Recipes 2">食谱 2</a></li><li><a href="recipe.jsp" title="Recipe">食谱  3</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath }/recipebasic/findSomeNubblog.jsp" title="Blog"><span>博客</span></a>
						<ul>
							<li><a href="${pageContext.request.contextPath }/blog/list" title="Blog post">博客帖子</a></li>
						</ul>
					</li>
					<li><a href="#" title="Pages"><span>页面</span></a>
						<ul>
							<li><a href="left_sidebar.jsp" title="Left sidebar page">左侧边栏页面 </a></li>
							<li><a href="right_sidebar.jsp" title="Right sidebar page">右侧边栏页</a></li>
							<li><a href="two_sidebars.jsp" title="Both sidebars page">两侧都有页面</a></li>
							<li><a href="full_width.jsp" title="Full width page">全幅页面</a></li>
							<li><a href="login.jsp" title="Login page">登录页面</a></li><li><a href="register.html" title="Register page">注册页面</a></li>
							<li><a href="error404.jsp" title="Error page">错误页面</a></li>
						</ul>
					</li>
					<li><a href="#" title="Features"><span>网页特点效果</span></a>
						<ul>
							<li><a href="animations.html" title="Animations">动画</a></li>
							<li><a href="grid.html" title="Grid">网格</a></li>
							<li><a href="shortcodes.html" title="Shortcodes">简码</a></li>
							<li><a href="pricing.html" title="Pricing tables">价格表</a></li>
						</ul>
					</li>
					<li><a href="contact.jsp" title="Contact"><span>联系我们</span></a></li>
					
					
					
					<c:choose>
						<c:when test="${sessionScope.username != null }">
							<li><a style="color:green"  title="Contact"><span>欢迎光临：${sessionScope.username }</span></a></li>
							<li><a style="color:green"  href="${pageContext.request.contextPath }/customer/delete" title="Contact"><span>退出</span></a></li>
						</c:when>
						
						<c:otherwise>
						<li><a  style="color:blue" href="${pageContext.request.contextPath }/login.jsp"  title="Contact"><span>请登录</span></a></li>
						</c:otherwise>
					</c:choose>
					
					
					
					
					
					<!-- <li class="current-menu-item"><a  title="Home"><span>欢迎光临：</span>塞上风</a></li> -->
					
				</ul>
				
			</nav>
			
			<nav class="user-nav" role="navigation">
				<ul>
					<li class="light"><a href="${pageContext.request.contextPath }/find_recipe.jsp" title="Search for recipes"><i class="ico i-search"></i> <span>搜索食谱</span></a></li>
					<li class="medium"><a href="${pageContext.request.contextPath }/customer/findMe" title="My account"><i class="ico i-account"></i> <span>我的账号</span></a></li>
					<li class="dark"><a href="${pageContext.request.contextPath }/submit_recipe.jsp" title="Submit a recipe"><i class="ico i-submitrecipe" style=""></i> <span>提交一份食谱</span></a></li>
				</ul>
			</nav>
		</div>
		<!--//wrap-->
	</header>
	<!--//header-->