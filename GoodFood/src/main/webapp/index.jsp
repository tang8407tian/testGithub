<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
<!-- //引入标签 -->	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!-- //引入标签 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
	<jsp:include page="common/commonHead.jsp" />
</head>
<body class="home">
 


	<%-- <jsp:include page="common.jsp" /> --%>
	<!--header-->
	
	<jsp:include page="common/commonHeader.jsp" />
	
	<!--//header-->
		
	<!--main-->
	<main class="main" role="main">
		<!--intro-->
		<div class="intro">
			<figure class="bg"><img src="<%=request.getContextPath() %>/images/intro.jpg" alt="" /></figure>
			
			<!--wrap-->
			<div class="wrap clearfix">
				<!--row-->
				<div class="row">
					<article class="three-fourth text wow zoomIn" data-wow-delay=".2s">
						<h1>欢迎来到召唤师峡谷</h1>
						<p>敌军还有30秒到达战场 <strong>碾碎他们   狗狗狗！！！！</p>
						<p>在这里你可以赢得很棒的奖品，结交新朋友，分享美味的食谱。 </p>
						<a href="${pageContext.request.contextPath }/register.jsp" class="button white more medium">加入我们</a>
						<p>已经是会员了? 单击 <a href="${pageContext.request.contextPath }/login.jsp"  style="color:red">这 儿</a> 登录.</p>
					</article>
					
					<!--search recipes widget-->
					<div class="one-fourth wow fadeInDown" data-wow-delay=".5s">
						<div class="widget container">
							<div class="textwrap">
								<h3>搜索食谱</h3>
								<p>您需要做的就是输入一个成分，一个菜或关键字。</p>
								<p>您还可以从下拉列表中选择特定类别。</p>
								<p>一定有一些诱人的尝试。</p> 
								<p>喜爱</p>
							</div>
							<form action="${pageContext.request.contextPath }/findBy/indexSearch">
								<div class="f-row">
									<input type="text" placeholder="输入您的搜索字词" name="names" />
								</div>
								<!-- <div class="f-row">
									<select>
										<option>或选择一个类别</option>
										<option>川菜</option>
										<option>粤菜</option>
										<option>东北菜</option>
										<option>徽菜</option>
										<option>四川菜</option>
										<option>汤类</option>
									</select>
								</div> -->
								<div class="f-row bwrap">
									<input type="submit" value="搜索!" />
								</div>
							</form>
						</div>
					</div>
					<!--//search recipes widget-->
				</div>
				<!--//row-->
			</div>
			<!--//wrap-->
		</div>
		<!--//intro-->
		

<!--轮换图开始-->
<div style="margin-top:50px" class="htmleaf-container">
	<h2 class="ribbon bright">精品推荐</h2>
		<div class="main_banner">
			<div class="main_banner_wrap">
				<div class="main_banner_box" id="m_box">
					<a href="javascript:void(0)" class="banner_btn js_pre">
						<span class="banner_btn_arrow"><i></i></span>
					</a>
					<a href="javascript:void(0)" class="banner_btn btn_next js_next">
						<span class="banner_btn_arrow"><i></i></span>
					</a>
					<ul>
						<li id="imgCard0">
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${lunhuan1.foodname}"><span style="opacity:0;"></span></a>      
							<img src="<%=request.getContextPath() %>${lunhuan1.imgfilepath }" alt="">
							<p style="bottom:0">${lunhuan1.foodname }</p>
						</li> 
						<li id="imgCard1">
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${lunhuan2.foodname}"><span style="opacity:0.4;"></span></a>      
							<img src="<%=request.getContextPath() %>${lunhuan2.imgfilepath }" alt="">
							<p>${lunhuan2.foodname }</p>
						</li> 
						<li id="imgCard2">
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${lunhuan3.foodname}"><span style="opacity:0.4;" ></span></a>        
							<img src="<%=request.getContextPath() %>${lunhuan3.imgfilepath }" alt="">
							<p>${lunhuan3.foodname }</p>
						</li> 
						<li id="imgCard3">
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${lunhuan4.foodname}"><span style="opacity:0.4;"></span></a>      
							<img src="<%=request.getContextPath() %>${lunhuan5.imgfilepath }" alt="">
							<p>${lunhuan4.foodname }</p>
						</li> 
						<li id="imgCard4">
							<a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${lunhuan5.foodname}"><span style="opacity:0.4;"></span></a>      
							<img src="<%=request.getContextPath() %>${lunhuan5.imgfilepath }" alt="">
							<p>${lunhuan5.foodname }</p>
						</li> 
					</ul>
					<!--火狐倒影图层-->
					<p id="rflt"></p>
					<!--火狐倒影图层-->
				</div>
				<!--序列号按钮-->
				<div class="btn_list">
					<span class="curr"></span><span></span><span></span><span></span><span></span>        
				</div>
			</div>
		</div>
		
	</div>
	<!-- 轮换图动态效果显示-->
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/main.js"></script>
		
<!--轮换图结束-->

		<!--wrap-->
		<div style="margin-top:30px" class="wrap clearfix">
			<!--row-->
			<div class="row">
				<!--content-->
				<section class="content full-width">
					<div class="icons dynamic-numbers">
						<header class="s-title wow fadeInDown">
							<h2 class="ribbon large">美食网站的一些数据</h2>
						</header>
						
						<!--row-->
						<div class="row wow fadeInUp">
							<!--item-->
							<div class="one-sixth">
								<div class="container">
									<i class="ico i-members"></i>
									<span class="title dynamic-number" data-dnumber="${allCustomer }">0</span>
									<span class="subtitle">成员</span>
								</div>
							</div>
							<!--//item-->
							
							<!--item-->
							<div class="one-sixth">
								<div class="container">
									<i class="ico i-recipes"></i>
									<span class="title dynamic-number" data-dnumber="${allRecipe }">0</span>
									<span class="subtitle">食谱</span>
								</div>
							</div>
							<!--//item-->
							
							
							
							<!--item-->
						
							
							<!--item-->
							<div class="one-sixth">
								<div class="container">
									<i class="ico i-comment"></i>
									<span class="title dynamic-number" data-dnumber="${allComment }">0</span>
									<span class="subtitle">评论</span>
								</div>
							</div>
							<!--//item-->
							
							<!--item-->
							<div class="one-sixth">
								<div class="container">
									<i class="ico i-articles"></i>
									<span class="title dynamic-number" data-dnumber="${allBlog }">0</span>
									<span class="subtitle">文章</span>
								</div>
							</div>
							<!--//item-->
							
							<!--item-->
							<div class="one-sixth">
								<div class="container">
									<i class="ico i-photos"></i>
									<span class="title dynamic-number" data-dnumber="5300">0</span>
									<span class="subtitle">照片</span>
								</div>
							</div>
							<!--//item-->
							
							<!--item-->
							<div class="one-sixth">
								<div class="container">
									<i class="ico i-posts"></i>
									<span class="title dynamic-number" data-dnumber="2300">0</span>
									<span class="subtitle">帖子</span>
								</div>
							</div>
							<!--//item-->
						
							<div class="cta">
								<a href="login.jsp" class="button big">加入我们!</a>
							</div>
						</div>
						<!--//row-->
					</div>
				</section>
				<!--//content-->
			



				<!--content-->
				<section class="content three-fourth">
					<!--cwrap-->
					<div class="cwrap">
						<!--entries-->
						<div class="entries row">
							<!--featured recipe-->
							<div class="featured two-third wow fadeInLeft">
								<header class="s-title">
									<h2 class="ribbon">每一天的食谱</h2>
								</header>
								<article class="entry">
									<figure>
										<img src="<%=request.getContextPath() %>${rcipeOne.imgfilepath }" style=" width:569px;height:426px;" alt="" />
										<figcaption><a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${rcipeOne.foodname}"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="recipe.jsp">${rcipeOne.foodname }</a></h2>
										<p>${rcipeOne.introduce } </p>
										<div class="actions">
											<div>
												<a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${rcipeOne.foodname}" class="button">查看完整的食谱</a>
												
											</div>
										</div>
									</div>
								</article>
							</div>
							<!--//featured recipe-->
							
							<!--featured member-->
							<div class="featured one-third wow fadeInLeft" data-wow-delay=".2s">
								<header class="s-title">
									<h2 class="ribbon star">特邀会员</h2>
								</header>
								<article class="entry">
									<figure>
										<img src="images/avatar1.jpg" alt="" />
										<figcaption><a href="my_profile.html"><i class="ico i-view"></i> <span>查看会员</span></a></figcaption>
									</figure>
									<div class="container">
										<h2><a href="my_profile.html">奥利安娜</a></h2>
										<blockquote>传统的菜肴和精美的烘焙产品的美丽的照片来绕过吸引试用陪同！乱数假文悲哀坐特，您adipiscing精英。</blockquote>
										<div class="actions">
											<div>
												<a href="#" class="button">看看她的食谱</a>
												<div class="more"><a href="#">已经看过的特色成员</a></div>
											</div>
										</div>
									</div>
								</article>
							</div>
							<!--//featured member-->
						</div>
						<!--//entries-->
					</div>
					<!--//cwrap-->
				
					<!--cwrap-->
					<div class="cwrap">
						<header class="s-title">
							<h2 class="ribbon bright">随机食谱</h2>
						</header>
						
						<!--entries-->
						<div class="entries row">	
				<!-- 循环 -->		
				<!--item-->	
						<c:forEach items="${recipeFindByRand}" var="rand"  >
							<div class="entry one-third wow fadeInLeft" data-wow-delay="1s">
								<figure>
									<img src="<%=request.getContextPath() %>${rand.imgfilepath}" style=" width:270px;height:203px;" alt=""  />
									<figcaption><a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${rand.foodname}"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
								</figure>
								<div class="container">
									<h2><a href="recipe.jsp">${rand.foodname}</a></h2> 
									<div class="actions">
										<div>
											<div class="difficulty"><i class="ico i-medium"></i><a href="#">${rand.thedefficulty}</a></div>
											<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
											<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.jsp#comments">27</a></div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
				<!--item-->
			<!--// 循环 -->					
							<div class="quicklinks">
								<a href="${pageContext.request.contextPath}/recipeAllMessage/findAllRecipe" class="button">更多食谱</a>
								<a href="javascript:void(0)" class="button scroll-to-top">返回顶部</a>
							</div>
			
						</div>
						<!--//entries-->
					</div>
				<!--//cwrap-->
				
				
				
					
				<!--cwrap-->
					<div class="cwrap">
						<header class="s-title">
							<h2 class="ribbon bright">最新食谱</h2>
						</header>
						<!--entries-->
						<div class="entries row">	
				<!-- 循环 -->		
				<!--item-->	
						<c:forEach items="${rcipeList}" var="recipe"  >
							<div class="entry one-third wow fadeInLeft" data-wow-delay="1s">
								<figure>
									<img src="<%=request.getContextPath() %>${recipe.imgfilepath}" style=" width:270px;height:203px;" alt=""  />
									<figcaption><a href="${pageContext.request.contextPath}/recipeAllMessage/findRecipeByName?name=${recipe.foodname}"><i class="ico i-view"></i> <span>查看食谱</span></a></figcaption>
								</figure>
								<div class="container">
									<h2><a href="recipe.jsp">${recipe.foodname}</a></h2> 
									<div class="actions">
										<div>
											<div class="difficulty"><i class="ico i-medium"></i><a href="#">${recipe.thedefficulty}</a></div>
											<div class="likes"><i class="ico i-likes"></i><a href="#">10</a></div>
											<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/recipe.jsp#comments">27</a></div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
				<!--item-->
			<!--// 循环 -->					
							<div class="quicklinks">
								<a href="${pageContext.request.contextPath}/recipeAllMessage/findAllRecipe" class="button">更多食谱</a>
								<a href="javascript:void(0)" class="button scroll-to-top">返回顶部</a>
						</div>
			
						</div>
						<!--//entries-->
					</div>
					<!--//cwrap-->
					
				
					<!--cwrap-->
					<div class="cwrap">
						<h2 class="ribbon bright">最新的文章</h2>
						<!--entries-->
						<div class="entries row">
						
						<c:forEach items="${bolgList }" var="bolgListByNumber">
						<!--item-->
							<div class="entry one-third wow fadeInLeft">
								<figure>
									<img src="<%=request.getContextPath() %>${bolgListByNumber.headimg }" alt="" />
									<figcaption><a href="${pageContext.request.contextPath }/blog/findByid?id=${bolgListByNumber.id }"><i class="ico i-view"></i> <span>查看贴子</span></a></figcaption>
								</figure>
								<div class="container">
									<h2><a href="blog_single.html">${bolgListByNumber.bolgname}</a></h2> 
									<div class="actions">
										<div>
											<div class="date"><i class="ico i-date"></i><a href="#">${bolgListByNumber.createtimeyear }年 ${bolgListByNumber.createtimemouth }月 ${bolgListByNumber.createtimeday }日</a></div>
											<div class="comments"><i class="ico i-comments"></i><a href="http://www.themeenergy.com/themes/html/social-chef/blog_single.html#comments">27</a></div>
										</div>
									</div>
									<div class="excerpt">
										<p>${bolgListByNumber.summary } </p>
									</div>
								</div>
							</div>
							<!--item-->
	
						</c:forEach>
							
							
							<div class="quicklinks">
								<a href="${pageContext.request.contextPath }/blog/list" class="button">更多的帖子</a>
								<a href="javascript:void(0)" class="button scroll-to-top">返回顶部</a>
							</div>
						</div>
						<!--//entries-->
					</div>
					<!--//cwrap-->
				</section>
				<!--//content-->
		
			
				<!--right sidebar-->
				<aside class="sidebar one-fourth">
					<div class="widget wow fadeInRight">
						<h3>食谱类别</h3>
						<ul class="boxed">
							<li class="light"><a href="recipes.html" title="Appetizers"><i class="ico i-appetizers"></i> <span>甜品</span></a></li>
							<li class="medium"><a href="recipes.html" title="Cocktails"><i class="ico i-cocktails"></i> <span>鸡尾酒</span></a></li>
							<li class="dark"><a href="recipes.html" title="Deserts"><i class="ico i-deserts"></i> <span>Deserts</span></a></li>
							
							<li class="medium"><a href="recipes.html" title="Cocktails"><i class="ico i-eggs"></i> <span>鸡蛋</span></a></li>
							<li class="dark"><a href="recipes.html" title="Equipment"><i class="ico i-equipment"></i> <span>器材</span></a></li>
							<li class="light"><a href="recipes.html" title="Events"><i class="ico i-events"></i> <span>事件</span></a></li>
						
							<li class="dark"><a href="recipes.html" title="Fish"><i class="ico i-fish"></i> <span>鱼</span></a></li>
							<li class="light"><a href="recipes.html" title="Ftness"><i class="ico i-fitness"></i> <span>平衡的</span></a></li>
							<li class="medium"><a href="recipes.html" title="Healthy"><i class="ico i-healthy"></i> <span>健康的</span></a></li>
							
							<li class="light"><a href="recipes.html" title="Asian"><i class="ico i-asian"></i> <span>亚洲的</span></a></li>
							<li class="medium"><a href="recipes.html" title="Mexican"><i class="ico i-mexican"></i> <span>墨西哥的</span></a></li>
							<li class="dark"><a href="recipes.html" title="Pizza"><i class="ico i-pizza"></i> <span>披萨</span></a></li>
							
							<li class="medium"><a href="recipes.html" title="Kids"><i class="ico i-kids"></i> <span>儿童类的</span></a></li>
							<li class="dark"><a href="recipes.html" title="Meat"><i class="ico i-meat"></i> <span>肉类</span></a></li>
							<li class="light"><a href="recipes.html" title="Snacks"><i class="ico i-snacks"></i> <span>快餐类</span></a></li>
							
							<li class="dark"><a href="recipes.html" title="Salads"><i class="ico i-salads"></i> <span>萨拉类</span></a></li>
							<li class="light"><a href="recipes.html" title="Storage"><i class="ico i-storage"></i> <span>可存储类</span></a></li>
							<li class="medium"><a href="recipes.html" title="Vegetarian"><i class="ico i-vegetarian"></i> <span>素食类</span></a></li>
						</ul>
					</div>
						
					<div class="widget wow fadeInRight" data-wow-delay=".2s">
						<h3>提示和技巧</h3>
						<ul class="articles_latest">
							<li>
								<a href="blog_single.html">
									<img src="images/img9.jpg" alt="" />
									<h6>如何装饰饼干</h6>
								</a>
							</li>
							<li>
								<a href="blog_single.html">
									<img src="images/img10.jpg" alt="" />
									<h6>做自己的面包</h6>
								</a>
							</li>
							<li>
								<a href="blog_single.html">
									<img src="images/img11.jpg" alt="" />
									<h6>如何做寿司</h6>
								</a>
							</li>
							<li>
								<a href="blog_single.html">
									<img src="images/img12.jpg" alt="" />
									<h6>烧烤派对</h6>
								</a>
							</li>
							<li>
								<a href="blog_single.html">
									<img src="images/img8.jpg" alt="" />
									<h6>如何做芝士蛋糕</h6>
								</a>
							</li>
						</ul>
					</div>
						
					<div class="widget members wow fadeInRight" data-wow-delay=".4s">
						<h3>我们的会员</h3>
						<div id="members-list-options" class="item-options">
						  <a href="#">最新</a>
						  <a class="selected" href="#">活跃的</a>
						  <a href="#">受欢迎的</a>
						</div>
						<ul class="boxed">
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar1.jpg" alt="" /><span>奥利安拉</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar2.jpg" alt="" /><span>阿卡丽</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar3.jpg" alt="" /><span>菲欧拉</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar9.jpg" alt="" /><span>狄安娜</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar8.jpg" alt="" /><span>索菲亚</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar4.jpg" alt="" /><span>小菊</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar7.jpg" alt="" /><span>小花</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar5.jpg" alt="" /><span>安娜</span></a></div></li>
							<li><div class="avatar"><a href="my_profile.html"><img src="images/avatar6.jpg" alt="" /><span>苏菲</span></a></div></li>
						</ul>
					</div>
						
					<div class="widget wow fadeInRight" data-wow-delay=".6s">
						<h3>广告</h3>
						<a href="#"><img src="images/advertisment.jpg" alt="" /></a>
					</div>
				</aside>
			</div>
			<!--//right sidebar-->
		</div>
		<!--//wrap-->
	</main>
	<!--//main-->
	
	<!--call to action-->
	<section class="cta">
		<div class="wrap clearfix">
			<a href="login.html" class="button big white right">购买主题</a>
			<h2>已经说服了? 这是一个呼唤行动部分乱数假文悲哀坐特。</h2>
		</div>
	</section>
	<!--//call to action-->
	
	<!--footer--><!--preloader-->
			<jsp:include page="common/commonFooter.jsp" />
	<!--//footer--><!--//preloader-->
	
	<jsp:include page="common/commonJsFooter.jsp" />
	<script>
		window.dynamicNumbersBound = false;
		var wow = new WOW();
		WOW.prototype.show = function(box) {
			wow.applyStyle(box);
			if (typeof box.parentNode !== 'undefined' && hasClass(box.parentNode, 'dynamic-numbers') && !window.dynamicNumbersBound) {
				bindDynamicNumbers();
				window.dynamicNumbersBound = true;
			}
			return box.className = "" + box.className + " " + wow.config.animateClass;
		};
		wow.init();
		
		function hasClass(element, cls) {
			return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;
		}
		
		function bindDynamicNumbers() {
			$('.dynamic-number').each(function() {				
				var startNumber = $(this).text();
				var endNumber = $(this).data('dnumber');
				var dynamicNumberControl = $(this);
				
				$({numberValue: startNumber}).animate({numberValue: endNumber}, {
					duration: 4000,
					easing: 'swing',
					step: function() { 
						$(dynamicNumberControl).text(Math.ceil(this.numberValue)); 
					}
				});
			});	
		}
		
	</script>
</body>
</html>


