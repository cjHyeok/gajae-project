<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1 style="text-align: center;">상품후기</h1>
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
				<th width="3%">추천수</th>

			</tr>
		</thead>
		<tbody>


			<c:forEach var="rlist" items="${reviewList}" varStatus="status">
				<tr>
					<td align="center">${rlist.r_id}</td>
					<td><a href='<c:out value="/reviewReadContent?r_id=${rlist.r_id}"/>'><c:out value="${rlist.r_title}" /></a></td>
					<td align="center">${rlist.username}</td>
					<td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${rlist.wdate}" /></td>
					<td align="center">${rlist.lookup}</td>
					<td align="center">${rlist.suggestion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="float: right;">
		<button type="button">
			<a href='reviewWritePage'>글쓰기</a>
		</button>
		
		<button type="button">
			<a href='/'>메인으로</a>
		</button>
	</div>
</div>