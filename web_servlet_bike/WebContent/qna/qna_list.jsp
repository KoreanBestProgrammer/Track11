<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>

 <c:if test="${empty sessionId}">
 	<script>
		alert("회원 외 입장불가!");
		location.href="Index";
 	</script>
 </c:if>

	<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
<script>
	function goWriteForm(){
		qna.t_gubun.value="qnawriteform";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	function goSearch(){
		search.method="post";
		search.action="Qna";
		search.submit();
	}
	function goPage(curpage){
		search.t_nowPage.value=curpage;
		search.method="post";
		search.action="Qna";
		search.submit();
	}
	function goView(no){
		qna.t_gubun.value="qnaview";
		qna.t_no.value=no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
</script>	

<style>	
	.complet {background:#8893ab; color:#fff;padding:5px 8px;}
	.waiting {background:#0489B1; color:#fff;padding:5px 8px;}
</style>

		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>			
			<form name="qna">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
			</form>
			<form name="search">
				<input type="hidden" name="t_nowPage">
				
				<p class="select_box select_box_right" style="width:500px;">
					<input type="radio" value="5" name="t_count" class="middleCheck" <c:if test="${t_count eq '5'}">checked</c:if>/> 5건        
			    	<input type="radio" value="10" name="t_count" class="middleCheck" <c:if test="${t_count eq '10'}">checked</c:if>/> 10건
			    	<input type="radio" value="15" name="t_count" class="middleCheck" <c:if test="${t_count eq '15'}">checked</c:if>/> 15건
					<select name="t_select" class="sel_box">
						<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if> >제목</option>
						<option value="reg_id" <c:if test="${t_select eq 'reg_id'}">selected</c:if> >ID</option>
					</select>
					<input type="text" name="t_search" value="${t_search}" class="sel_text">
	
					<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
				</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="10%">			
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="20%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>순차</th>
						<th>제목</th>
						<th>첨부파일</th>
						<th>질문자 Id</th>
						<th>질문 등록일</th>
						<th>답변상태</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_arr}" var="dto">
					<tr>
						<td>${number}</td>
						<c:set var="number" value="${number-1}"></c:set>
						<td>
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
						<td>
							<c:if test="${not empty dto.getAttach()}">
								<img src="images/clip.png">
							</c:if>
						</td>
						<td>${dto.getReg_id()}</td>
						<td>${dto.getReg_date()}</td>
						<td>
							<c:choose>
							<c:when test="${not empty dto.getAnswer()}">
								<span class="complet">답변완료</span>					
							</c:when>
							<c:otherwise>
								<span class="waiting">답변대기</span>
							</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			
			<c:if test="${sessionLevel eq 'member'}">
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
			</c:if>	
				
				
			</div>
		</div>	
	</div>
	
	
	
	<%@ include file="../common_footer.jsp" %>
</body>
</html>







