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
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<body>
<div class="menu">
	<ul class="menu">
		<li><a href="./admin/admin.do">한식</a></li>
		<li><a href="./restraunt/restraunt.do">양식</a></li>
		<li><a>중식</a></li>
		<li><a>일식</a></li>
		<li><a>남미음식</a></li>
		<li><a href="${root }/reboard/reboardlist.do">후기게시판</a></li>
		<li><a href="${root }/user/loginform.do">로그인</a></li>
	</ul>
</div>
</body>
</html>
