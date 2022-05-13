<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 회원 관리</title>
</head>
<body>
	<h2 >동호회 회원 관리</h2>
	<hr>
	<table width="600" cellpadding="0" cellspacing="0" border="1">
		<tr align="center" bgcolor="pink">
			<td><b>번호</b></td>
			<td><b>이름</b></td>
			<td><b>전화번호</b></td>
			<td><b>주소</b></td>
			<td><b>가입일</b></td>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr align="center">
			<td>${dto.mid }</td>
			<td><a href="view?mid=${dto.mid }">${dto.mname }</a></td>
			<td>${dto.mphone }</td>
			<td>${dto.maddress }</td>
			<td>${dto.mdate }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right">
				<a href="writeForm">회원정보입력</a>
			</td>
		</tr>
	</table>
	
</body>
</html>