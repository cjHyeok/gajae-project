<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:if 사용하기위해 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<p>&emsp;&emsp;</p>
<h1>&emsp;&emsp;&emsp;문의 수정화면</h1>
<hr style="border: 3px color= silver;" width="90%" />

<style>
table {
	width: 900px;
	margin-left: auto;
	margin-right: auto;
}
</style>


<form action="reviewContentUpdateAction" method="get">
	<div style="width: 90%; margin: 0 auto;">
		<p>&nbsp;</p>
		<%
			String userid = (String) session.getAttribute("userid");
		%>

		<table style="border-collapse: collapse; width: 90%; height: 33px;"
			border="1">

			<tr>
				<div>
					<input type="text" name="r_title" id="r_title" size="40" style="background-color: #e2e2e2;" value='${ reviewReadContent[0].r_title }'>
				</div>
			</tr>


		</table>

		<p></p>
		<table style="border-collapse: collapse; width: 90%; height: 33px;" border="1">
			<tbody>

				<tr>
					<div>
						<input type="text" name="content" id="content" style="width: 90%; vertical-align: middle; height: 250px; margin: 0 auto;" value='${ reviewReadContent[0].content }'> 
						<input type='hidden' name='userid' value='${ userid }'> 
						<input type='hidden' name='r_id' value='${ reviewReadContent[0].r_id }'>
					</div>
				</tr>
			</tbody>
		</table>
		<p></p>
		<div>
			
			<button type="button">
				<a href='reviewList'>글목록</a>
			</button>

			<input type="submit" value="확인">
		</div>
	</div>
</form>