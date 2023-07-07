<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common_header.jsp" %>
<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="Member?t_gubun=memberMyinfo">Member</a></li>
				<li><a href="javascript:goMyorder()"><span class="fnt"><i class="fas fa-apple-alt"></i></span>MY ORDER</a></li>
			</ul>
		</div>
<script>
	function goView(d_no){
		view.t_gubun.value="productmyorderview";
		view.t_d_no.value=d_no;
		view.method="post";
		view.action="Productsale";
		view.submit();
	}
	function goProductView(p_no){
		productView.t_gubun.value="view";
		productView.t_no.value=p_no
		productView.method="post";
		productView.action="Product";
		productView.submit();
	}
	function goList(){
		view.t_gubun.value="myorder";
		view.method="post";
		view.action="Productsale";
		view.submit();
	}
</script>		
<style>
	.img-view{
		width:300px;
		height:300px;
	}

</style>
		<form name="productView">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_no">
		</form>
		<form name="view">
			<input type="hidden" name="t_d_no">
			<input type="hidden" name="t_gubun">
		</form>
		<div id="b_right">
			<p class="n_title">
				구매상세정보
			</p>
			
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
						<td colspan="3">${t_dto.getD_no()}</td>
					</tr>	
					<tr>
						<th>제품번호</th>
						<td colspan="3">${t_dto.getP_no()}</td>
					</tr>
					<tr>
						<th>제품이름</th>
						<td>${t_dto.getProduct_name()}</td>
						<th>제품사진</th>
						<td><a href="javascript:goProductView('${t_dto.getP_no()}')"><img src="attach/product/${t_dto.getProduct_photo()}" class="img-view"></a></td>
					</tr>
					<tr>
						<th>제품가격</th>
						<td colspan="3">${t_dto.getPrice()}</td>
					</tr>
					<tr>
						<th>주문자정보</th>
						<th>
							<p>ID</p>
							<p>E-mail</p>
							<p>Address</p>
						</th>
						<td colspan="2">
							<p>${t_dto.getC_id()}</p>
							<p>${t_dto.getD_email()}</p>
							<p>${t_dto.getD_address()}</p>
						</td>
					</tr>
					<tr>
						<th>배송상태</th>
						<td colspan="3">${t_dto.getD_state()}</td>
					</tr>	
					<tr>
						<th>주문일</th>
						<td>${t_dto.getPurchase_date()}</td>
						<th>배송완료일</th>
						<td>${t_dto.getD_date()}</td>
					</tr>	

				</tbody>
			</table>
			<div class="preNext">
			<c:if test="${not empty t_preD_no}">
				<a href="javascript:goView('${t_preD_no}')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
								이전구매내역	
						</span>
					</p>
				</a>
			</c:if>
			<c:if test="${not empty t_nextD_no}">	
				<a href="javascript:goView('${t_nextD_no}')">
					<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<span class="preNextTitle">
								다음구매내역	
						</span>
					</p>
				</a>
			</c:if>	
			</div>			
			<div class="buttonGroup">
				
				<a href="javascript:goList()" class="butt">List</a>
				
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    