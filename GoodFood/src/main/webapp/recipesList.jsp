<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- //引入标签 -->	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!-- //引入标签 -->
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
					<li>食谱2</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title wow fadeInLeft">
					<h1>每周食谱</h1>
				</header>
				
				<aside class="above-sidebar full-width  wow fadeInDown">
					<ul class="boxed">
						<li class="light"><a href="recipes.html" title="Appetizers"><i class="ico i-appetizers"></i> <span>开胃品</span></a></li>
						<li class="medium"><a href="recipes.html" title="Cocktails"><i class="ico i-cocktails"></i> <span>鸡尾酒</span></a></li>
						<li class="dark"><a href="recipes.html" title="Deserts"><i class="ico i-deserts"></i> <span>甜点</span></a></li>
						
						<li class="light"><a href="recipes.html" title="Cocktails"><i class="ico i-eggs"></i> <span>鸡蛋</span></a></li>
						<li class="medium"><a href="recipes.html" title="Equipment"><i class="ico i-equipment"></i> <span>素材</span></a></li>
						<li class="dark"><a href="recipes.html" title="Events"><i class="ico i-events"></i> <span>项目</span></a></li>
					
						<li class="light"><a href="recipes.html" title="Fish"><i class="ico i-fish"></i> <span>鱼</span></a></li>
						<li class="medium"><a href="recipes.html" title="Ftness"><i class="ico i-fitness"></i> <span>健身的</span></a></li>
						<li class="dark"><a href="recipes.html" title="Healthy"><i class="ico i-healthy"></i> <span>健康的</span></a></li>
						
						<li class="medium"><a href="recipes.html" title="Asian"><i class="ico i-asian"></i> <span>亚洲的</span></a></li>
						<li class="dark"><a href="recipes.html" title="Mexican"><i class="ico i-mexican"></i> <span>墨西哥的</span></a></li>
						<li class="light"><a href="recipes.html" title="Pizza"><i class="ico i-pizza"></i> <span>披萨</span></a></li>
						
						<li class="medium"><a href="recipes.html" title="Kids"><i class="ico i-kids"></i> <span>儿童的</span></a></li>
						<li class="dark"><a href="recipes.html" title="Meat"><i class="ico i-meat"></i> <span>肉类</span></a></li>
						<li class="light"><a href="recipes.html" title="Snacks"><i class="ico i-snacks"></i> <span>快餐类</span></a></li>
						
						<li class="medium"><a href="recipes.html" title="Salads"><i class="ico i-salads"></i> <span>沙拉类</span></a></li>
						<li class="dark"><a href="recipes.html" title="Storage"><i class="ico i-storage"></i> <span>可保存类</span></a></li>
						<li class="light"><a href="recipes.html" title="Vegetarian"><i class="ico i-vegetarian"></i> <span>素食类</span></a></li>
					</ul>
				</aside>
				
				<!--content-->
				<section class="content full-width wow fadeInUp">
					<!--entries-->
					<div class="entries row">
					
					<c:forEach items="${allPageList }" var="allList">
					
					<!--item-->
						<div class="entry one-fourth wow fadeInLeft">
							<figure>
								<img src="<%=request.getContextPath() %>${allList.imgfilepath}"  style=" width:300px;height:200px;" alt="" />
								<figcaption><a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${allList.foodname}"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
							</figure>
							<div class="container">
								<h2><a href="recipe.html">${allList.foodname}</a></h2> 
								<div class="actions">
									<div>
										<div class="difficulty"><i class="ico i-medium"></i><a href="#">${allList.thedefficulty}</a></div>
										<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
										<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.html#comments">27</a></div>
									</div>
								</div>
							</div>
						</div>
						<!--item-->
					</c:forEach>
					
			<!-- 分页 -->					
						<div class="quicklinks">
						<!-- 首页 -->
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findAllRecipe?page=1" class="button">首页</a>
						<!-- 上一页 -->
							<c:if test="${isFirst == false}">
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findAllRecipe?page=${pages-1} " class="button">上一页</a>|
							</c:if>
						<!-- 2/5页 -->
							<span>  ${pages}/${totalPage} 页|</span>
						<!-- 下一页 -->	
							<c:if test="${isLast == false}">
								<a href="${pageContext.request.contextPath}/recipeAllMessage/findAllRecipe?page=${pages+1}" class="button">下一页</a>
							</c:if>	
						<!-- 尾页 -->
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findAllRecipe?page=${totalPage}" class="button">尾页</a>
						<!-- 返回首部	 -->
							<a href="javascript:void(0)" class="button scroll-to-top">返回首部</a>
						</div>
			<!--// 分页 -->		
		
						
						
						
					</div>
					<!--//entries-->
				</section>
				<!--//content-->
			</div>
			<!--//row-->
		</div>
		<!--//wrap-->
	</main>
	<!--//main-->

	<!--footer--> <!--preloader-->
		<jsp:include page="common/commonFooter.jsp" />
	
	<!--//footer--><!--//preloader-->
	
	
	<jsp:include page="common/commonJsFooter.jsp" />
	<script>new WOW().init();</script>
</body>
</html>


