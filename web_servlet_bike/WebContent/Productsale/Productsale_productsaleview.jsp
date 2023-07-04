<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common_header.jsp" %>
    
     <c:if test="${sessionLevel ne 'admin'}">
    	<script>
    		alert("관리자만 입장가능!");
    		location.href="Index";
    	</script>
    </c:if>
    
<div id="b_left">
			<%@ include file="../common_menu_admin.jsp" %>
		</div>
<script>
	function goView(d_no){
		view.t_gubun.value="productsaleview";
		view.t_d_no.value=d_no;
		view.method="post";
		view.action="Productsale";
		view.submit();
	}

</script>
		<div id="b_right">
			<p class="n_title">
				판매내역
			</p>
			<form name="view">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_d_no">
			</form>
			<table class="boardForm">
				<colgroup>
					<col width="20%">
					<col width="30%">
					<col width="20%">
					<col width="30%">
				</colgroup>
				<tbody>
					<tr>
						<th>주문번호</th>
						<td colspan="2">${t_dto.getD_no()}</td>
					</tr>
					<tr>
						<th>제품번호</th>
						<td colspan="2">${t_dto.getP_no()}</td>
					</tr>
					<tr>
						<th>제품가격</th>
						<td colspan="2">${t_dto.getPrice()}</td>
					</tr>
					<tr>
						<th>구매방법</th>
						<td colspan="2">${t_dto.getPurchase_way()}</td>
					</tr>
					<tr>
						<th>주문상태</th>
						<td colspan="2">${t_dto.getD_state()}</td>
					</tr>	
					<tr>
						<th>구매자ID</th>
						<td>${t_dto.getC_id()}</td>
						<th>구매일자</th>
						<td>${t_dto.getPurchase_date()}</td>
					</tr>
					<tr>
						<th>구매자 이메일 </th>
						<td>${t_dto.getD_email()}</td>
						<th>구매자 주소</th>
						<td>${t_dto.getD_address()}</td>
					</tr>		

				</tbody>
			</table>
			<div class="preNext">
			
			<c:if test="${not empty t_preDto}">
				<a href="javascript:goView('${t_preDto.getD_no()}')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
									<c:choose>
										<c:when test="${fn:length(t_preDto.getD_no()) > 10}">
											${fn:substring(t_preDto.getD_no(),0,9)}.....
										</c:when>
										<c:otherwise>
											${t_preDto.getD_no()}	
										</c:otherwise>
									</c:choose>
						</span>
					</p>
				</a>
			</c:if>	
			
			<c:if test="${not empty t_nextDto}">
				<a href="javascript:goView('${t_nextDto.getD_no()}')">
					<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<span class="preNextTitle">
									<c:choose>
										<c:when test="${fn:length(t_nextDto.getD_no()) > 10}">
											${fn:substring(t_nextDto.getD_no(),0,9)}.....
										</c:when>
										<c:otherwise>
											${t_nextDto.getD_no()}	
										</c:otherwise>
									</c:choose>
						</span>
					</p>
				</a>
			</c:if>
				
			</div>			
			<div class="buttonGroup">
				<a href="" class="butt">Delete</a>
				<a href="notice_update.html" class="butt">Update</a>
				<a href="Productsale" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    