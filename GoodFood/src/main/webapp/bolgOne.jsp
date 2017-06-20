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
					<li><a href="#" title="Blog">博客</a></li>
					<li>帖子</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title wow fadeInLeft">
					<h1>${blogMessage.bolgname }</h1>
				</header>
	
				<!--content-->
				<section class="content three-fourth wow fadeInLeft">
					<!--blog entry-->
					<article class="post single">
						<div class="entry-meta">
							<div class="date">
								<span class="day">${blogMessage.createtimeday }</span> 
								<span class="my">${blogMessage.createtimeyear }年${blogMessage.createtimemouth }月</span>
							</div>
							<div class="avatar">
								<a href="my_profile.html"><img src="<%=request.getContextPath() %>${blogMessage.customerImg }" alt="" /><span>${blogMessage.customername }</span></a>
							</div>
						</div>
						<div class="container">
							<div class="entry-featured"><a href="#"><img src="<%=request.getContextPath() %>${blogMessage.headimg }" alt="" /></a></div>
							<div class="entry-content">
								<p class="lead"> ${blogMessage.bolgname }</p>
								<p>${blogMessage.blog }</p>
			
							</div>
						</div>
					</article>
					<!--//blog entry-->
					
					<!--comments-->
					<div class="comments wow fadeInUp" id="comments">
						<h2>评论: </h2>
						<ol class="comment-list">
						
						
						<!-- 循环显示留言信息	 -->		
						<c:forEach items="${commentBlogMessage }" var="blogComment" >
					<!-- 一级留言 -->
							<!--comment-->
								<li class="comment depth-1">
								<!-- 头像 -->
								
							<c:if test="${!empty blogComment.customerimg }">
								<div class="avatar"><a href="my_profile.html"><img src="<%=request.getContextPath() %>${blogComment.customerimg}" alt="" /></a></div>
							
							</c:if>
							
							<c:if test="${empty blogComment.customerimg }">
								<div class="avatar"><a href="#"><img src="<%=request.getContextPath() %>/images/moren.jpg" alt="" /></a></div>
							
							</c:if>
								
								
								
									<div class="comment-box">
										<div class="comment-author meta"> 
										<!-- 用户名+时间 -->
											<strong>${blogComment.customername }</strong>${ blogComment.createTime} <a href="#respond" class="comment-reply-link"> 回复</a>
										</div>
										<div class="comment-text">
											<p>${blogComment.comment }</p>
										</div>
									</div> 
								</li>
							<!--//comment-->
					<!-- //一级留言 -->

						</c:forEach>
						
				<!-- //循环显示留言信息	 -->		
							
						</ol>
					</div>
					<!--//comments-->
					
					<!--respond-->
						<div class="comment-respond wow fadeInUp" id="respond">
							<h2>发表评论</h2>
							<div class="container">
								<p>
								<strong>注意:</strong>
								网站上的评论反映了作者的观点，而不一定是网络社区网站的观点。 要求避免侮辱，亵渎和粗俗的表达。 我们保留删除任何评论的权利，恕不另行通知。
								</p>
								
								<form action="${pageContext.request.contextPath }/comment/saveBlog"  method="post">

									<div class="f-row">
							<!-- 评论内容 -->
										<textarea name="comment"></textarea>
										
										<input type="hidden" name="articlename" value="${blogMessage.bolgname }">
									</div>
									
									<div class="f-row">								
										
										<div class="third bwrap">
											<input type="submit" value="提交" />
										</div>
									</div>
															
								</form>
							</div>
						</div>
						<!--//respond-->
				</section>
				<!--//content-->
			
				<!--right sidebar-->
				<aside class="sidebar one-fourth wow fadeInRight">
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
	
	
	<!--footer-->
		<jsp:include page="common/commonFooter.jsp" />
	<!--//footer-->
	
	<!--preloader-->
	
	<!--//preloader-->
	
	<jsp:include page="common/commonJsFooter.jsp" />
	<script>new WOW().init();</script>
</body>
</html>


