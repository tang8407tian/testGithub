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
					<li>提交一份博客</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title">
					<h1>添加一份新的博客</h1>
				</header>
					
				<!--content-->
				<section class="content full-width wow fadeInUp">
					<div class="submit_recipe container">
				<!--form  -->
						<form id="formFood" action="${pageContext.request.contextPath}/blog/save"  enctype="multipart/form-data"  method="post">
							
							
							<section>
								<h2>基本的</h2>
								<p>请注意博客标题的格式问题</p>
				<!--RecipebasicEntity  食谱基本信息  -->
								<div class="f-row">
									<div class="full"><input type="text" placeholder="博客名字" name="bolgname" /></div>
									 <p >
		                				<!-- 登录错误信息显示 -->
		               					 <samp style="color: red ;margin-left: 20px">${recipeErrorMsg }</samp>
		              			 	</p>
								</div>
						
								
							</section>
							
							<!--img  食谱照片信息  -->				
							<section>
								<h2>博客照片</h2>
								<div class="f-row full">
									<input type="file"  name="file1" />
								</div>
							</section>	
						<!--//img  食谱照片信息  -->		

							<section>
								<h2>博客简介：</h2>
								<div class="f-row">
									<div class="full"><textarea placeholder="食谱简介" name="summary"></textarea></div>
								</div>
							</section>	


							
							<section>
								<h2>博客的正文内容：</h2>
								<div class="f-row">
									<div class="full"><textarea placeholder="食谱简介" name="blog"></textarea></div>
								</div>
							</section>	
							
							
						
							
							
				<!--//RecipebasicEntity  食谱基本信息  -->
							
				
								<h2>状态 <span>(是否要进一步编辑此配方，还是准备发布？)</span></h2>
								<div class="f-row full">
									<input type="radio" id="r1" name="radio"/>
									<label for="r1">还要继续编辑</label>
								</div>
								<div class="f-row full">
									<input type="radio" id="r2" name="radio"/>
									<label for="r2">我准备发布这个是食谱</label>
								</div>
							</section>
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


