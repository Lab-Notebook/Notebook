<!-- 教师创建新的实验记录本页面jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建新的实验记录本</title>
<link rel="stylesheet" type="text/css" href="css/create_css.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var pageNum=$("#pageNum").val();
		var bookId="${book.id}";
		$.post("createbook",{"bookId":bookId,"pageNum":pageNum},function(success){
			if(success==1){
				alert("新建实验记录本成功！");
				self.location = document.referrer;
			}
			else {
				alert("请重试！");
			}
		});
	});
});
</script>
</head>
<body>
	<fieldset>
		<legend class="header">创建新的实验记录本</legend>
		<div>使用者学号：${book.student.username}</div>
		<div>&emsp;页数：<input id="pageNum" type="text" value="20"></div><br>
		<button id="submit" class="black">提交</button>&emsp;&emsp;
		<button id="cancel" class="white">取消</button>
	</fieldset>
</body>
</html>