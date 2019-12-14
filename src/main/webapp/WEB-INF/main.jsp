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
			$(location).attr('href', 'myexpnotebook');
		});
		$("#apply_exp_notebook").click(function() {
			$(location).attr('href', 'applyexpnotebook');
		});
	});
</script>
<!-- 使用名为home_css的css外部样式表 -->
<link rel="stylesheet" type="text/css" href="css/home_css.css" />
</head>

<body>
	<div class="content head">
		<h2>主菜单</h2>
		<br>
		<br>
	</div>
	<div class="row">
		<div class="menu">
			<br>
			<br> <img src="images/notebook.png" width="70" title="我的实验记录本" />
			<button id="my_exp_notebook" class="black">我的实验记录本</button>
			<br>
			<br>
			<br> <img src="images/pencil.png" width="70" title="申请实验记录本" />
			<button id="apply_exp_notebook" class="white">申请实验记录本</button>
			<br>
			<br>
			<br> <img src="images/search1.png" width="70" title="查看实验记录模板" />
			<button id="check_template" class="black">查看实验记录模板</button>
			<br>
			<br>
			<br> <img src="images/document.png" width="70" title="查看历史实验记录" />
			<button id="check_history_record" class="white">查看历史实验记录</button>
			<br>
			<br>
			<br>
		</div>

		<div class="main"></div>
	</div>

</body>
</html>






