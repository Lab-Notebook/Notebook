<!-- 填写实验记录本申请单界面jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申请单</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//jquery 页面加载完成之后
	$(function() {
		$.post("showproject",function(data){
			var pname="<option value=''/>";
			
			for(var i=0;i<data.length;i++){
				pname+="<option value="+data[i].name+">"+data[i].name+"</option>";
			}
			$("#project").html(pname);
		});
		$("#submit").click(function(){
			var project=$("#project").val();
			var reason=$("#reason").val();
			var remark=$("#remark").val();
			if(project==""){
				alert("请选择所属项目！");
				return false;
			}
			else if(reason==""){
				alert("请填写申请原因！");
				return false;
			}
			else{
				$.post("submitapplication",{"project":project,"reason":reason,"remark":remark},function(success){
					if(success){
						alert("提交申请成功！");
		                self.location = document.referrer;
					}
						
					else{
						alert("系统忙，请重试！");
					}
						
					
				});
			}
		});
	});
</script>
</head>
<body>
<fieldset>
	<legend class="header">实验记录本申请单</legend><br><br>
	<div>所属项目<br>
	<select name="project" id="project">
	</select></div>
	<div>申请原因<br>
	<input type="text" id="reason" name="reason">
	</div>
	<div>备注(选填)<br>
	<input type="text" id="remark" name="remark">
	</div>
	<div>
	<button id="submit">提交</button>
	</div>
</fieldset>

</body>
</html>