<!-- 学生的某一个实验记录本jsp-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>实验记录本</title>
<link rel="stylesheet" type="text/css" href="css/content_css.css "/>
<link rel="stylesheet" type="text/css" href="css/popups_css.css "/>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/popups.js"></script>
<script type="text/javascript">
var file;
function getrecord(){
	var bookId=${book.bookId};
	$.ajax({
		url:"getrecords",
		type:"post",
		data:{"bookId":bookId},
		async:false,
		success:function(list){
			var result;
			for(var i=0;i<list.length;i++){
				result+="<tr>";
				result+="<td>"+(i+1)+"</td>";
				result+="<td>"+list[i].name+"</td>";
				result+="<td>"+list[i].doneTime+"</td>";
				result+="<td>"+list[i].instruction+"</td>";
				result+="<td>"+list[i].uploadTime+"</td>";
				result+="<td>"+list[i].isOpen+"</td>";
				result+="<td>"+list[i].isCheck+"</td>";
				result+="<td>"+list[i].checkTime+"</td>";
				result+="<td>"+"<button class='download'>下载</button>"+"</td>";
				result+="<tr>";
			}
			$("#record_table").html(result);
		}
	});
};
$(function(){
	getrecord();
	$(".download").click(function(){
		var num=$(this).parent().parent().find("td").eq(0).text();
	});
	$("#date").click(function(){
		$("#calendar").css("visibility","visible");
	});
	$("#file").change(function(e){
		file=e.currentTarget.files;
		var fileName=file[0].name;
		var fileSize=file[0].size;
		var fileType=file[0].type;
	});
	$("#submit").click(function(){
		 alert("上传成功！");
	  
	});
});
</script>
</head>
<body>
	<div id="background" class="black_overlay"  onclick="closePopup('popup','background')"></div>
    <div id="popup" class="white_content">
        <div class="inner_content">
            <img src="images/cross.png" width="25px" onclick="closePopup('popup','background')">
        </div>
        <div style="position:absolute;left:0px;">
        	<fieldset>
        		<legend class="header">新增实验记录</legend>
        		<div class="column_left">
	        		<div style="text-align:left;">
	        		<form action="submitrecord" enctype="multipart/form-data"  method="post">
	        		实验标题<br><input type="text" id="title"><br>
	        		实验日期<br><input type="text" id="date" readonly="readonly">
	        		<br>附件<br><input type="file" id="file" name="file">
	        		<button id="submit" class="white">上传</button>
	        		</form>
	        		</div>
	        	</div>
        		<div class="column_right">
        			<div style="overflow:hidden;">
	        		<iframe id="calendar" src="test.jsp" scrolling="no" frameborder="0" width="450px" height="350px">
	        		</iframe>
	        		</div>
        		</div>
        	</fieldset>
        </div>
        
    </div>
	<table>
		<caption class="header">记录本：<span>${book.name}</span></caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>实验标题</th>
				<th>实验日期</th>
				<th>实验说明</th>
				<th>提交日期</th>
				<th>公开设定</th>
				<th>审核状态</th>
				<th>审核日期</th>
				<th>附件</th>
			</tr>
		<thead />
		<tbody id="record_table"></tbody>
		<tfoot></tfoot>
	</table><br><br>
	<button class="white" id="upload" onclick="showPopup('popup','background')">上传实验记录</button>
	<br><br>
	<a href="login">回到主界面</a>
</body>
</html>