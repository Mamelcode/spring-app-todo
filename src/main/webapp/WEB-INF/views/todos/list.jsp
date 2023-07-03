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
		<div style="display: flex; justify-content:center; margin-top: 10px;">
		
			<c:forEach items="${quest}" var="q">
				<div class="alert alert-info" style="width: 480px; margin-right: 10px;" role="alert">
					<h4>깜짝 퀘스트! <small>(♥${q.joinCnt})</small></h4>
					<div style="display: flex; justify-content: space-between; text-align: center;">
						<p style="text-align: center;">	
							${q.description}
							<small>(~ <fmt:formatDate value="${q.endDate}" pattern="yyyy-MM-dd"/>)</small>
						</p>
						<c:choose>
							<c:when test="${q.join}">
								<a class="btn btn-secondary">참여중</a>
							</c:when>
							<c:otherwise>
								<a href="/quest/join?questId=${q.id}" class="btn btn-primary">참여하기</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
			
		</div>
		<h2 style="text-align: center;">할일 목록</h2>
		<div class="text-end">
			<a href="/todos/create" class="btn btn-primary">할일 등록</a>
		</div>
		<table class="table" style="text-align: center;">
			<thead>
				<tr>
					<th>내용</th>
					<th>기한</th>
					<th>달성여부</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="one">
					<tr>
						<td>${one.description}</td>
						<td>~ <fmt:formatDate value="${one.targetDate}"
								pattern="yyyy-MM-dd" /></td>
						<td>
							<c:choose>
								<c:when test="${empty one.done}">
									<a href="/todos/success?done=success&id=${one.id}" class="btn btn-success">목표달성</a>
								</c:when>
								<c:otherwise>
									<a class="btn btn-secondary">완료됨</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="/todos/update?todoId=${one.id}" class="btn btn-primary">수정</a>
							<a href="/todos/delete-task?todoId=${one.id}" class="btn btn-danger">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>