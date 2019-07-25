<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/layout/reboardStyle.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">

<!-- <script type="text/javascript">
	function checkValue(){
		if(!document.form1.reboard_subject.value){
            alert("제목을 입력하세요.");
            return false;
        }
		if(!document.form1.user_info_nickname.value){
            alert("닉네임을 입력하세요.");
            return false;
        }
        
        if(!document.form1.user_info_email.value){
            alert("이메일을 입력하세요.");
            return false;
        }
        
        if(!document.form1.reboard_content.value){
            alert("내용을 입력하세요.");
            return false;
        }
	}
</script> -->

</head>
<body>
<div class="BoardWrite">
	<form name="form1" action="write.do" method="post">
		<table class="table-table-striped" style="width: 400px;">
			<caption style="text-align: center"><b>게시판 글쓰기</b></caption>
			<tr>
				<th style="width: 100px;">별점</th>
				<td>
					<input type="text" class="form-Control" name="reboard_rating">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">제목</th>
				<td>
					<input type="text" class="form-Control" name="reboard_subject" id="reboard_subject">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">작성자</th>
				<td>
					<input type="text" class="form-Control" name="user_info_nickname" id="user_info_nickname">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">이메일</th>
				<td>
					<input type="text" class="form-Control" name="user_info_email" id="user_info_email">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="5" cols="40" class="form-Control" name="reboard_content" id="reboard_content"></textarea>
			</tr>
			<tr>
				<td colspan="2" align="center">			
				<button type="submit" id="btnSave">저장</button>
				<button type="reset" 
					onclick="location.href='reboardlist.do?pageNum=${pageNum}'">취소</button>
			</tr>
		</table>
	</form>
</div>
</body>
</html>