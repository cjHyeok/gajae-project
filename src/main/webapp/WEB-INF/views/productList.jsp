<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<table width="100%" cellspacing="0" cellpadding="0">

	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
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
	<!-- 반복시작 -->			
<c:forEach var = "dto" items="${productList}" varStatus="status">
	

						<td>
							<table style='padding:15px'>
								<tr>
									<td>
										<a href="productRetrieve?p_id=${dto.p_id }"> 
											<img src="images/items/${dto.p_photo }" border="0" align="middle" width="200">
										</a> 
									
									</td>
								</tr>
								<tr>
								
									<td height="10">
								</tr>
								<tr>
									<td class= "td_default" align ="center">
										<%-- <a class= "a_black" href="GoodsRetrieveServlet?p_id=${dto.p_id}"> 
										${ dto.p_name}
										</a> --%>
										<font color="gray">
										 --------------------
										</font>
									</td>
									
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align ="center">
										${ dto.p_description}
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align ="center"><font color="red"><strong>${ dto.price}</strong></font></td>
								</tr>
							</table>
						</td>
					
					<!-- 한줄에 4개씩 보여주기 -->	
				  <c:if test="${status.count%4 == 0 }">
				       
				       <tr>
				        <td height="10"></td>
				       </tr>
				       </c:if>
				  		
</c:forEach>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
    