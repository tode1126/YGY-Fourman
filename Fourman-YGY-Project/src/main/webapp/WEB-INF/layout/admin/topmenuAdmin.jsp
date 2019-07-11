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
<link rel="stylesheet" href="${root }/css/layout/topmenuStyle.css" />
<link rel="stylesheet" href="${root }/css/Ji_Button_Style.css" />
<link rel="stylesheet" href="${root }/css/admin/topmenuAdminStyle.css" />
</head>
<body>
	<div class="menuLayer">
		<ul class="menu">
			<li><a href="${root }/admin/userManagement/allUserList.do"><span class="button">전체회원</span></a></li>
			<li><a href="${root }/admin/userManagement/leaveUserList.do"><span class="button">탈퇴회원</span></a></li>
			<li><a href="${root }/admin/userManagement/allFoodUserList.do"><span class="button">전체기업회원</span></a></li>
			<li><a href="${root }/admin/userManagement/leaveFoodUserList.do"><span class="button">탈퇴기업회원</span></a></li>
			<li><a><span class="button">전체식당</span></a></li>
			<li><a><span class="button">탈퇴식당</span></a></li>
			<li><a href="${root }/admin/adminManagement/adminList.do"><span class="button">관리자관리</span></a></li>
			<li><a><span class="button">일괄메일</span></a></li>
			<li><a><span class="button">이벤트관리</span></a></li>
			<li><a><span class="button">공지관리</span></a></li>
			<li><a><span class="button">후기관리</span></a></li>
		</ul>
	</div>
</body>
</html>