
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <title>Document</title>

<link rel="stylesheet" type="text/css" href="css/calendar_css.css">
</head>
<body>
    <div class="calendar">
        <div class="title">
            <h1 class="green" id="calendar-title">Month</h1>
            <h2 class="green" id="calendar-year">Year</h2>
            <button id="pre">上一页</button>
            <button id="next">下一页</button>
        </div>
 
        <div class="body">
            <div class="lightgrey body-list">
                <ul>
                    <li>SUN</li>
                    <li>MON</li>
                    <li>TUE</li>
                    <li>WED</li>
                    <li>THU</li>
                    <li>FRI</li>
                    <li>SAT</li>
                    
                </ul>
 
            </div>
 
            <div class="darkgrey body-list">
                <ul id="days">
                </ul>
            </div>
        </div>
    </div>
 <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
    $(function(){
    	  //调用refreshDate()函数，日历才会出现
    	 refreshDate();
    	 $("ul").on("click","li.day",function(){
    		var date=my_year+"-"+(my_month+1)+"-"+$(this).html();
    		$("#date",window.parent.document).val(date);
         }); 
    	 
    });
    
        var month_olypic = [31,29,31,30,31,30,31,31,30,31,30,31];//闰年每个月份的天数
        var month_normal = [31,28,31,30,31,30,31,31,30,31,30,31];
        var month_name =["January","Febrary","March","April","May","June","July","Auguest","September","October","November","December"];
        //获取以上各个部分的id
        var holder = document.getElementById("days");
        var ctitle = document.getElementById("calendar-title");
        var cyear = document.getElementById("calendar-year");
        //获取当天的年月日
        var my_date = new Date();
        var my_year = my_date.getFullYear();//获取年份
        var my_month = my_date.getMonth(); //获取月份，一月份的下标为0
        var my_day = my_date.getDate();//获取当前日期
 
        //根据年月获取当月第一天是周几
        function dayStart(month,year){
            var tmpDate = new Date(year, month, 1);
            return (tmpDate.getDay());
        }
        //根据年份判断某月有多少天(11,2018),表示2018年12月
        function daysMonth(month, year){
            var tmp1 = year % 4;
            var tmp2 = year % 100;
            var tmp3 = year % 400;
 
            if((tmp1 == 0 && tmp2 != 0) || (tmp3 == 0)){
                return (month_olypic[month]);//闰年
            }else{
                return (month_normal[month]);//非闰年
            }
        }
        //js实现str插入li+class,不要忘了用innerhtml进行插入
        function refreshDate(){
            var str = "";
            //计算当月的天数和每月第一天都是周几，day_month和day_year都从上面获得
            var totalDay = daysMonth(my_month,my_year);
            var firstDay = dayStart(my_month, my_year);
            //添加每个月的空白部分
            for(var i = 0; i < firstDay; i++){
                str += "<li>"+"</li>";
            }
 
            //从一号开始添加知道totalDay，并为pre，next和当天添加样式
            var myclass;
            for(var i = 1; i <= totalDay; i++){
                //三种情况年份小，年分相等月份小，年月相等，天数小
                //点击pre和next之后，my_month和my_year会发生变化，将其与现在的直接获取的再进行比较
                //i与my_day进行比较,pre和next变化时，my_day是不变的
                if((my_year < my_date.getFullYear())||(my_year == my_date.getFullYear() && my_month < my_date.getMonth()) || (my_year == my_date.getFullYear() && my_month == my_date.getMonth() && i < my_day)){
                    myclass = " class='lightgrey day'";
                }else if(my_year == my_date.getFullYear() && my_month == my_date.getMonth() && i == my_day){
                    myclass = "class = 'green greenbox day'";
                }else{
                    myclass = "class = 'darkgrey day'";
                }
                str += "<li "+myclass+">"+i+"</li>";
            }
            holder.innerHTML = str;
            ctitle.innerHTML = month_name[my_month];
            cyear.innerHTML = my_year;
        }
   	 $("#pre").click(function(){
    	 my_month--;
         if(my_month < 0){
             my_year--;
             my_month = 11; //即12月份
         }
         refreshDate();
    });
   	$("#next").click(function(){
        my_month++;
        if(my_month > 11){
            my_month = 0;
            my_year++;
        }
        refreshDate();
    });
      
      
 
       
       
        
    </script>
</body>
</html>
