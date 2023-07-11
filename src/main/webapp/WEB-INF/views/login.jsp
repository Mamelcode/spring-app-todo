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
	<link href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro-v6@44659d9/css/all.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/resource/css/initial.css" />
	<link href="https://webfontworld.github.io/cookierun/CookieRun.css" rel="stylesheet">
	<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
	<link rel="stylesheet" href="/resource/css/style.css" >
</head>
<body class="login_bg">
	
  <div class="wrap">
    <h2>TODO LIST</h2>
	    
    <div class="res_wrap">
      <div class="res_dox">
        <h2>로그인</h2>
        <form class="login_form" action="/user/login" method="post">
          <p>아이디</p>
          <input type="text" name="id" placeholder="아이디(필수)">
          <p>비밀번호</p>
          <input type="password" name="password" placeholder="비밀번호(필수)">
          <button type="submit" name="button">로그인</button>
        </form>

        <div class="login_noid">
          <span>아직 아이디가 없으신가요?</span> <a href="/user/join"><i class="fa-solid fa-arrow-up-right-from-square"></i>회원가입</a>
        </div>
        
      </div>
    </div>
   </div>
    
  </body>
</html>