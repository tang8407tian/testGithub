<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<jsp:include page="common/commonHead.jsp" />
</head>
<body>
	<!--header-->
		<jsp:include page="common/commonHeader.jsp" />
		
	<!-- //header -->
		
	<!--main-->
	<main class="main" role="main">
		<!--wrap-->
		<div class="wrap clearfix">
			<!--breadcrumbs-->
			<nav class="breadcrumbs">
				<ul>
					<li><a href="index.html" title="Home">首页</a></li>
					<li>博客</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title wow fadeInLeft">
					<h1>博客</h1>
				</header>
				
				<!--content-->
				<section class="content three-fourth wow fadeInLeft">
				
			
			
				
				<cc:forEach items="${allPageList }" var="blogs">
				
				<!-- 隐藏的ID -->
				<input type="hidden" name="id" value="${blogs.id }" >
				
				<!--blog entry-->
					<article class="post">
				
						<div class="entry-meta">
							<div class="date">
							<!-- 显示时间 -->
								<span class="day">${blogs.createtimeday }</span> 
								<span class="my">${blogs.createtimeyear }年${blogs.createtimemouth }月</span>
							</div>
							<div class="avatar">
							<!-- 头像  昵称 -->
								<a href="my_profile.html"><img src="<%=request.getContextPath() %>${blogs.customerImg }" alt="" /><span>${blogs.customername }</span></a>
							</div>
						</div>
						<div class="container">
							<div class="entry-featured"><a href="blog_single.html"><img src="<%=request.getContextPath() %>${blogs.headimg }" style=" width:328px;height:244px; alt="" /></a></div>
							<div class="entry-content">
							<!-- 博客简介 -->
								<h2><a href="blog_single.html">${blogs.bolgname }</a></h2>
								<p>${blogs.summary } </p>
							</div>
							<div class="actions">
								<div>
									<div class="category"><i class="ico i-category"></i><a href="#">技巧和窍门</a></div>
									<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/blog_single.html#comments">27</a></div>
									<div class="leave_comment"><a href="http://www.themeenergy.com/themes/html/social-chef/blog_single.html#respond">发表评论</a></div>
									<div class="more"><a href="${pageContext.request.contextPath }/blog/findByid?id=${blogs.id }">阅读更多</a></div>
								</div>
							</div>
						</div>
					</article>
					<!--//blog entry-->
				</cc:forEach>
			
					
					
					
					
				
				<!-- 分页 -->					
						<div class="quicklinks">	
						<!-- 首页 -->
							<a href="${pageContext.request.contextPath}/blog/list?page=1" class="button">首页</a>
						<!-- 上一页 -->
						
							<cc:if test="${isFirst == false}">
							<a href="${pageContext.request.contextPath}/blog/list?page=${pages-1} " class="button">上一页</a>|
							</cc:if>
						<!-- 2/5页 -->
							<span>  ${pages}/${totalPage} 页|</span>
						<!-- 下一页 -->	
							<cc:if test="${isLast == false}">
								<a href="${pageContext.request.contextPath}/blog/list?page=${pages+1}" class="button">下一页</a>
							</cc:if>	
						<!-- 尾页 -->
							<a href="${pageContext.request.contextPath}/blog/list?page=${totalPage}" class="button">尾页</a>
						<!-- 返回首部	 -->
							<a href="javascript:void(0)" class="button scroll-to-top">返回首部</a>
						</div>
			<!--// 分页 -->	
					
					
				</section>
				<!--//content-->
				
				<!--right sidebar-->
				<aside class="sidebar one-fourth">
					<div class="widget">
						<ul class="categories right">
							<li><a href="#">All recipes</a></li>
							<li class="active"><a href="#">Tips and Tricks</a></li>
							<li><a href="#">Events</a></li>
							<li><a href="#">Inspiration</a></li>
							<li><a href="#">Category name</a></li>
							<li><a href="#">Lorem ipsum</a></li>
							<li><a href="#">Dolor</a></li>
							<li><a href="#">Sit amet</a></li>
						</ul>
					</div>
					<div class="widget">
						<h3>Advertisment</h3>
						<a href="#"><img src="images/advertisment.jpg" alt="" /></a>
					</div>
				</aside>
				<!--//right sidebar-->
			</div>
			<!--//row-->
		</div>
		<!--//wrap-->
	</main>
	<!--//main-->
	
	
	<!--footer--><!--preloader-->
		<jsp:include page="common/commonFooter.jsp" />
	<!--//footer--><!--//preloader-->
		
		<jsp:include page="common/commonJsFooter.jsp" />
	<script>new WOW().init();</script>
</body>
</html>


