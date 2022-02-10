<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	//선택삭제
	$(document).ready(function() {
		$("#delSelCart").click(function() {
			var c_id = $("input:checkbox[name=check]:checked").length;
			if (c_id == 0) {
				alert("선택해주세요");
				return;
			}

			var confirm_val = confirm("정말 삭제하시겠습니까?");

			if (confirm_val) {
				$("form").attr("action", "loginCheck/delSelCart");
				$("form").submit();
			}
		});
	});

	function totalXXX() { //총합을 구하는 함수 
		var totalSum = 0;
		$(".sum").each(function(idx, data) {//idx, element
			totalSum += Number.parseInt($(data).text());
		});
		$("#totalSum").text(totalSum);
	}

	$(function() {//화면이 불러지면 
		totalXXX();//총합 구하기 

		//주문하기
		$(".orderBtn").on("click", function() {
			var c_id = $(this).attr("data-num");//주문번호
			location.href = "loginCheck/orderConfirm?c_id=" + c_id;
		});

		//전체 주문하기
		$("#AllConfirm").on("click", function() {

			location.href = "loginCheck/orderAllConfirm";
		})

		//전체삭제
		$("#delAllCart").on("click", function() {

			$(".check").each(function(idx, data) {
				this.checked = true;
			});

			$("form").attr("action", "loginCheck/delAllCart");
			$("form").submit();
		});

		//전체선택
		$("#allCheck").on("click", function() {
			var result = this.checked;
			$(".check").each(function(idx, data) {
				this.checked = result;
			});
		});

		//삭제버튼 이벤트처리
		$(".deleteBtn").on("click", function() {
			console.log("deleteBtn 클릭 ");
			var c_id = $(this).attr("data-num");
			var xxx = $(this);
			$.ajax({
				url : "loginCheck/cartDelete",
				type : "get",
				dataType : "text",
				data : {
					c_id : c_id
				},
				success : function(data, status, xhr) {
					console.log("success");
					//dom삭제 
					xxx.parents().filter("tr").remove();
					totalXXX(); //총합 다시 구하기 
				},
				error : function(xhr, status, error) {
					console.log(error);
				}
			});//end ajax
		});//end event
		//수정버튼이벤트 처리 
		$(".updateBtn").on("click", function() {
			//console.log("업데이트===");
			var c_id = $(this).attr("data-num");
			var quantity = $("#cartQuantity" + c_id).val();
			var price = $(this).attr("data-price");
			//console.log(c_id, quantity, price);
			$.ajax({
				url : "loginCheck/cartUpdate",
				type : "get",
				dataType : "text",
				data : {
					c_id : c_id,
					quantity : quantity
				},
				success : function(data, status, xhr) {
					var total = parseInt(quantity) * parseInt(price);
					$("#sum" + c_id).text(total);
					totalXXX(); /// 총합 다시 구하기 
				},
				error : function(xhr, status, error) {
					console.log(error);
				}
			});
		});
	});
</script>
<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><input type="checkbox"
			name="allCheck" id="allCheck" width="80"> <strong>ALL</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>



	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>


	<form name="myForm">

		<c:forEach var="x" items="${cartList}">



			<tr>
				<td class="td_default" width="80"><input type="checkbox"
					name="check" id="check81" class="check" value="${x.c_id}">
				</td>
				<td class="td_default" width="80">${x.c_id}</td>
				<td class="td_default" width="80"><img
					src="images/items/${x.p_photo}" border="0" align="center"
					width="80" /></td>
				<td class="td_default" width="300" style='padding-left: 30px'>
					${x.p_name} <br> <font size="2" color="#665b5f">[옵션 :
						품질 (${x.p_option})]</font>
				</td>
				<td class="td_default" align="center" width="150"><span
					id="ggPrice${x.c_id}">${x.price}</span></td>

				<td class="td_default" align="center" width="90"><input
					class="input_default" type="text" name="cartQuantity"
					id="cartQuantity${x.c_id}" style="text-align: right" maxlength="3"
					size="2" value="${x.quantity}"></input></td>

				<td><input type="button" value="수정" class="updateBtn"
					data-num="${x.c_id}" data-price="${x.price}" /></td>


				<td class="td_default" align="center" width="80"
					style='padding-left: 5px'><span id="sum${x.c_id}" class="sum">
						${x.price * x.quantity} </span></td>
				<td><input type="button" value="주문" class="orderBtn"
					data-num="${x.c_id}"></td>
				<td class="td_default" align="center" width="30"
					style='padding-left: 10px'><input type="button" value="삭제"
					class="deleteBtn" data-num="${x.c_id}"></td>
				<td height="10"></td>
			</tr>


		</c:forEach>

	</form>
	<tr>
		<td colspan="10">총합 : <span id="totalSum"></span>
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5">
			<button id="AllConfirm">전체 주문하기</button>
			<button id="delSelCart">선택 삭제하기</button>
			<button id="delAllCart">전체 삭제하기</button> <a class="a_black"
			href="/productListAll"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>

	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
