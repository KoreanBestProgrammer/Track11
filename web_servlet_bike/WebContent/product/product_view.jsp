<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common_header.jsp" %>
   
    <script>
    	function goView(no){
    		view.t_gubun.value="view";
    		view.t_no.value=no;
    		view.method="post";
    		view.action="Product";
    		view.submit();
    	}
    	function goUpdateForm(no){
    		view.t_no.value=no;
    		view.t_gubun.value="updateForm";
    		view.method="post";
    		view.action="Product";
    		view.submit();
    	}
    	function goDelete(no){
    		if(confirm("정말 삭제하시겠습니까?")){
	    		view.t_gubun.value="delete";
	    		view.t_no.value=no;
	    		view.method="post";
	    		view.action="Product";
	    		view.submit();
    		}
    	}
    	
    </script>
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
		
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<form name="view">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
				<input type="hidden" name="t_nowAttach" value="${t_dto.getProduct_photo()}">
			</form>
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>제품번호</th>
						<td colspan="2">${t_dto.getNo()}</td>
						<td><i class="far fa-eye">${t_dto.getHit()}</i></td>
					</tr>	
					<tr>
						<th>제품명</th>
						<td colspan="3">${t_dto.getProduct_name()}</td>
						
					</tr>
					<tr>
						<th>제품순위</th>
						<td colspan="3">${t_dto.getRanking()}</td>
						
					</tr>		
					<tr>
						<th>제품가격</th>
						<td colspan="3">${t_dto.getProduct_price()}</td>
					
					</tr>	
					<tr>
						<th>제품크기</th>
						<td colspan="3">${t_dto.getProduct_size()}</td>
						
					</tr>
					<tr>
						<th>제품설명</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getProduct_explain()}</textarea>
						</td>
					</tr>	
		<style>
			.view-img{
				width:300px;
				height:300px;
			}
		
		</style>				
					<tr>
						<th>Attach</th>
						<td colspan="3">
							<img src="attach/product/${t_dto.getProduct_photo()}" class="view-img">
						</td>
					</tr>	
					<tr>
						<th>등록자</th>
						<td>${sessionName}</td>
						<th>등록일</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>
					<tr>
						<th>수정일</th>
						<td colspan="3">${t_dto.getUpdate_date()}</td>
					</tr>		

				</tbody>
			</table>
			<div class="preNext">
			
			<c:if test="${not empty t_preDto}">
				<a href="javascript:goView('${t_preDto.getNo()}')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
									<c:choose>
										<c:when test="${fn:length(t_preDto.getProduct_name()) > 6}">
											${fn:substring(t_preDto.getProduct_name(),0,4)}.....										
										</c:when>
										<c:otherwise>
											${t_preDto.getProduct_name()}
										</c:otherwise>
									</c:choose>
						</span>
					</p>
				</a>
			</c:if>
			
			<c:if test="${not empty t_nextDto}">	
				<a href="javascript:goView('${t_nextDto.getNo()}')">
					<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
						<span class="preNextTitle">
									<c:choose>
										<c:when test="${fn:length(t_nextDto.getProduct_name()) > 6}">
												${fn:substring(t_nextDto.getProduct_name(),0,4)}.....									
										</c:when>
										<c:otherwise>
											${t_nextDto.getProduct_name()}
										</c:otherwise>
									</c:choose>
						</span>
					</p>
				</a>
			</c:if>	
			
			</div>			
			<div class="buttonGroup">
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
			</c:if>	
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    