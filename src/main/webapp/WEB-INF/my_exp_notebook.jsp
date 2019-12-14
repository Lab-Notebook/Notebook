<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的实验记录本</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$.post("showbook",{"id":1},function(data){
			var result;
			for(var i=0;i<data.length;i++){
				result+="<tr>";
				result+="<td>"+data[i].bookId+"</td>";
				result+="<td>"+data[i].name+"</td>";
				result+="<td>"+data[i].getTime+"</td>";
				result+="<td>"+data[i].pageNum+"</td>";
				result+="<tr>";
			}
			$("#exp_table").html(result);
		},'json');
});
</script>
</head>
<body>
	<!-- caption 定义表格标题 -->
	<table>
		<caption class="header">我的实验记录本</caption>
		<thead>
			<tr>
				<th>记录本编号</th>
				<th>记录本名称</th>
				<th>领取日期</th>
				<th>总页数</th>
				<th>操作</th>
			</tr>
		<thead />
		<tbody id="exp_table"></tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>