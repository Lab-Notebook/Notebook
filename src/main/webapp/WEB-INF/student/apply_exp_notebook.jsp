<!-- 学生实验记录本申请列表界面jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请实验记录本</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
var count;
var pageSize;
var pageNumber=1;
function getapp(){
	$.ajax({
		url:"showapplication",
		type:"post",
		data:{"pageNumber":pageNumber},
		async:false,
		success:function(data){
			var result;
			var list=data.list
			for(var i=0;i<list.length;i++){
				result+="<tr>";
				result+="<td>"+(i+1)+"</td>";
				result+="<td>"+list[i].project.name+"</td>";
				result+="<td>"+list[i].reason+"</td>";
				result+="<td>"+list[i].applyTime+"</td>";
				result+="<td>"+list[i].applyStatus+"</td>";
				result+="<td>"+list[i].remark+"</td>";
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
});
</script>
</head>
<body>
<!-- caption 定义表格标题 -->
	<table>
		<caption class="header">申请实验记录本</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>所属项目</th>
				<th>申请原因</th>
				<th>申请时间</th>
				<th>申请状态</th>
				<th>备注</th>
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
	<form action="application">
		<button>申请实验记录本</button>
	</form>
</body>
</html>