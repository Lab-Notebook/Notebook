<!-- 个人信息jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
});
</script>
</head>
<body>
<fieldset>
<legend class="header">个人信息</legend>
<div>
姓名：<span>${user.name }</span>
</div>
<div>
学号：<span>${user.username }</span>
</div>
<div>
性别：<span>${user.sex }</span>
</div>
<div>
手机号码：<span>${user.phoneNo }</span>
</div>
<div>
电子邮箱：<span>${user.email }</span>
</div>
</fieldset>
<div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<form action="change">
<button id="changeinfor">修改个人信息</button>
</form>
</div>
	<br><br>
	<a href="login">回到主界面</a>
</body>
</html>