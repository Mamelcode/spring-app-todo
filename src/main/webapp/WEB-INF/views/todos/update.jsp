<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>



	<div class="container">
		<h2>목표 변경</h2>
		<c:if test="${!empty error}">
			<div class="alert alert-danger" role="alert">
				${error}
			</div>
		</c:if>
		<form action="/todos/update-task" method="post">
			<input type="hidden" name="id" value="${todo.id}">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">날짜</label> 
				<input type="date" class="form-control" name="targetDate"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					value='<fmt:formatDate value="${todo.targetDate}" pattern="yyyy-MM-dd"/>'>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">목표</label>
				<input type="text" class="form-control" value="${todo.description}"
					name="description" id="exampleInputPassword1">
			</div>
			<button type="submit" class="btn btn-primary">변경</button>
		</form>
	</div>
	
	
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
</body>
</html>