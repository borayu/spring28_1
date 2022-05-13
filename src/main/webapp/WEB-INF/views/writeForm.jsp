<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 회원 관리</title>
</head>
<body>
	<h2>동호회 회원 관리</h2>
	<hr>
	<h4>회원정보 입력</h4>
	<table width="0" cellpadding="10" cellspacing="10" border="1">
		<form action="write" method="post">
			<tr>
				<td align="center" bgcolor="pink" width="80">회원 이름</td>
				<td><input type="text" name="mname" size="100"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="pink" width="80">전화번호</td>
				<td><input type="text" name="mphone" size="100"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="pink" width="80">주소</td>
				<td><input type="text" name="maddress" size="100"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="pink" width="80">가입일</td>
				<td><input type="text" name="mdate" size="100"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="회원목록보기">&nbsp;&nbsp;&nbsp;
					<input type="submit" value="회원입력완료">&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</form>
	</table>
</body>
</html>