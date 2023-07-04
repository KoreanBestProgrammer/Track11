<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../common_header.jsp" %>
    
    <c:if test="${sessionLevel ne 'admin'}">
    	<script>
    		alert("관리자만 입장가능!");
    		location.href="Index";
    	</script>
    </c:if>
    
    
    <div id="b_left">
			<%@ include file = "../common_menu_admin.jsp" %>
		</div>
		<script>
			function goSearch(){
				product.t_gubun.value="productadmin";
				product.method="post";
				product.action="Productsale";
				product.submit();
			}
			function goPage(curPage){
				product.t_gubun.value="productadmin";
				product.t_nowPage.value = curPage;
				product.method="post";
				product.action="Productsale";
				product.submit();
			}
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
			<form name="product">
			<input type="hidden" name="t_nowPage">
			<input type="hidden" name="t_gubun">
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>			
				<select name="t_count" class="sel_box" onchange="goSearch()">
					<option value="5" <c:if test="${t_count eq '5'}">selected</c:if> >5</option>
					<option value="10" <c:if test="${t_count eq '10'}">selected</c:if> >10</option>
					<option value="15" <c:if test="${t_count eq '15'}">selected</c:if> >15</option>
				</select>
			<p class="select_box select_box_right">
				
				<select name="t_select_state" class="sel_box">
					<option value="" <c:if test="${t_state eq ''}">selected</c:if> >배송상태</option>
					<option value="배송중" <c:if test="${t_state eq '배송중'}">selected</c:if> >배송중</option>
					<option value="입금확인중" <c:if test="${t_state eq '입금확인중'}">selected</c:if> >입금확인중</option>
				</select>
				
				<select name="t_select" class="sel_box">
					<option value="d_no" <c:if test="${t_select eq 'd_no'}">selected</c:if> >주문번호</option>
					<option value="p_no" <c:if test="${t_select eq 'p_no'}">selected</c:if> >제품번호</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="35%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="30%">
					
				</colgroup>
				<thead>
					
						<tr>
							<th>NO</th>
							<th>주문번호</th>
							<th>제품번호</th>
							<th>구매자</th>
							<th>배송상태</th>
							<th>구매 날짜</th>
						</tr>
					
				</thead>
				<tbody>
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_arr}" var="dto">
					<tr>
						<td>${number}</td>
							<c:set var="number" value="${number-1}"></c:set>
						<td><a href="javascript:goView('${dto.getD_no()}')">${dto.getD_no()}</a></td>
						<td class="t_left">${dto.getP_no()}</td>
						<td>${dto.getC_id()}</td>
						<td>${dto.getD_state()}</td>
						<td>${dto.getPurchase_date()}</td>
					</tr>	
				</c:forEach>
				</tbody>
			</table>
			<div class="paging">
				${t_paging}
			</div>
		</div>	
	</div>
<%@ include file = "../common_footer.jsp" %>	
</body>
</html>






    