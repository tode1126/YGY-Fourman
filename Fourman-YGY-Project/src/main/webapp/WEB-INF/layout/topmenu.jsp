<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/layout/topmenuStyle.css"/>
</head>
<body>
<div class="menu">
	<ul class="menu">
		<li><a href="./admin/admin.do">한식</a></li>
		<li><a href="./restraunt/restraunt.do">양식</a></li>
		<li><a>중식</a></li>
		<li><a>일식</a></li>
		<li><a>남미음식</a></li>
		<li><a>후기게시판</a></li>
		<c:if test="${empty sessionScope.userLoginInfo}">
		<li><a href="${root }/main/user/loginform.do">로그인</a></li>
		</c:if>
		<c:if test="${not empty sessionScope.userLoginInfo}">
			<li>이메일 : ${sessionScope.userLoginInfo.user_Email} 
			<a href="${root }/user/logout.do">로그아웃</a></li>
			<li><a href="${root }/main/user/userCheck.do">회원정보</a></li>
		</c:if>
	</ul>
</div>
</body>
</html>