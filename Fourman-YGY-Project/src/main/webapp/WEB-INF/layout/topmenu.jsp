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
	    <li><a href="#">한식</a></li>
	    <li><a href="#">양식</a></li>
	    <li><a href="#">중식</a></li>
	    <li><a href="#">베트남</a></li>
	    <li><a href="#">남미음식</a></li>
	    <li><a href="#">후기게시판</a></li>
	</ul>
</nav>
</div>

</body>
</html>