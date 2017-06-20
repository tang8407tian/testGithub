<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<li>搜索食谱</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title wow fadeInLeft">
					<h1>搜索食谱</h1>
				</header>
				
				<!--content-->
				<section class="content full-width wow fadeInUp">
					<!--recipefinder-->
					<div class="container recipefinder">
						
						<div class="right">
							
							
							<h3>请输入搜索内容：</h3>
						<form action="${pageContext.request.contextPath }/findBy/indexSearch">
							<div class="row">
								<div class="search one-half">
									<input type="search" name="names" placeholder="按名称查找食谱" />
									<input type="submit" value="搜索" />
								</div>
								
								
							</div>
						</form>
							
						</div>
					</div>
					<!--//recipefinder-->
				
					
				</section>
				<!--//content-->
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


