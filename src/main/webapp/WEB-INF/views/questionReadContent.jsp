<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:if 사용하기위해 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%
	String userid = (String) session.getAttribute("userid");
%>
<script type="text/javascript">

	$(document).ready(function(){
		console.log('onclick111');
		
		  $("#delete").on("click", function (){
			  if (confirm("삭제하시겠습니까?")){
				  
			  } else {
				return false;  
			  }
		 });
	  
	  
	  $("#btnComment").click(function() {

			//${reviewReadContent[0].r_id} rev_comment   userid
			
			console.log("btnComment");
			
			  $.ajax({
					 url:'Q_commentWriteAdd',
					 type:'get',
					 data:{
						 q_id:${questionReadContent[0].q_id}, 
						 userid:'${userid}', 
						 que_comment: document.getElementById("que_comment").value,
					 },
					 dataType:"text",
					 success:function(data,status,xhr){
						 console.log(data);//mesg
						 //$("#sugCount").text(data);
						 document.getElementById("que_comment").value="";
						 $("#q_commentList").html(data); 
						
					 },
					 error:function(xhr,status,error){}
				  });//end ajax	 
		});

		


});//end ready

</script>


<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
</style>
<p style="font-family: Nanum Gothic;"></p>






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
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap')
	;

.font-username {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>






<h1 align="center">문의사항</h1>
<table>

	<tr align="left">
		<th style="background-color: eeeeee">&nbsp; &nbsp; <font size="4">제목
				&emsp;&emsp;&emsp;&emsp;&emsp;<font size="4">${questionReadContent[0].q_title}</th>
	</tr>
	<tr align="left">
		<th align="justify" class="font-username">&nbsp; &nbsp; <font size="3">작성자&emsp;${questionReadContent[0].username}
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				&emsp;&emsp;&emsp;&emsp;&emsp;조회수&emsp;${questionReadContent[0].lookup}</th>
	</tr>
	<tr height="400">
		<th style="padding: 30px 25px 50px;" align="left">${questionReadContent[0].content}</th>
	</tr>

</table>
<div id="q_commentList">
	<table boader=0%>
		<c:forEach var="qlist" items="${q_commentList}" varStatus="status">
			<tr>
				<td align="center">${qlist.username}</td>
				<td align="center">${qlist.wdate}</td>
				<td align="center">${qlist.comm_content}</td>
			</tr>

		</c:forEach>
	</table>
</div>
<p></p>

<h2>&emsp;&emsp;댓글작성</h2>
<hr>


<br>


<form>
	<tr>
		
			<input type="text" display=table-cell; name="que_comment" id="que_comment" size="100" style="width: 90%; vertical-align: middle; height: 250px; margin: 0 auto;">
		
	</tr>

</form>



<button type="button" onclick="location.href='questionList'">글목록</button>


<c:if test="${questionReadContent[0].userid eq userid }">
	<button type="button">
		<a href='questionUpdatePage?n_id=${questionReadContent[0].q_id}'>수정</a>
	</button>
</c:if>

<c:if test="${questionReadContent[0].userid eq userid }">
	<button name="delete" id="delete" type="button">
		<a href='questionContentDel?n_id=${questionReadContent[0].q_id}'>삭제</a>
	</button>
</c:if>


<button name="btnComment" id="btnComment" type="button">댓글 작성</button>