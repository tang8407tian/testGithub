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
				<section class="content center full-width wow fadeInUp" >
					<div class="modal container">
						<h3>注册</h3>
						
						<form action="${pageContext.request.contextPath}/customer/regist" method="post"> 
						
						<div class="f-row">
						
							<input type="text" name="customerName" id="customerName" placeholder="账 号" />
						</div>
						<div class="f-row">
							<input type="email" name="customweEmail" placeholder="你的邮箱" />
						</div>
						<div class="f-row">
							<input type="password" name="customerPassword" id="customerPassword"  placeholder="你的密码" />
						</div>
						<div class="f-row">
							<input type="password" name="repeatCustomerPassword" placeholder="再次确认密码" />
						</div>
						
						 <p >
                		<!-- 登录错误信息显示 -->
               			 <samp style="color: red ;margin-left: 20px">${errorMessage } ${errorMesRegister }</samp>
              			 </p>
						<div class="f-row bwrap">
							<input type="submit" value="注册" />
						</div>
						
						</form>
						
						<p>已经拥有了一个账号? <a href="login.jsp">登录.</a></p>
					</div>
				</section>
				<!--//content-->
			</div>
			<!--//row-->
		</div>
		<!--//wrap-->
	</main>
	<!--//main-->
	
	
	<!--footer--><!--preloader-->
	
		<jsp:include page="common/commonFooter.jsp" />
	
	<!--//footer--> <!--//preloader-->
	
	<jsp:include page="common/commonJsFooter.jsp" />
	<script>new WOW().init();</script>
</body>
</html>

