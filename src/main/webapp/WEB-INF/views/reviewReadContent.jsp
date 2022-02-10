<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:if 사용하기위해 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%
	String userid = (String) session.getAttribute("userid");
%>
<script type="text/javascript">
	$(document).ready(function() {
		console.log('onclick111');

		$("#delete").on("click", function() {
			if (confirm("삭제하시겠습니까?")) {

			} else {
				return false;
			}
		});
		
		$("#btnComment").click(function() {
			
			console.log("btnComment");
			
			  $.ajax({
					 url:'R_commentWriteAdd',
					 type:'get',
					 data:{
						 r_id:${reviewReadContent[0].r_id}, 
						 userid:'${userid}', 
						 rev_comment: document.getElementById("rev_comment").value,
					 },
					 dataType:"text",
					 success:function(data,status,xhr){
						 console.log(data);//mesg
						 //$("#sugCount").text(data);
						 document.getElementById("rev_comment").value="";
						 $("#r_commentList").html(data); 
						
					 },
					 error:function(xhr,status,error){}
				  });//end ajax	 
		});

		$("#btnRecommend").click(function() {
			
			  $.ajax({
					 url:'recommend',
					 type:'get',
					 data:{
						 r_id:${reviewReadContent[0].r_id},  //parameter  id=입력하는 값  keyup event 시 마다 
					 },
					 dataType:"text",
					 success:function(data,status,xhr){
						 console.log(data);//mesg
						 $("#sugCount").text(data);
					 },
					 error:function(xhr,status,error){}
				  });//end ajax	 
		});
		
	$("#btnbadRecommend").click(function() {
			
			  $.ajax({
					 url:'badrecommend',
					 type:'get',
					 data:{
						 r_id:${reviewReadContent[0].r_id},  //parameter  id=입력하는 값  keyup event 시 마다 
					 },
					 dataType:"text",
					 success:function(data,status,xhr){
						 console.log(data);//mesg
						 $("#sugbadCount").text(data);
					 },
					 error:function(xhr,status,error){}
				  });//end ajax	 
		});

	});
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

    #wrapper{
        width:300px;
        margin:auto;
    }
    #txtContact{
        width:fit-content;
        margin:auto;
    }

</style>






<h1 align="center">상품후기</h1>
<table>

	<tr align="left">
		<th style="background-color: eeeeee">&nbsp; &nbsp; <font size="4">제목
				&emsp;&emsp;&emsp;&emsp;&emsp;<font size="4">${reviewReadContent[0].r_title}</th>
	</tr>
	<tr align="left">
		<th align="justify" class="font-username">&nbsp; &nbsp; <font size="3">작성자&emsp;${reviewReadContent[0].username}
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				&emsp;&emsp;&emsp;&emsp;&emsp;조회수&emsp;${reviewReadContent[0].lookup}
				&emsp;&emsp;&emsp;&emsp;&emsp;추천수&emsp;${reviewReadContent[0].suggestion}</th>
	</tr>
	
	<tr height="400">
		<th style="padding: 30px 25px 50px;" align="left">${reviewReadContent[0].content}</th>
	</tr>


</table>

<div id="r_commentList">
	<table boader=0%>
		<c:forEach var="rlist" items="${r_commentList}" varStatus="status">
			<tr>
				<td align="center">${rlist.username}</td>
				<td align="center">${rlist.wdate}</td>
				<td align="center">${rlist.comm_content}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<p></p>

<h2>&emsp;&emsp;&emsp;&nbsp;&nbsp;댓글작성</h2>
<hr>


<br>




<form>
	<tr>
		
			<input type="text" display=table-cell; name="rev_comment" id="rev_comment" size="100" style="width: 90%; vertical-align: middle; height: 250px; margin: 0 auto;">
		
	</tr>
</form>

<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->

<div id="wrapper">
<button type="button" id="btnRecommend">좋아요</button>
<span id="sugCount">${reviewReadContent[0].suggestion}</span>

<button type="button" id="btnbadRecommend">싫어요</button>
<span id="sugbadCount">${reviewReadContent[0].badsuggestion}</span>
<br>
</div>
<button type="button" onclick="location.href='reviewList'">글목록</button>
<button name="btnComment" id="btnComment" type="button">댓글 작성</button>


<c:if test="${reviewReadContent[0].userid eq userid }">
	<button type="button">
		<a href='reviewUpdatePage?r_id=${reviewReadContent[0].r_id}'>수정</a>
	</button>
</c:if>

<c:if test="${reviewReadContent[0].userid eq userid }">
	<button name="delete" id="delete" type="button">
		<a href='reviewContentDel?r_id=${reviewReadContent[0].r_id}'>삭제</a>
	</button>
</c:if>


