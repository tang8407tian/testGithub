<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!-- //引入标签 -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="common/commonHead.jsp" />
</head>
<body class="recipePage">
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
					<li><a href="#" title="Recipes">食谱</a></li>
					<li><a href="recipes.html" title="Cocktails">Deserts</a></li>
					<li>食谱步骤</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title wow fadeInLeft">
					<!-- <h1>豪华的黑色&amp;白色巧克力蛋糕</h1> -->
					<h1>${recipeBasicMessage.foodname }</h1>
				</header>
				<!--content-->
				<section class="content three-fourth">
					<div class="row">
					<!--recipe-->
						<div class="recipe">
							<!--two-third-->
							<article class="two-third wow fadeInLeft">
								<div class="image"><a href="#"><img src="<%=request.getContextPath() %>${recipeBasicMessage.imgfilepath }" alt="" /></a></div>
								<div class="intro"><p><strong>${recipeBasicMessage.foodname }</strong></p> 
								<p>
									${recipeBasicMessage.introduce }								
								</p></div>
								<div class="instructions">
									<ol>
									<c:forEach items="${recipeStepMessage }" var="step">
										<li>
										${step.foodstep }
										</li>
									</c:forEach>
									</ol>
								</div>
							</article>
							<!--//two-third-->
							
							<!--one-third-->
							<article class="one-third wow fadeInDown">
								<dl class="basic">
								
								
									<dt>准备时间</dt>
									<dd style="background-color: blue">${recipeBasicMessage.preparationtime }</dd>
									<dt>制作时间</dt>
									<dd>${recipeBasicMessage.makingtime }</dd>
									<dt>难易程度</dt>
									<dd>${recipeBasicMessage.thedefficulty }</dd>
									<dt>分享人数</dt>
									<dd>${recipeBasicMessage.sharenumber }人最佳</dd>
								</dl>
								
								<dl class="user">
									<dt>种类</dt>
									<dd>${recipeBasicMessage.recipeType }</dd>
									<dt>提供人</dt>
									<dd>${recipeBasicMessage.provider }</dd>
								</dl>
								
								<dl class="ingredients">
								<c:forEach items="${recipeMaterailMessage }" var="materail">
									<dt>${materail.materailname}</dt>
									<dd>${materail.meterailnumber}</dd>
								</c:forEach>
								
								</dl>
							</article>
							<!--//one-third-->
						</div>
						<!--//recipe-->
						
						
							
		<!--评论 ---- 评论  评论   评论      comments-->
						<div class="comments wow fadeInUp" id="comments">
							<h2>评论： </h2>
	
							<ol class="comment-list">
		
				<!-- 循环显示留言信息	 -->		
						<c:forEach items="${commentMessage }" var="comm" >
					<!-- 一级留言 -->
							<!--comment-->
								<li class="comment depth-1">
								<!-- 头像 -->
								<c:if test="${!empty comm.customerimg }">
									<div class="avatar"><a href="#"><img src="<%=request.getContextPath() %>${comm.customerimg }" alt="" /></a></div>
							
								</c:if>
							
								<c:if test="${empty comm.customerimg }">
									<div class="avatar"><a href="#"><img src="<%=request.getContextPath() %>/images/moren.jpg" alt="" /></a></div>
							
								</c:if>							
									
									<div class="comment-box">
										<div class="comment-author meta"> 
										<!-- 用户名+时间 -->
											<strong>${comm.customername }</strong>${ comm.createTime} <a href="#respond" class="comment-reply-link"> 回复</a>
										</div>
										<div class="comment-text">
											<p>${comm.comment }</p>
										</div>
									</div> 
								</li>
							<!--//comment-->
					<!-- //一级留言 -->

						</c:forEach>
						
				<!-- //循环显示留言信息	 -->		
							
							
						
						<!--respond-->
						<div class="comment-respond wow fadeInUp" id="respond">
							<h2>发表评论</h2>
							<div class="container">
								<p>
								<strong>注意:</strong>
								网站上的评论反映了作者的观点，而不一定是网络社区网站的观点。 要求避免侮辱，亵渎和粗俗的表达。 我们保留删除任何评论的权利，恕不另行通知。
								</p>
								
								<form action="${pageContext.request.contextPath }/comment/save"  method="post">

									<div class="f-row">
							<!-- 评论内容 -->
										<textarea name="comment"></textarea>
										
										<input type="hidden" name="foodName" value="${recipeBasicMessage.foodname }">
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
					</div>
				</section>
				<!--//content-->
				
				<!--right sidebar-->
				<aside class="sidebar one-fourth wow fadeInRight">
					<div class="widget nutrition">
						<h3>Nutrition facts <span>(per serving)</span></h3>
						<table>
							<tr>
								<td>Calories </td>
								<td>505</td>
							</tr>
							<tr>
								<td>Protein</td>
								<td>59g</td>
							</tr>
							<tr>
								<td>Carbs</td>
								<td>59g</td>
							</tr>
							<tr>
								<td>Fat</td>
								<td>29g</td>
							</tr>
							<tr>
								<td>Saturates</td>
								<td>17g</td>
							</tr>
							<tr>
								<td>Fibre</td>
								<td>2g</td>
							</tr>
							<tr>
								<td>Sugar</td>
								<td>44g</td>
							</tr>
							<tr>
								<td>Salt</td>
								<td>0.51g</td>
							</tr>
						</table>
					</div>
					
					<div class="widget share">
						<ul class="boxed">
							<li class="light"><a href="#" title="Facebook"><i class="ico i-facebook"></i> <span>Share on Facebook</span></a></li>
							<li class="medium"><a href="#" title="Twitter"><i class="ico i-twitter"></i> <span>Share on Twitter</span></a></li>
							<li class="dark"><a href="#" title="Favourites"><i class="ico i-favourites"></i> <span>Add to Favourites</span></a></li>
						</ul>
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
	
	
	
<!-- 评论回复 -->
	<script type="text/javascript">
	/*回帖*/
	function reply(){
		var url = "${pageContext.request.contextPath}/comment/add";
		var params = {
			content : editor.$txt.html(),
			aid : '${article.aid }',
			uid : '${user.uid }'
		};
		$.post(url, params, function(data) {
			alert(data.data);
			location.href = "${pageContext.request.contextPath}/article/details/${article.aid }";
		}, "json");
	}
	/*楼中楼回复框*/
	function openFloorInput(num){
  		$('#floor'+num).slideToggle();
  		$('#text'+num).focus();
	}
	function floorReply(num){
		//文本框内容
		var t = $('#text'+num).val();
		//请求服务器,插入评论
		var url = "${pageContext.request.contextPath}/article/floor/add";
		var params = {
			cid : num,
			aid : ${article.aid },
			uid : '${user.uid}',
			content : t,
		};
		$.ajax({
			'url' : url,
			'data' : params,
			'type' : 'POST',
			'success' : function(data) {
				//js插入评论数据
				var t1 = '<div class="media-left">'+
				  '<a href="${pageContext.request.contextPath}/user/info/${user.uid}"><img class="media-object" src="${pageContext.request.contextPath}/${user.headimg }" style="width:34px;"></a>'+
				'</div>'+
				'<div class="media-body">'+
				  '<a href="${pageContext.request.contextPath}/user/info/${user.uid}" target="_blank">${user.username }</a>:'+t+
				'</div>';
				$('#media'+num).append(t1);
				$('#text'+num).val('');
				$('#floor'+num).slideUp();
			},
			'error' : function() {
				alert("回复失败！");
			}
		});	
	}
</script>
	
</body>
</html>


