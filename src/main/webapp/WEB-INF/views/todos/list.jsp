<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Todo</title>
  <!-- 팝업창 관련 -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
  <!-- 팝업창 관련 -->
  <link href="https://webfontworld.github.io/cookierun/CookieRun.css" rel="stylesheet">
  <link rel="stylesheet" href="/resource/css/initial.css">
  <link href="https://cdn.jsdelivr.net/npm/remixicon@3.0.0/fonts/remixicon.css" rel="stylesheet">
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
  <link rel="stylesheet" href="/resource/css/style.css">
</head>
<body>
  <div class="wrap">
    <h2>TODO LIST</h2>

    <div class="tab">
      <ul class="tabnav">
        <li><a href="#tab01">전체</a></li>
        <li><a href="#tab02">진행중</a></li>
        <li><a href="#tab03">완료</a></li>
        <li><a href="#tab04">실패</a></li>
      </ul>

      <div class="tabcontent">
      	<!-- 전체 -->
        <div id="tab01" >
          <div id="tasks">
          	<c:if test="${empty todos}">
            	<div id="notification">오늘의 할일 리스트가 없습니다.</div>
            </c:if>
            <ul id="task_list">
            <c:forEach items="${todos}" var="one">
            <c:if test="${one.done eq 'N'}"><c:set var="status" value="진행중"/></c:if>
            <c:if test="${one.done eq 'Y'}"><c:set var="status" value="완료"/></c:if>
            <c:if test="${one.done eq 'P'}"><c:set var="status" value="실패"/></c:if>
              <li>
                <p>${one.description}<small>(${status})</small></p> <span>${one.startDate} ~ ${one.endDate}</span>
                <div class="task_btn">
                  <a href="/todos/delete-task?todoId=${one.id}"><button type="button" name="button" class="delete"><i class="ri-delete-bin-line"></i></button></a>
                </div>
              </li>
             </c:forEach>
            </ul>
          </div>
        </div>

		<!-- 진행중 -->
        <div id="tab02">
          <div id="tasks">
          	<c:forEach items="${todos}" var="two" varStatus="var">
	          	<c:choose>
	          		<c:when test="${two.done eq 'N'}">
          			<c:set var="Nemp" value="true"/>
			            <ul id="task_list">
			              <li>
			                <p>${two.description}</p> <span>${two.startDate} ~ ${two.endDate}</span>
			                <div class="task_btn">
			                  <a href="#modify" rel="modal:open" id="modifyClick${var.count}" data-id="${two.id}" onclick="onclickHandle(id)"><button type="button" name="button" class="modify"><i class="ri-pencil-line"></i></button></a>
			                  <a href="/todos/success?done=Y&id=${two.id}"><button type="button" name="button" class="success"><i class="ri-check-line"></i></button></a>
			                  <a href="/todos/delete-task?todoId=${two.id}"><button type="button" name="button" class="delete"><i class="ri-delete-bin-line"></i></button></a>
			                </div>
			              </li>
			            </ul>
	           		</c:when>
	            </c:choose>
            </c:forEach>
            <c:if test="${Nemp eq null}">
       			<div id="notification">진행중인 리스트가 없습니다.</div>
       		</c:if>
          </div>
        </div>

		<!-- 팝업창 관련 -->
		<div id="modify" class="modal modalbox">
		    <form id="container" action="/todos/update-task" method="post">
		    <input type="hidden" name="id" id="modifyId">
		      <div id="list_add">
		        <div class="list_info">
		          <input class="taskInput" type="text" name="description" placeholder="리스트 추가" id="modifyDescription">
		          <div class="list_date">
		            <span><label for="">시작</label><input id="modifyStartDate" class="taskInput" type="datetime-local" name="startDate"></span>
		            <span><label for="">종료</label><input id="modifyEndDate" class="taskInput" type="datetime-local" name="endDate"></span>
		          </div>
		        </div>
		        <button id="taskAdd"><i class="ri-pencil-line"></i></button>
		      </div>
		    </form>
		</div>

		<!-- 완료 -->
        <div id="tab03">
          <div id="tasks">
          	<c:forEach items="${todos}" var="three">
	          	<c:choose>
	          		<c:when test="${three.done eq 'Y'}">
	          			<c:set var="Yemp" value="true"/>
			            <ul id="task_list">
			              <li>
			                <p>${three.description}</p> <span>${three.startDate} ~ ${three.endDate}</span>
			                <div class="task_btn">
			                  <a href="/todos/delete-task?todoId=${three.id}"><button type="button" name="button" class="delete"><i class="ri-delete-bin-line"></i></button></a>
			                </div>
			              </li>
			            </ul>
	           		</c:when>
	            </c:choose>
            </c:forEach>
            <c:if test="${Yemp eq null}">
       			<div id="notification">완료 리스트가 없습니다.</div>
       		</c:if>
          </div>
        </div>

		<!-- 실패 -->
        <div id="tab04">
          <div id="tasks">
          	<c:forEach items="${todos}" var="three">
	          	<c:choose>
	          		<c:when test="${three.done eq 'P'}">
	          			<c:set var="Pemp" value="true"/>
			            <ul id="task_list">
			              <li>
			                <p>${three.description}</p> <span>${three.startDate} ~ ${three.endDate}</span>
			                <div class="task_btn">
			                  <a href="/todos/delete-task?todoId=${three.id}"><button type="button" name="button" class="delete"><i class="ri-delete-bin-line"></i></button></a>
			                </div>
			              </li>
			            </ul>
	           		</c:when>
	            </c:choose>
            </c:forEach>
            <c:if test="${Pemp eq null}">
       			<div id="notification">실패 리스트가 없습니다.</div>
       		</c:if>
          </div>
        </div>
      </div>
    </div>

	<!-- 할일 생성 -->
    <form id="container" action="/todos/create-task" method="post">
      <div id="list_add">
        <div class="list_info">
          <input class="taskInput" type="text" name="description" placeholder="리스트 추가">
          <div class="list_date">
            <span><label for="">시작</label><input class="taskInput" type="datetime-local" name="startDate"></span>
            <span><label for="">종료</label><input class="taskInput" type="datetime-local" name="endDate"></span>
          </div>
        </div>
        <button id="taskAdd">+</button>
      </div>
    </form>
   	<c:if test="${param.error eq '1'}">
		<span style="color: red; display: flex; justify-content: center; text-align: center;">생성에 실패하였습니다.</span>
	</c:if>

	<!-- 깜짝 퀘스트 -->
    <div class="event_area">
      <h3>TODAY QUEST</h3>
      <ul class="event_wrap">
      <c:forEach items="${quest}" var="q">
        <li>
          <div class="event_title">
            <h2>${q.description}</h2>
            <p><span>${q.startDate}</span> ~ <span>${q.endDate}</span></p>
          </div>
          <div class="event_people">
            <p><i class="ri-user-3-line"></i><span>${q.joinCnt}</span>명</p>
            <c:choose>
	            <c:when test="${q.joined}">
	            	<a>참여중</a>
	            </c:when>
	            <c:otherwise>
	            	<a href="/quest/join?id=${q.id}">참여하기</a>
	            </c:otherwise>            	
            </c:choose>
          </div>
        </li>
      </c:forEach>
      </ul>
    </div>
  </div>
  
  <script type="text/javascript">
  	function onclickHandle(id) {
  		 var idx = $('#'+id).data('id');
		 
		 const xhr = new XMLHttpRequest();
		 xhr.open("get", "/todos/gettodo?id="+idx, false);
		 xhr.send();
		 
		 const response = JSON.parse(xhr.responseText);
		 
		 if(xhr.status === 200) {
			document.getElementById('modifyDescription').value = response.description
			document.getElementById('modifyStartDate').value = response.startDate
			document.getElementById('modifyEndDate').value = response.endDate
			document.getElementById('modifyId').value = response.id
		 }else {
			 window.alert("정보를 불러오는데 실패하였습니다.")
		 };
	 };
  </script>

  <script type="text/javascript">
    $(function() {
      $('.tabcontent > div').hide();
      $('.tabnav a').click(function() {
        $('.tabcontent > div').hide().filter(this.hash).fadeIn();
        $('.tabnav a').removeClass('active');
        $(this).addClass('active');
        return false;
      }).filter(':eq(0)').click();
    });
  </script>
  <script type="text/javascript" src="./js/common.js"></script>
  <!-- 팝업창 관련 -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
  <!-- 팝업창 관련 -->
</body>
</html>
