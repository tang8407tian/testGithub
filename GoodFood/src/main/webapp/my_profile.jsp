<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!-- //引入标签 -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<jsp:include page="common/commonHead.jsp" />
</head>
<body>
	<!--header-->
		<jsp:include page="common/commonHeader.jsp" />
	<!--//header-->
		
	<!--main-->
	<main class="main" role="main">
		<!--wrap-->
		<div class="wrap clearfix">
			<!--breadcrumbs-->
			<nav class="breadcrumbs">
				<ul>
					<li><a href="index.html" title="Home">首页</a></li>
					<li>我的账号</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
		
			<!--content-->
			<section class="content">
				<!--row-->
				<div class="row">
					<!--profile left part-->
					<div class="my_account one-fourth wow fadeInLeft">
					
						<figure>
						
							<c:if test="${!empty myInfo.headimg }">
								<img src="<%=request.getContextPath() %>${myInfo.headimg}" style=" width:268px;height:271px;" alt="" />
							
							</c:if>
							<c:if test="${empty myInfo.headimg }">
								<img src="<%=request.getContextPath() %>/images/moren.jpg" alt="" />
							
							</c:if>
								
						</figure>
						<div class="container">
							<h2>${myInfo.nickname}</h2> 
						</div>
					</div>
					<!--//profile left part-->
					
					<div class="three-fourth wow fadeInRight">
						<nav class="tabs">
							<ul>
								<li class="active"><a href="#about" title="About me">我的信息</a></li>
								<!--对应下面的我的食谱-->
								<li><a href="#recipes" title="My recipes">我的食谱</a></li>
								<li><a href="#favorites" title="My favorites">我的偏爱</a></li>
								<li><a href="#posts" title="My posts">我的帖子</a></li>
							</ul>
						</nav>
						
						<!--about-->
						<div class="tab-content" id="about">
							<div class="row">
								<dl class="basic two-third">
									<dt>名字</dt>
									<dd>${myInfo.nickname}</dd>
									<dt>最喜欢的食谱</dt>
									<dd>${myInfo.likerecipe}</dd>
									<dt>最喜欢的厨具</dt>
									<dd>${myInfo.likekitchenware}</dd>
									<dt>最喜欢的调味料</dt>
									<dd>${myInfo.likeseasoning}</dd>
									<!-- <dt>提交的食谱</dt>
									<dd>9</dd>
									<dt>发布的帖子</dt>
									<dd>9</dd> -->
									
								</dl>
								
								<div class="one-third">
									<ul class="boxed gold">
										<li class="dark"><a href="${pageContext.request.contextPath }/submit_Blog.jsp" title="Events"><i class="ico i-wrote_blog_post"></i> <span>编辑博文</span></a></li>
										<li class="dark"><a href="${pageContext.request.contextPath }/submit_recipe.jsp" title="Added a first recipe"><i class="ico i-added_first_recipe"></i> <span>编辑食谱</span></a></li>
										<li class="medium"><a href="${pageContext.request.contextPath }/meInfoToAdd.jsp" title="Was featured"><i class="ico i-was_featured"></i> <span>编辑个人信息</span></a></li>
										<li class="light"><a href="${pageContext.request.contextPath }/customer/update1?id=${myInfo.id}" title="Fish"><i class="ico i-wrote_comment"></i> <span>修改个人信息</span></a></li>
									
									
									
										<%-- <li class="light"><a href="${pageContext.request.contextPath }/customer/modifypassword1?id=${myInfo.id}" title="Best recipe"><i class="ico i-had_best_recipe"></i> <span>修改密码</span></a></li> --%>
										
										
									</ul>
								</div>
							</div>
						</div>
						<!--//about-->
					
						<!--my recipes-->
						<!--对应上面的我的食谱-->
						<div class="tab-content" id="recipes">
							<div class="entries row">
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img6.jpg" alt="" />
										<figcaption><a href="recipe.html"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.html">泰国炒饭用水果和蔬菜</a></h2> 
										<div class="actions">
											<div>
												<div class="difficulty"><i class="ico i-medium"></i><a href="#">一般</a></div>
												<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
											</div>
										</div>
									</div>
								</div>
								<!--item-->
								
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img5.jpg" alt="" />
										<figcaption><a href="recipe.html"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.html">辣椒摩洛哥虾与樱桃番茄</a></h2> 
										<div class="actions">
											<div>
												<div class="difficulty"><i class="ico i-hard"></i><a href="#">困难</a></div>
												<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
											</div>
										</div>
									</div>
								</div>
								<!--item-->
								
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img8.jpg" alt="" />
										<figcaption><a href="recipe.html"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.html">超级容易的蓝莓芝士蛋糕</a></h2> 
										<div class="actions">
											<div>
												<div class="difficulty"><i class="ico i-easy"></i><a href="#">容易</a></div>
												<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
											</div>
										</div>
									</div>
								</div>
								<!--item-->
							</div>
						</div>
						<!--//my recipes-->
						
						
						<!--my favorites-->
						<div class="tab-content" id="favorites">
							<div class="entries row">
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img6.jpg" alt="" />
										<figcaption><a href="recipe.html"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.html">泰国炒饭用水果和蔬菜</a></h2> 
										<div class="actions">
											<div>
												<div class="difficulty"><i class="ico i-medium"></i><a href="#">一般</a></div>
												<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
											</div>
										</div>
									</div>
								</div>
								<!--item-->
								
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img5.jpg" alt="" />
										<figcaption><a href="recipe.html"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.html">辣椒摩洛哥虾与樱桃番茄</a></h2> 
										<div class="actions">
											<div>
												<div class="difficulty"><i class="ico i-hard"></i><a href="#">困难</a></div>
												<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
											</div>
										</div>
									</div>
								</div>
								<!--item-->
								
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img8.jpg" alt="" />
										<figcaption><a href="recipe.html"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.html">超级容易的蓝莓芝士蛋糕</a></h2> 
										<div class="actions">
											<div>
												<div class="difficulty"><i class="ico i-easy"></i><a href="#">容易</a></div>
												<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
											</div>
										</div>
									</div>
								</div>
								<!--item-->
							</div>
						</div>
						<!--//my favorites-->
						
						<!--my posts-->
						<div class="tab-content" id="posts">
							<!--entries-->
							<div class="entries row">
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img12.jpg" alt="" />
										<figcaption><a href="blog_single.html"><i class="ico i-view"></i> <span>查看帖子</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="blog_single.html">烧烤派对</a></h2> 
										<div class="actions">
											<div>
												<div class="date"><i class="ico i-date"></i><a href="#">2015-12-12</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/blog_single.html#comments">27</a></div>
											</div>
										</div>
										<div class="excerpt">
											<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod. Lorem ipsum dolor sit amet . . . </p>
										</div>
									</div>
								</div>
								<!--item-->
								
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img11.jpg" alt="" />
										<figcaption><a href="blog_single.html"><i class="ico i-view"></i> <span>查看帖子</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="blog_single.html">如何做寿司</a></h2> 
										<div class="actions">
											<div>
												<div class="date"><i class="ico i-date"></i><a href="#">2017-11-12</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/blog_single.html#comments">27</a></div>
											</div>
										</div>
										<div class="excerpt">
											<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod. Lorem ipsum dolor sit amet . . . </p>
										</div>
									</div>
								</div>
								<!--item-->
								
								<!--item-->
								<div class="entry one-third">
									<figure>
										<img src="images/img10.jpg" alt="" />
										<figcaption><a href="blog_single.html"><i class="ico i-view"></i> <span>查看帖子</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="blog_single.html">做自己的面包</a></h2> 
										<div class="actions">
											<div>
												<div class="date"><i class="ico i-date"></i><a href="#">2014-11-08</a></div>
												<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/blog_single.html#comments">27</a></div>
											</div>
										</div>
										<div class="excerpt">
											<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod. Lorem ipsum dolor sit amet . . . </p>
										</div>
									</div>
								</div>
								<!--item-->
							</div>
							<!--//entries-->
						</div>
						<!--//my posts-->
					</div>
				</div>
				<!--//row-->
			</section>
			<!--//content-->
		</div>
		<!--//wrap-->
	</main>
	<!--//main-->
	
	
	<!--footer-->
		<jsp:include page="common/commonFooter.jsp" />
	<!--//footer-->
	
	<!--preloader-->
	
	<!--//preloader-->
	
	<jsp:include page="common/commonJsFooter.jsp" />
	<script>new WOW().init();</script>
</body>
</html>


