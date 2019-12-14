<!-- 学生实验记录本申请列表界面jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申请实验记录本</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
		$.post("showapplication",function(data){
			var result;
			for(var i=0;i<data.length;i++){
				result+="<tr>";
				result+="<td>"+i+"</td>";
				result+="<td>"+data[i].project.name+"</td>";
				result+="<td>"+data[i].reason+"</td>";
				result+="<td>"+data[i].applyTime+"</td>";
				result+="<td>"+data[i].applyStatus+"</td>";
				result+="<td>"+data[i].remark+"</td>";
				result+="<tr>";
			}
			$("#apply_table").html(result);
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
	</table><br><br><br><br>
	<form action="application">
		<button>申请实验记录本</button>
	</form>
</body>
</html>