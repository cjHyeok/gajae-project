<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:if 사용하기위해 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#cart").on("click", function() {
			$("form").attr("action", "loginCheck/cartAdd")
		})

		$("#up").on("click", function() {
			var count = $("#quantity").val();
			$("#quantity").val(parseInt(count) + 1);
		});

		$("#down").on("click", function() {
			var count = $("#quantity").val();
			if (count != 1) {
				$("#quantity").val(parseInt(count) - 1);
			}
		});
	});
</script>

<c:if test="${!empty mesg }">
	<script>
		session.removeAttribute("mesg");
		alert("${mesg}상품을 장바구니에 담았습니다.");
	</script>
</c:if>


<form name="productRetrieveForm" method="GET" action="#">
	<input type="hidden" name="p_photo" value="${productRetrieve.p_photo }">
	<input type="hidden" name="p_id" value="${productRetrieve.p_id }">
	<input type="hidden" name="p_name" value="${productRetrieve.p_name }">
	<input type="hidden" name="price" value="${productRetrieve.price }">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7"><img src="images/items/${productRetrieve.p_photo }" border="0" align="center" width="200" /></td>
						<td class="td_title">제품 코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>${productRetrieve.p_id }</td>
					</tr>
					<tr>
						<td class="td_title">상품명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>${productRetrieve.p_description }</td>
					</tr>
					<tr>
						<td class="td_title">가격</td>
						<td class="td_red" colspan="2" style='padding-left: 30px'>${productRetrieve.price }</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2"><font color="#2e56a9" size="2" style='padding-left: 30px'><b> 무료배송</b></font> <font size="2">(도서 산간지역 별도 배송비 추가)</font></td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'>
							<select class="select_change" size="1" name="p_option" id="p_option">
								<option selected value="특">특</option>
								<option value="상">상</option>
								<option value="보통">보통</option>
							</select>
						</td>
					</tr>


					<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px">
							<input type="text" name="quantity" value="1" id="quantity" style="text-align: right; height: 18px"> 
							<img src="images/Up.PNG" id="up"> 
							<img src="images/Down.PNG" id="down">
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br>
	<button>구매</button>
	&nbsp;&nbsp;
	<button id="cart">장바구니</button>
</form>
