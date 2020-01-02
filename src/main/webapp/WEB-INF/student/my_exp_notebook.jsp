<!-- 学生“我的实验记录本”界面jsp-->
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
	$.ajax({
		url:"showbook",
		type:"post",
		async:false,
		success:function(data){
			var result;
			for(var i=0;i<data.length;i++){
				result+="<tr>";
				result+="<td>"+(i+1)+"</td>";
				result+="<td>"+data[i].name+"</td>";
				result+="<td>"+data[i].getTime+"</td>";
				result+="<td>"+data[i].pageNum+"</td>";
				result+="<td>"+"<button class='open'>打开</button>"+"</td>";
				result+="<tr>";
			}
			$("#exp_table").html(result);
		}
	});
	$(".open").click(function(){
		var num=$(this).parent().parent().find("td").eq(0).text();
		$(location).attr('href', 'openbook'+'?num='+num);
	});
});
</script>
</head>
<body>
	<!-- caption 定义表格标题 -->
	<table>
		<caption class="header">我的实验记录本</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>记录本名称</th>
				<th>领取日期</th>
				<th>总页数</th>
				<th>操作</th>
			</tr>
		<thead />
		<tbody id="exp_table"></tbody>
		<tfoot></tfoot>
	</table>
	<br><br>
	<a href="login">回到主界面</a>
</body>
</html>