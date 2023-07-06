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
//	function goChange(){
//		change.method="post";
//		change.action="Productsale";
//		change.submit();
//	}
	function goChange(){
		
		$.ajax({
			type : "POST",     //어떤방식으로 넘길거냐
			url : "ProductStateUpdate",
			//url이 실행되면서 url의 소스(브라우저에 찍힌 소스)가 data라는 변수 안에 들어감.
			data: "t_d_no="+change.t_d_no.value+"&t_select_state="+change.t_select_state.value, //t_id = url에 넘어갈 변수(mem.t_id.value를 t_id라는 변수에 담아서 url에 넘긴다 )
			dataType : "text",      //결과를 글자로 받겠다
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				var result = $.trim(data); // $.trim() : 여백을 지움
				var num = result.indexOf("*");
				var len = result.length;
				var date = result.substring(0,num);
				var state = result.substring(num+1,len);
				change.t_d_date.value = date;
				change.t_d_state.value = state;
				
			//	if(result == "사용가능"){
			//	join.t_idCheckValue.value = join.t_id.value;
			//	} else{
			//		join.t_idCheckValue.value = "";
			//	}
				
			}
		});				
	}
</script>
		<style>
			.view-img{
				width:300px;
				height:300px;
			}
		</style>		
		<div id="b_right">
			<p class="n_title">
				판매내역
			</p>
			<form name="view">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_d_no">
			</form>
			<form name="change">
				<input type="hidden" name="t_gubun" value="updatestate">
				<input type="hidden" name="t_d_no" value="${t_dto.getD_no()}">
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
						<th>제품명</th>
						<td>${t_dto.getProduct_name()}</td>
						<td colspan="2">
							<img src="attach/product/${t_dto.getProduct_photo()}" class="view-img">
						</td>
					</tr>
					<tr>
						<th>제품가격</th>
						<td colspan="3">${t_dto.getPrice()}</td>
					</tr>
					<tr>
						<th>구매방법</th>
						<td colspan="3">${t_dto.getPurchase_way()}</td>
					</tr>
					
					
					<tr>
						<th>주문상태</th>
						<td><input type="text" name="t_d_state" value="${t_dto.getD_state()}" style="border:none"></td>
						<td colspan="2"><input type="button" onclick="goChange()" value="상태변경">
						<select name="t_select_state" class="sel_box">
							<option value="입금확인" <c:if test="${t_dto.getD_state() eq '입금확인'}">selected</c:if> >입금확인</option>
							<option value="배송준비중" <c:if test="${t_dto.getD_state() eq '배송준비중'}">selected</c:if> >배송준비중</option>
							<option value="배송중" <c:if test="${t_dto.getD_state() eq '배송중'}">selected</c:if> >배송중</option>
							<option value="배송완료" <c:if test="${t_dto.getD_state() eq '배송완료'}">selected</c:if> >배송완료</option>
						</select>
						</td>
					</tr>	
					
					<tr>
						<th>구매자ID</th>
						<td>${t_dto.getC_id()}</td>
						<th>구매일자</th>
						<td>${t_dto.getPurchase_date()}</td>
					</tr>
					<tr>
						<th>구매자 이메일</th>
						<td>${t_dto.getD_email()}</td>
						<th>구매자 주소</th>
						<td>${t_dto.getD_address()}</td>
					</tr>		
					<tr>
						<th>배송완료일</th>
						<td>${t_dto.getD_date()}</td>
						<th>배송완료일</th>
						<td><input type="text" name="t_d_date" value="${t_dto.getD_date()}" style="border:none"></td>
					</tr>		
				</tbody>
			</table>
			</form>
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
				<a href="Productsale" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    