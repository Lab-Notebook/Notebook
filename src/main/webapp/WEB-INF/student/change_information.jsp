<!-- 修改个人信息jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("#change").click(function(){
		var phoneno=$("#phoneno").val();
		var email=$("#email").val();
		var id=${user.id};
	$.post("changeinformation",{"phoneNo":phoneno,"email":email,"id":id},function(success){
			if(success==1){
				alert("修改信息成功！");
				self.location = document.referrer;
			}
			else{
				alert("失败！请重试！");
			}
		}); 
	});
	
});
</script>
</head>
<body>
<fieldset>
<legend class="header">修改个人信息</legend>
<div>
手机号码：<input type="text" id="phoneno">
</div>
<div>
电子邮箱：<input type="text" id="email">
</div>
</fieldset>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<button id="change" class="black" >修改</button>
</body>
</html>