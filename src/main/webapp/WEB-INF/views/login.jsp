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
	<h2>로그인</h2>
	<form action="/user/login" method="post">
		<c:if test="${!empty error}">
			<span>${error}</span>
		</c:if>
		<h3>아이디</h3>
		<input type="text" name="id" placeholder="아이디..">
		<h3>비밀번호</h3>
		<input type="password" name="password" placeholder="비밀번호..">
		<button type="submit">로그인</button>
	</form>
	<p><a href="/user/join">회원가입 하러가기</a></p>
</body>
</html>