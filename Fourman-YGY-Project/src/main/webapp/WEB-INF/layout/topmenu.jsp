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
<script src="./js/layout/topmenuJs.js"></script>
<link rel="stylesheet" href="${root }/css/layout/topmenuStyle.css"/>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<body>

<div class="menu">
	<nav class="navBar">
    <div class="container">
        <ul class="nav">
            <li><a href="#" class="active">Home</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Products</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </div>
</nav>
</div>

</body>
</html>