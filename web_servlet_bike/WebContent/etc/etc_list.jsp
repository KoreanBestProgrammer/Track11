<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>
		<div id="b_left">
			<%@ include file = "../common_menu.jsp" %>
		</div>
<script>
	function goWriteForm(){
		etc.t_gubun.value="writeform";
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	function goSearch(){
		list.method="post";
		list.action="Etc";
		list.submit();
	}
	function goPage(curPage){
		list.t_nowPage.value=curPage;
		list.method="post";
		list.action="Etc";
		list.submit();
	}
	function goView(no){
		etc.t_gubun.value="view";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
</script>		
		<div id="b_right">
			<p class="n_title">
				ETC
			</p>
			<form name="etc">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
 			</form>
			
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			<form name="list">
			<input type="hidden" name="t_nowPage">
				<p class="select_box select_box_right">
					<select name="t_count" class="sel_box" onchange="goSearch()">
						<option value="5" <c:if test="${t_count eq '5'}">selected</c:if> >5건</option>
						<option value="10" <c:if test="${t_count eq '10'}">selected</c:if> >10건</option>
						<option value="15" <c:if test="${t_count eq '15'}">selected</c:if> >15건</option>
						<option value="20" <c:if test="${t_count eq '20'}">selected</c:if> >20건</option>
					</select>
					<select name="t_select" class="sel_box">
						<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if> >제목</option>
						<option value="reg_name" <c:if test="${t_select eq 'reg_name'}">selected</c:if> >이름</option>
					</select>
					<input type="text" name="t_search" value="${t_search}" class="sel_text">
				
					<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
				</p>		
			</form>
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="50%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th></th>
						<th>제목</th>
						<th>등록자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_arr}" var="dto">
					<tr>
						<td>${number}</td>
						<c:set var="number" value="${number-1}"></c:set>
						<td class="t_left">
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
						</td>
						<td>${dto.getReg_name()}</td>
						<td>${dto.getReg_date()}</td>
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






    