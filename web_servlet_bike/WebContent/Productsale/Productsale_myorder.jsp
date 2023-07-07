<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    
	<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="Member?t_gubun=memberMyinfo">Member</a></li>
				<li><a href="javascript:goMyorder()"><span class="fnt"><i class="fas fa-apple-alt"></i></span>MY ORDER</a></li>
			</ul>
		</div>
		<script>
			function goSearch(){
					orderList.t_gubun.value="myorder";
					orderList.method="post";
					orderList.action="Productsale";
					orderList.submit();
			}
			function goPage(curpage){
					orderList.t_gubun.value="myorder";
					orderList.t_nowPage.value=curpage;
					orderList.method="post";
					orderList.action="Productsale";
					orderList.submit();
			}
			function goView(d_no){
				view.t_gubun.value="productmyorderview";
				view.t_d_no.value=d_no;
				view.method="post";
				view.aciton="Productsale";
				view.submit();
			}
		</script>
		<style>
			.img-view{
				width:100px;
				height:100px;
			}
		</style>
		<div id="b_right">
			<p class="n_title">
				구매이력
			</p>
			<form name="view">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_d_no">
			</form>
			<form name="orderList">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_nowPage">
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 구매내역<span>${t_totalCount}</span>건</p>
			</div>			
		 		<p class="counter">  
		 			<input type="radio" value="5" name="t_count" class="middleCheck" <c:if test="${t_count eq '5'}">checked</c:if>/> 5건        
			    	<input type="radio" value="10" name="t_count" class="middleCheck" <c:if test="${t_count eq '10'}">checked</c:if>/> 10건
			    	<input type="radio" value="15" name="t_count" class="middleCheck" <c:if test="${t_count eq '15'}">checked</c:if>/> 15건
			    	<input type="radio" value="20" name="t_count" class="middleCheck" <c:if test="${t_count eq '20'}">checked</c:if>/> 20건
				</p>
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="a.d_no" <c:if test="${t_select eq 'a.d_no'}">selected</c:if> >주문번호</option>
					<option value="b.product_name" <c:if test="${t_select eq 'b.product_name'}">selected</c:if> >제품명</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()"  class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="12%">
					<col width="13%">
					<col width="15%">
					<col width="25%">
					<col width="10%">
					<col width="20%">
					
				</colgroup>
				<thead>
					
						<tr>
							<th>NO</th>
							<th>사진</th>
							<th>주문번호</th>
							<th>제품번호</th>
							<th>제품명</th>
							<th>구매자</th>
							<th>구매 날짜</th>
						</tr>
					
				</thead>
				<tbody>
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_arr}" var="dto">
					<tr>
						<td>${number}</td>
							<c:set var="number" value="${number-1}"></c:set>
						<td><a href="javascript:goView('${dto.getD_no()}')"><img src="attach/product/${dto.getProduct_photo()}" class="img-view"></a></td>
						<td class="t_left"><a href="javascript:goView('${dto.getD_no()}')">${dto.getD_no()}</a></td>
						<td><a href="javascript:goView('${dto.getD_no()}')">${dto.getP_no()}</a></td>
						<td>${dto.getProduct_name()}</td>
						<td>${dto.getC_id()}</td>
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






