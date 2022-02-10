<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:if 사용하기위해 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty login }"><!-- 로그인정보 비어있을경우 -->
	<a href="loginForm">로그인</a>&nbsp;
	<a href="memberForm">회원가입</a>&nbsp;
</c:if>

<c:if test="${!empty login }"> 안녕하세요? ${login.username } 님 !
	<a href="loginCheck/logout">로그아웃</a>&nbsp;<!--  -->
	<a href="loginCheck/myPage">mypage</a>&nbsp;<!--  -->
	<a href="/cartList">장바구니</a>&nbsp;<!--  -->
	
</c:if>


