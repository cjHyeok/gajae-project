<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1 style="text-align: center;">문의하기</h1>
<hr style="border: 3px color= silver;" width="90%">
<style>
table {
	width: 900px;
	margin-left: auto;
	margin-right: auto;
}

table, td, th {
	border-collapse: collapse;
	border: 1px solid black;
}
;
</style>
<div>
	<table width="300%">
		<thead>
			<tr bgcolor=grey>
				<th width="3%" align="center">번호</th>
				<th width="30%">제목</th>
				<th width="5%">작성자</th>
				<th width="6%">작성일</th>
				<th width="3%">조회수</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach var="qlist" items="${questionList}" varStatus="status">
				<tr>
					<td align="center">${qlist.q_id}</td>
					<td><a href='<c:out value="/questionReadContent?q_id=${qlist.q_id}"/>'><c:out value="${qlist.q_title}" /></a></td>
					<td align="center">${qlist.username}</td>
					<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${qlist.wdate}" /></td>
					<td align="center">${qlist.lookup}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<div style="float: right;">
		<button type="button">
			<a href='questionWritePage'>글쓰기</a>
		</button>
		<button type="button">
			<a href='/'>메인으로</a>
		</button>
	</div>
</div>