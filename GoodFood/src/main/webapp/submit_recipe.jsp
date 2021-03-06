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
					<li>提交一份食谱</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				<header class="s-title">
					<h1>添加一份新的食谱</h1>
				</header>
					
				<!--content-->
				<section class="content full-width wow fadeInUp">
					<div class="submit_recipe container">
				<!--form  -->
						<form id="formFood" action="${pageContext.request.contextPath}/recipebasic/save"  enctype="multipart/form-data"  method="post">
							<section>
								<h2>基本的</h2>
								<p>以下所有字段都需要填写</p>
				<!--RecipebasicEntity  食谱基本信息  -->
								<div class="f-row">
									<div class="full"><input type="text" placeholder="食谱标题" name="foodname" /></div>
									 <p >
		                				<!-- 登录错误信息显示 -->
		               					 <samp style="color: red ;margin-left: 20px">${recipeErrorMsg }</samp>
		              			 	</p>
								</div>
								
								<div class="f-row">
									<div class="third"><input type="text" placeholder=" 准备时间"  name="preparationtime"/></div>
									<div class="third"><input type="text" placeholder="烹饪时间"  name="makingtime"/></div>
									<div class="third">
										<select name="thedefficulty" >
											<option>简单</option>
											<option>一般</option>
											<option>困哪</option>
											<option>超级困难</option>
											
										</select>
									</div>
								</div>
								
								<div class="f-row">
									<div class="third"><input type="text" placeholder="制作人" name="provider"/></div>
									<div class="third"><input type="text" placeholder="可以和几人一起分享该美食---请填入阿拉伯数字" name="sharenumber" /></div>
									<div class="third">
										<select name="recipeType" >
											<option>或选择一个类别</option>
											<option>川菜</option>
											<option>粤菜</option>
											<option>东北菜</option>
											<option>徽菜</option>
											<option>四川菜</option>
											<option>汤类</option>
											<option>甜点</option>
											<option>烘烤类</option>
										</select>
									</div>
								</div>
								
							</section>
							
							<section>
								<h2>描述</h2>
								<div class="f-row">
									<div class="full"><textarea placeholder="食谱简介" name="introduce"></textarea></div>
								</div>
							</section>	
							
							
						<!--img  食谱照片信息  -->				
							<section>
								<h2>照片</h2>
								<div class="f-row full">
									<input type="file"  name="file1" />
								</div>
							</section>	
						<!--//img  食谱照片信息  -->		
							
							
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


