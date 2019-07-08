<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/client/FnQStyle.css"/>
<script type="text/javascript" src="${root }/js/FnQ/FnQjs.js"></script>

<!-- <script type="text/javascript">

$(function(){
	  $(".li1").click(function(){
		  $(".li1").removeClass("active");
	    $(this).addClass("active");
	    
	  });
});
</script> -->

<script type="text/javascript">
	$(function(){
		/* $("#btn1").click(function(){
			var path = getContextPath();
			console.log(path);
			$.getJSON(path+"/json/FnQ/test.json", function(data) {
				var str="";
				$.each(data,function(index,entry){
					str+="이름:"+entry.name+"<br>";
					if(entry.hobby==null){
						str+="취미 없음<br>";
					}else{
						str+="취미:";
						$.each(entry.hobby,function(hindex,hentry){
							str+=hentry+"&nbsp;";
						});
						str+="<br>";
					}
					str+="나이:"+entry.age+"<br>";
					str+="점수<br>";
					//str+="국어:"+entry["score"].kor+"<br>";
					str+="국어:"+entry.score.kor+",";
					str+="영어:"+entry["score"].eng+",";
					str+="수학:"+(entry["score"].mat==null?"빵점":
						entry["score"].mat)+"<br>";
					
					str+="<hr>"
					str+="<a href='#' class='li2'>ㅎㅇㅎㅇ</a>";
				});
				$("#disp").html(str);
			});
		}); */
		
		$("#All").click(function(){
			
			var path = getContextPath();
			console.log(path);
			
			$.getJSON(path+"/json/FnQ/all.json", function(data) {
				var all="";
				$.each(data,function(index,entry){
					all += entry.title;
					all += "<a href='#' class='DetailAll'>"+entry.content+"</a>";					
					all += "<hr>"
					all += "<div >"+entry.detail
				});
				$("#disp").html(all);
				
				$("body").on( "click", "a.DetailAll", function() {
					  $( this ).after(entry.content1)
						 	          
							 						 							  						  

					});
				
			});
		});
		
		
		
	});
	
	function getContextPath(){
		var hostIndex = location.href.indexOf(location.host) + location.host.length;
		console.log(hostIndex)
		return location.href.substring(hostIndex, location.href.indexOf('/',hostIndex+1));
	}
</script>


</head>
<body>

<a href="#" id="btn1">json 데이타 읽기</a>
<hr>


<div class="FnQ">

		<a href="#" id="All" class="li1">전체</a>
		<a href="#" class="li1">식당 이용</a>
		<a href="#" class="li1">회원</a>
		<a href="#" class="li1">반품/교환/환불</a>
		<a href="#" class="li1">주문/결제</a>
		<a href="#" class="li1">기타</a>
		
			
</div>

<br><br><br>

<div id="disp" style="color: black;"></div>


</body>
</html>
