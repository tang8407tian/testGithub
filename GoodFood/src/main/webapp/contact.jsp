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
						<form method="post" action="contact_form_message.php" name="contactform" id="contactform">
							<h3>联系我们</h3>
							<div id="message" class="alert alert-danger"></div>
							<div class="f-row">
								<input type="text" placeholder="名字或账号" id="name" />
							</div>
							<div class="f-row">
								<input type="email" placeholder="你的邮箱" id="email" />
							</div>
							<div class="f-row">
								<input type="number" placeholder="你的联系方式" id="phone" />
							</div>
							<div class="f-row">
								<textarea placeholder="你的意见" id="comments"></textarea>
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


