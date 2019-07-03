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
</head>
<body>
${email}<br>
메일 인증이 필요합니다.<br>
발송후 3~5분이 소요 될수 있습니다.<br>
<a href="${root }/user/usermailcheck.do?email=${email}">메일 전송</a>
</body>
</html>