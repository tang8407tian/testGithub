<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="common/commonHead.jsp" />
</head>
<body class="errorPage">


 

	<!--header-->
	<jsp:include page="common/commonHeader.jsp" />
	<!--//header-->
		
	<!--main-->
	<main class="main" role="main">
		<!--wrap-->
		<div class="wrap clearfix">
			<!--row-->
			<div class="row wow fadeInUp">
				<!--content-->
				<section class="content three-fourth">
					<!--row-->
					<div class="row">
						<div class="one-third">
							<div class="error-container">
								<span class="error_type">404</span>
								<span class="error_text">Page not found</span>
							</div>
						</div>
						
						<div class="two-third">
							<div class="container">
							<p>您请求的 <samp style="color: red ">${noSearcha }</samp>------ </p>
							
							<form id="form1" runat="server"> <h3><div id='div1'></div>  <p> </p>  </h3>  </form>  
							
								<p>您请求的页面无法找到或已从数据库中删除。 </p>
								<p>如果你认为这是一个错误，请 <a href="contact.html">联系我们</a>. 谢谢!</p>
								<p>你可以 <a href="index.html">返回首页</a> 或尝试使用搜索. </p>
							</div>
						</div>
					</div>
					<!--//row-->
				</section>
				<!--//content-->
				
				<!--sidebar-->
				<aside class="sidebar one-fourth">
					<div class="widget">
						<h3>搜索</h3>
						<div class="f-row">
							<input type="search" placeholder="输入你的搜索信息" />
						</div>
						<div class="f-row">
							<input type="submit" value="搜索" />
						</div>
					</div>
				</aside>
				<!--//sidebar-->
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

<script type="text/javascript">  
//设定倒数秒数  
var t = 6;  
//显示倒数秒数  
function showTime(){  
     t -= 1;  
     console.log(document.getElementById('div1'));
    document.getElementById('div1').innerHTML= "还剩："+ t + "返回列表页面";  
    if(t==0){  
        location.href='${pageContext.request.contextPath}/recipebasic/findSomeNub';  
    }  
    //每秒执行一次,showTime()  
    setTimeout("showTime()",1000); 
  
}  

showTime();
</script>
</html>


 


