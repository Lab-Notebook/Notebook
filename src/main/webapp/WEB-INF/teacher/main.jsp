<!-- 指导教师首页-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 使用EL表达式 -->
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#my_exp_notebook").click(function() {
			$(location).attr('href', 'checkapplication');
		});
		$("#check_record").click(function() {
			//跳转到审批记录界面
		});
	});
</script>
<!-- 使用名为home_css的css外部样式表 -->
<link rel="stylesheet" type="text/css" href="css/home_css.css" />
</head>

<body>
	<div class="content head">
		<h2>欢迎回来！${user.name }老师</h2>
		<br> <br>
	</div>
	<div class="main"><br><br>
		<br> <br> <img src="images/notebook.png" width="70"
			title="查看记录本申请" />
		<button id="my_exp_notebook" class="black" >查看记录本申请</button>
		<img src="images/pencil.png" width="70" title="审批实验记录" />
		<button id="check_record" class="white">审批实验记录</button>
	</div>
	<br><br>
	<a href="http://localhost:8081/Notebook/">退出登录</a>
</body>
</html>






