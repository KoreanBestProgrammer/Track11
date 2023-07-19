<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    
<div id="b_left">
			<%@ include file = "../common_menu.jsp" %>
		</div>
<script>
	function goWriteForm(){
		free.t_gubun.value="writeform";
		free.method="post";
		free.action="Freeboard";
		free.submit();
	}
	function goSearch(){
		search.method="post";
		search.action="Freeboard";
		search.submit();
	}
	function goPage(curpage){
		search.t_nowPage.value=curpage;
		search.method="post";
		search.action="Freeboard";
		search.submit();
	}
	function goView(no){
		free.t_gubun.value="view";
		free.t_no.value=no;
		free.method="post";
		free.action="Freeboard";
		free.submit();
	}
</script>	
<style>	
	.complet {background:#0489B1; color:#fff;padding:5px 8px;}
	.waiting {background:#8893ab; color:#fff;padding:5px 8px;}
</style>	
		<div id="b_right">
			<p class="n_title">
				FREE BOARD
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			
			<form name="free">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
			</form>
			
			<form name="search">	
			<input type="hidden" name="t_nowPage">
				<p class="select_box select_box_right">
					<select name="t_count" class="sel_box">
						<option value="5" <c:if test="${t_count eq '5'}">selected</c:if>>5건</option>
						<option value="10" <c:if test="${t_count eq '10'}">selected</c:if>>10건</option>
						<option value="15" <c:if test="${t_count eq '15'}">selected</c:if>>15건</option>
					</select>
					<select name="t_select" class="sel_box">
						<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if>>제목</option>
						<option value="reg_name" <c:if test="${t_select eq 'reg_name'}">selected</c:if>>유저이름</option>
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
					<col width="20%">
					<col width="15%">
					<col width="5%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
						<th>공개여부</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_arr}" var="dto">
					<tr>
						<td>${number}</td>
						<c:set var="number" value="${number-1}"></c:set>
						
						
						<td>
						<c:choose>
							<c:when test="${dto.getOpen() eq 'n'}">
								<c:choose>
									<c:when test="${sessionId eq dto.getReg_id() || sessionLevel eq 'admin'}">
										<a href="javascript:goView('${dto.getNo()}')">
											<c:choose>
												<c:when test="${fn:length(dto.getTitle()) > 20}">
													${fn:substring(dto.getTitle(),0,20)}.....
												</c:when>	
												<c:otherwise>
													${dto.getTitle()}
												</c:otherwise>
											</c:choose>
										</a>
									</c:when>
									<c:otherwise>
											<c:choose>
												<c:when test="${fn:length(dto.getTitle()) > 20}">
													${fn:substring(dto.getTitle(),0,20)}.....
												</c:when>	
												<c:otherwise>
													${dto.getTitle()}
												</c:otherwise>
											</c:choose>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
									<a href="javascript:goView('${dto.getNo()}')">
										<c:choose>
											<c:when test="${fn:length(dto.getTitle()) > 20}">
												${fn:substring(dto.getTitle(),0,20)}.....
											</c:when>	
											<c:otherwise>
												${dto.getTitle()}
											</c:otherwise>
										</c:choose>
									</a>
							</c:otherwise>
						</c:choose>
						</td>
						
					
						<td>
						<c:if test="${not empty dto.getAttach()}">
							<img src="images/clip.png">
						</c:if>
						</td>
						<td>${dto.getReg_name()}</td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getHit()}</td>
						<td>
						<c:choose>
						<c:when test="${dto.getOpen() eq 'y'}">
							<span class="complet">공개글</span>
						</c:when>
						<c:otherwise>
							<span class="waiting">비공개글</span>
						</c:otherwise>
						</c:choose>
						</td>
					</tr>	
				</c:forEach>	
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
			</div>
		</div>	
	</div>
	
<%@ include file = "../common_footer.jsp" %>	
</body>
</html>






    