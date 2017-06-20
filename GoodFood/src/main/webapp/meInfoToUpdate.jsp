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
					<li>修改个人信息</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title">
					<h1>修改个人信息</h1>
				</header>
					
				<!--content-->
				<section class="content full-width wow fadeInUp">
					<div class="submit_recipe container">
				<!--form  -->
						<form id="formFood" action="${pageContext.request.contextPath}/customer/addMe"  enctype="multipart/form-data"  method="post">
							<section>
								<h2>基本的</h2>
								<p>以下所有字段都需要填写</p>
								<h5>昵称：</h5>
								<div class="f-row">	
									<div class="third"><input type="text" placeholder=" 昵称" value="${oneCustomerMessage.nickname } " name="preparationtime"/></div>
								</div>
								<h5>喜欢的菜：</h5>
								<div class="f-row">	
									<div class="third"><input type="text" placeholder=" 喜欢的菜" value="${oneCustomerMessage.likerecipe } " name="preparationtime"/></div>
								</div>
								<h5>喜欢的厨具：</h5>
								<div class="f-row">	
									<div class="third"><input type="text" placeholder=" 喜欢的厨具" value="${oneCustomerMessage.likekitchenware } "  name="preparationtime"/></div>
								</div>
								<h5>喜欢的调味料：</h5>
								<div class="f-row">	
									<div class="third"><input type="text" placeholder=" 喜欢的调味料" value="${oneCustomerMessage.likeseasoning } " name="preparationtime"/></div>
								</div>
								
								
								
				
						<!--img  食谱照片信息  -->				
							<section>
								<h2>头像：</h2>
								<div class="f-row full">
									<input type="file"  name="file1" />
								</div>
							</section>	
						<!--//img  食谱照片信息  -->		
							
							
				
			<!--发布提交  -->		
							<div class="f-row full">
								<input type="submit"  class="button" id="submitRecipe" value="下一步 " />
							</div>
						</form>
						
					<!--//form  -->
					</div>
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
	
	<!-- 循环添加原料信息 -->
	<script type="text/javascript">
		var materail = '<div class="f-row ingredient">'+
							'<div class="large"><input type="text" placeholder="原料" name="materailname"/></div>'+
							' <div class="small"><input type="text" placeholder="数量" name="meterailnumber" /></div>'+
							'<button class="remove">-</button>'+
						'</div>';
		var materailBOX = $('#materailBOX');
		var addmaterail = $('#addmaterail');
		function addmaterail2(){
			materailBOX.append($(materail));
		}
		materailBOX.on('click', '.remove', function() {
			var v = $(this).parent();
			v.remove();
		});
	</script>
	<!-- 循环添加美食制作步骤 -->
	<script type="text/javascript">
		
		function foodStep(){
			var foodStep =' <div class="f-row instruction">'+
								'<div class="full"><input type="text" placeholder="说明" name="foodstep"/></div>'+
								'<button  type="button" class="remove">-</button>'+
			 				' </div>';
			var stepBox = $('#stepBox');
			stepBox.append($(foodStep));
		}
		$('#stepBox').on('click', '.remove', function() {
			var s = $(this).parent();
			s.remove();
		});
	</script>
	
	</script>
</body>
</html>


