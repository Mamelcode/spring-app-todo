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
	<link href="https://webfontworld.github.io/cookierun/CookieRun.css" rel="stylesheet">
	<link rel="stylesheet" href="/resource/css/initial.css" />
	<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
	<link rel="stylesheet" href="/resource/css/style.css" >
</head>
<body class="login_bg">
  <div class="wrap">
    <h2>TODO LIST</h2>

    
    <div class="res_wrap">
      <div class="res_dox">
        <h2>회원가입</h2>
        <form class="login_form" action="/user/join" method="post">
          <p>아이디</p>
          <input type="text" name="id" placeholder="아이디(필수)">
          <p>비밀번호</p>
          <input type="password" name="password" placeholder="비밀번호(필수)">

          <button type="submit" name="button">회원가입</button>
        </form>

        <div class="login_noid">
          <span>아이디가 있으신가요?</span> <a href="/user/login"><i class="fa-solid fa-arrow-up-right-from-square"></i>로그인</a>
        </div>
        
      </div>
    </div>
    
   </div>

</body>
</html>