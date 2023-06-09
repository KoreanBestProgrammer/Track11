<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common_header.jsp" %>
<div id="b_left">
			<P>PRODUCT</P>
			<ul>
			   	<li><a href="Product"><span class="fnt"><i class="fas fa-apple-alt"></i></span>Product</a></li>
		   </ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				구매한다
			</p>
<script>
	function goPurchase(){
		if(checkValue(purchase.t_email,"이메일 주소를 입력하세요")) return;	
		if(checkValue(purchase.t_address,"배송지를 입력하세요")) return;
		if(checkValue(purchase.t_purchaseway,"지불방법을 선택하세요")) return;
		
		
		
		purchase.t_gubun.value="purchase";
		purchase.method="post";
		purchase.action="Productsale";
		purchase.submit();
	}

</script>			
			
<style>
	.img-view{
		width:300px;
		height:300px;
	}
	input:focus {outline: none;}
</style>

			<form name="purchase">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_state" value="입금확인중">
			<table class="boardForm">
				<colgroup>
					<col width="25%">
					<col width="45%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>제품이름</th>
						<td><input type="text" style=border:none readonly value="${t_dto.getProduct_name()}"></td>
						<td colspan="2">
							<img src="attach/product/${t_dto.getProduct_photo()}" class="img-view">
						</td>
					</tr>	
					<tr>
						<th>제품번호</th>
						<td colspan="3"><input type="text" name="t_no" style=border:none readonly value="${t_dto.getNo()}"></td>
					</tr>	
					<tr>
						<th>구매자</th>
						<td colspan="3"><input type="text" name="t_customerid" style=border:none readonly value="${sessionId}"></td>
					</tr>	
					<tr>
						<th>이메일 주소</th>
						<td colspan="3"><input type="text" name="t_email" value="" size="50"></td>
					</tr>	
					<tr>
						<th>배송지</th>
						<td colspan="3"><input type="text" name="t_address" value="" size="50"></td>
					</tr>	
					<tr>
						<th>가격</th>
						<td colspan="3"><input type="text" name="t_price" style=border:none readonly value="${t_dto.getProduct_price()}"></td>
					</tr>	
					<tr>
						<th>지불방법</th>
						<td colspan="3">
							<input type="radio" value="카드" name="t_purchaseway" class="middleCheck" /> 카드&nbsp;&nbsp;        
					  		<input type="radio" value="무통장입금" name="t_purchaseway" class="middleCheck" /> 무통장입금&nbsp;&nbsp;신한 110468438898 예금주:김용석
					  	</td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goPurchase()" class="butt">구매</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    