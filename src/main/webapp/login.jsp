<!-- 登录jsp，即实验记录本网页打开第一个页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电子实验记录本</title>
<!-- 使用名为login_css的css外部样式表 -->
<link rel="stylesheet" type="text/css" href="css/login_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//jquery 页面加载完成之后
	$(function() {
		$("a").click(function() {
			//浏览器带有缓存功能,不会多次请求相同数据
			$("#validcode").attr("src", "validcode?date=" + new Date());
			return false;
		});
		//点击"登录"之后的事件

		$("#submit").click(function() {
			var username = $("#username").val();//取出用户填写的用户名、密码、验证码
			var password = $("#password").val();
			var permission=$("#permission").val();
			var code = $("#code").val();
			if (code=="") {
				alert("请输入验证码！");
				return false;
			} 
			else if (username == "" || password == "") {
				alert("请输入完整信息！");
				return false;
			} 
			else {
				var flag=true;
				$.ajax({					//发送ajax请求 请求服务器返回验证码
					url:"getcode",
					type:"post",
					async:false,			//设置ajax为同步请求，当ajax请求返回结果后，才执行后面的语句
					success:function(codeSession){
						if(code!=codeSession){
							alert("验证码错误！");
							flag=false;
						}
					},
					error:function(){
						alert("请重试！");
						flag=false;
					}
				});							//ajax请求结束
				if(flag==false)return flag;
				else{
					//return true;
					$.ajax({					//发送ajax请求 请求服务器验证用户名和密码
						url:"checklogin",
						type:"post",
						data:{"username":username,"password":password,"permission":permission},
						async:false,			//设置ajax为同步请求
						success:function(success){
							if(success==false){
								alert("用户名或密码错误！");
								flag=false;
							}
						},
						error:function(){
							alert("请重试！");
							flag=false;
						}
					});							//ajax请求结束		
					return flag; 
				}
			
			}

		});

	});
</script>
</head>
<body>
	<div class="column left">
		<img src="images/welcomebook.png" width="300">
	</div>
	<div class="column right">
	<div><h2>电子实验记录本系统</h2></div>
	<br>
	<form action="login" method="post" >
		<fieldset>
		<legend>登录</legend>
		用户名:<br> <input type="text" name="username" id="username" value="123"/><br /><br>
		密码:<br> <input type="password" name="password" id="password" value="111"/><br /><br>
		选择权限:<br><select id="permission" name="permission">
		<option value="student">学生</option>
		<option value="teacher">教师</option>
		<option value="admin">管理员</option>
		</select><br><br>
		验证码:<br> <input type="text" size="1" name="code" id="code" class="validcode"/> 
		<img src="validcode" width="250" height="100" id="validcode"/> <a href="">看不清</a><br />
		<br> <input type="submit" value="登录" id="submit" /> 
		<input type="reset" value="重置" />
		</fieldset>
	</form>
	</div>
</body>
</html>
