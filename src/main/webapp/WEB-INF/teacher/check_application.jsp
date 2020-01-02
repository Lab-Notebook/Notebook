<!-- 教师查看实验记录本申请页面jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看实验记录本申请</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
var count;
var pageSize;
var pageNumber=1;
function getapp(){
	$.ajax({
		url:"teacher/showapplication",
		type:"post",
		data:{"pageNumber":pageNumber},
		async:false,
		success:function(data){
			var result;
			var list=data.list
			for(var i=0;i<list.length;i++){
				result+="<tr>";
				result+="<td>"+(i+1)+"</td>";
				result+="<td>"+list[i].student.username+"</td>";
				result+="<td>"+list[i].student.name+"</td>";
				result+="<td>"+list[i].applyTime+"</td>";
				result+="<td>"+list[i].project.name+"</td>";
				result+="<td>"+list[i].applyReason+"</td>";
				result+="<td>"+list[i].remark+"</td>";
				result+="<td>"+"<button id=i class='pass'>通过</button><button id=i class='reject'>拒绝</button>"+"</td>";
				result+="<tr>";
			}
			$("#apply_table").html(result);
			count=data.count;
			pageNumber=data.pageNumber;
			pageSize=data.pageSize; 
		}
	});
	$("#pagenum").text(pageNumber);
};
$(function(){
		getapp();
		$("#next").click(function(){
			if(count<pageNumber*pageSize+1){
				alert("已到最后一页");
				return false;
			}
			else{
				pageNumber=pageNumber+1;
				getapp();
			}
		});
		$("#last").click(function(){
			if(pageNumber<=1){
				alert("已到第一页");
				return false;
			}
			else{
				pageNumber=pageNumber-1;
				getapp();
			}
		}); 
		$(".pass").click(function(){
			var num=$(this).parent().parent().find("td").eq(0).text();
			$(location).attr('href', 'createnewnotebook'+'?num='+num);
		});
		$(".reject").click(function(){
			var num=$(this).parent().parent().find("td").eq(0).text();
			$.post("deleteapplication",{"num":num},function(success){
				if(success==1)
					alert("已退回该同学的实验记录本申请");
				else
					alert("失败！");
			});
		});
		
});
</script>
</head>
<body>
<!-- caption 定义表格标题 -->
	<table>
		<caption class="header">实验记录本申请单</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>申请人学号</th>
				<th>申请人姓名</th>
				<th>申请时间</th>
				<th>所属项目</th>
				<th>申请原因</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		<thead />
		<tbody id="apply_table"></tbody>
		<tfoot></tfoot>
	</table>
	<div>
	当前第<span id="pagenum"></span>页
	</div>
	<button id="last">上一页</button>
	<button id="next">下一页</button>
	<br><br>
	<a href="login">回到主界面</a>
</body>
</html>