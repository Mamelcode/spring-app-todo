<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/auth-task" method="post">
		<h3>아이디</h3>
		<input type="text" name="id" placeholder="아이디..">
		<h3>비밀번호</h3>
		<input type="password" name="pass" placeholder="비밀번호..">
		<button type="submit">로그인</button>
	</form>
	<p><a href="">회원가입</a> 하셈</p>
</body>
</html>