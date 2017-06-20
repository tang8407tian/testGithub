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
			<!--row-->
			<div class="row">
			<!--content-->
				<section class="content center full-width wow fadeInUp">
					<div class="modal container">
						<h3>登录</h3>
						
						<form action="${pageContext.request.contextPath}/customer/login" method="post">
						<div class="f-row">
							<input type="text" name="customerName" placeholder="用户名" />
						</div>
						<div class="f-row">
							<input type="password" name="customerPassword" placeholder="密码" />
						</div>
						 <p >
                		<!-- 登录错误信息显示 -->
               			 <samp style="color: red ;margin-left: 20px">${errorMesLogin }</samp>
              			 </p>
						<div class="f-row">
							<input type="checkbox" />
							<label>记住我的选择</label>
						</div>
						
						<div class="f-row bwrap">
							<input type="submit" value="登录" />
						</div>
						</form>
						
						<p><a href="#">忘记密码？</a></p>
						<p> 没有账号？<a href="register.jsp">.注册.</a></p>
					</div>
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
