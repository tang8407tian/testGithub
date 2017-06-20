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
					<li>\制作材料</li>
					<li>\制作步骤</li>
				</ul>
			</nav>
			<!--//breadcrumbs-->
			
			<!--row-->
			<div class="row">
				
					
				<!--content-->
				<section class="content full-width wow fadeInUp">
					<div class="submit_recipe container">
				<!--form  -->
						<form id="formFood" action="${pageContext.request.contextPath}/recipestep/save"  method="post">
							
					
			<!--RecipestepEntity  食谱制作步骤信息  -->		
							<section>
								<h2>说明 <span>(填入说明，每次一步)</span></h2>
								<div id="stepBox">
									<div class="f-row instruction">
										<div class="full"><input type="text" placeholder="说明"  name="foodstep"/></div>
										<button  type="button" class="remove" >-</button>
									</div>
								</div>
								
								<div class="f-row full">
									<button type="button" class="add" onclick="foodStep()"  >添加步骤</button>
								</div>
							</section>
			<!--//RecipestepEntity  食谱制作步骤信息  -->		
							
			
							<section>
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
								<input type="submit"  class="button" id="submitRecipe" value="完成 " />
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
	<script type="text/javascript">
		
		function submitFood(){
			
			console.log('submitFood');
			submitFood1();
			submitFood2();
			submitFood3();
		}
		function submitFood1(){
			console.log('submitFood1');
			$('#formFood').attr('action', '${pageContext.request.contextPath}/recipebasic/save');
			$('#formFood').submit();
		}
		function submitFood2(){
			console.log('submitFood2');

			$('#formFood').attr('action', '${pageContext.request.contextPath}/recipematerail/save');
			$('#formFood').submit();
		}
		function submitFood3(){
			console.log('submitFood3');
			$('#formFood').attr('action', '${pageContext.request.contextPath}/recipebasic/save');
			$('#formFood').submit();
		}
		//${pageContext.request.contextPath}/recipematerail/save
	</script>
</body>
</html>


