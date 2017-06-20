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
						<h3>请输入新密码</h3>
						
						<form action="${pageContext.request.contextPath}/customer/modifypassword2" method="post">
						<div class="f-row">
							<input type="hidden" name="id" value="${ids }" placeholder="id" />
						</div>
						
						<div class="f-row">
							<input type="text" name="customerPassword" placeholder="请输入你的新密码!!" />
						</div>
						
						<div class="f-row">
							<input type="text" name="repeatCustomerPassword" placeholder="请再次输入你的新密码!!" />
						</div>
						

						<div class="f-row bwrap">
							<input type="submit" value="提交" />
						</div>
						</form>
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
