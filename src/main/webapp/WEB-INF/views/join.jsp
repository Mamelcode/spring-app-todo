<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="/user/join" method="post">
		<c:if test="${error}">
			${error}
		</c:if>
		<h3>아이디</h3>
		<input type="text" name="id" placeholder="아이디..">
		<h3>비밀번호</h3>
		<input type="password" name="password" placeholder="비밀번호..">
		<button type="submit">회원가입</button>
	</form>
	<p>
		<a href="/user/login">로그인 하러가기</a>
	</p>
</body>
</html>