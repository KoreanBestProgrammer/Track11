<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../common_header.jsp" %>
    
    
<div id="b_left">

		<c:choose>
			<c:when test="${sessionLevel eq 'admin'}">	
				<%@ include file = "../common_menu_admin.jsp" %>
			</c:when>	
			<c:otherwise>
				<%@ include file="../common_menu_product.jsp" %>
			</c:otherwise>
		</c:choose>
		
		</div>
		<script>
			function goWriteForm(){
				product.t_gubun.value="writeForm";
				product.method="post";
				product.action="Product";
				product.submit();
			}
			function goSearch(){
				list.method="post";
				list.action="Product";
				list.submit();
			}
			function goPage(curpage){
				list.t_nowPage.value=curpage;
				list.method="post";
				list.action="Product";
				list.submit();
			}
			function goView(no){
				product.t_gubun.value="view";
				product.t_no.value=no;
				product.method="post";
				product.action="Product";
				product.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			<form name="product">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
			</form>	
			<form name="list">	
			<input type="hidden" name="t_nowPage">
				<select name="t_productLevel" class="sel_box">
					<option value="" <c:if test="${t_productLevel eq ''}">selected</c:if>>제품우선순위</option>
					<option value="1" <c:if test="${t_productLevel eq '1'}">selected</c:if>>1</option>
					<option value="2" <c:if test="${t_productLevel eq '2'}">selected</c:if>>2</option>
					<option value="3" <c:if test="${t_productLevel eq '3'}">selected</c:if>>3</option>
				</select>
			<p class="select_box select_box_right">
				
				<select name="t_select" class="sel_box">
					<option value="no" <c:if test="${t_select eq 'no'}">selected</c:if>>제품번호</option>
					<option value="product_name" <c:if test="${t_select eq 'product_name'}">selected</c:if>>제품명</option>
				</select>
				<select name="t_displayCount" class="sel_box" onchange="goSearch()">
					<option value="5" <c:if test="${t_count eq '5'}">selected</c:if>>5</option>
					<option value="10" <c:if test="${t_count eq '10'}">selected</c:if>>10</option>
					<option value="15" <c:if test="${t_count eq '15'}">selected</c:if>>15</option>
					<option value="20" <c:if test="${t_count eq '20'}">selected</c:if>>20</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">
			
				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
				</form>
			</p>			
			
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="30%">
					<col width="30%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>제품번호</th>
						<th>사진</th>
						<th>제품명</th>
						<th>가격</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
	<style>
		.img{
			width:100px;
			height:100px;
		}
	</style>
				<c:set var="number" value="${t_order}"></c:set>
					<c:forEach items="${t_arr}" var="dto">
						<tr>
							<td>
								${number}
								<c:set var="number" value="${number-1}"></c:set>
							</td>
							<td><a href="javascript:goView('${dto.getNo()}')">${dto.getNo()}</a></td>
							<td class="t_left">
								<a href="javascript:goView('${dto.getNo()}')"><img src="attach/product/${dto.getProduct_photo()}" class="img"></a>
							</td>
							<td>${dto.getProduct_name()}</td>
							<td>${dto.getReg_date()}</td>
							<td>${dto.getHit()}</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			
			 <div class="paging">
			 ${t_paging}
			 
			<!-- 	<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
			 	<a href=""><i class="fa fa-angle-double-right"></i></a>
			  -->	
				<c:if test="${sessionLevel eq 'admin'}">
					<a href="javascript:goWriteForm()" class="write">글쓰기</a>
				</c:if>
			</div>
		</div>	
	</div>
	
	
	
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    