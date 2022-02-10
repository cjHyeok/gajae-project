<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${!empty mesg }">
	<script>
		alert('${mesg}');
	</script>
</c:if>


<form action="login" method="get">
아이디:<input type="text" name="userid" id="userid" value="gajae"><br> <!-- userid 걸어두었음 -->
비밀번호:<input type="text" name="passwd" id="passwd" value="1111"><br> <!-- passwd 걸어두었음 -->
<input type="submit" value="로그인">
<button type="button" value="회원가입" onClick="window.open('memberForm')">회원가입</button>
</form>