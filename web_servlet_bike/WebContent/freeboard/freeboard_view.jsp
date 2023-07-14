<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>    
<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
<script>
	function goView(no){
		free.t_no.value=no;
		free.t_gubun.value="view";
		free.method="post";
		free.action="Freeboard";
		free.submit();
	}
	function goUpdateForm(no){
		free.t_gubun.value = "updateform";
		free.t_no.value=no;
		free.method="post";
		free.action="Freeboard";
		free.submit();
	}
	function goDelete(no){
		if(confirm("정말 삭제하시겠습니까?")){
			free.t_gubun.value="delete";
			free.t_no.value=no;
			free.method="post";
			free.action="Freeboard";
			free.submit();
		}
	}
</script>		
		<div id="b_right">
			<p class="n_title">
				FREE BOARD
			</p>
		<form name="free">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_attachName" value="${t_dto.getAttach()}">
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
						<th>제목</th>
						<td colspan="2">${t_dto.getTitle()}</td>
						<td> <i class="far fa-eye"></i>${t_dto.getHit()}</td>
					</tr>	
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>
	<style>
		.img-view{
			width:200px;
			height:200px;
		}
	</style>	
				<c:if test="${not empty t_dto.getAttach()}">			
					<tr>
						<th>첨부</th>
						<td colspan="3">
						<c:choose>
							<c:when test="${not empty t_extension}">
								<a href="FileDown?t_fileDir=freeboard&t_fileName=${t_dto.getAttach()}">
								<img src = "attach/freeboard/${t_dto.getAttach()}" class="img-view">
								${t_dto.getAttach()}
								</a>
							</c:when>
							<c:otherwise>
								<a href="FileDown?t_fileDir=freeboard&t_fileName=${t_dto.getAttach()}">
									${t_dto.getAttach()}
								</a>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:if>			
					<tr>
						<th>글쓴이</th>
						<td>${t_dto.getReg_name()}</td>
						<th>등록일</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
					<c:if test="${not empty t_dto.getUpdate_date()}">
						<tr>
							<th>수정일</th>
							<td colspan="3">${t_dto.getUpdate_date()}</td>
						</tr>	
					</c:if>
				</tbody>
			</table>
			<div class="preNext">
			<c:if test="${not empty t_preDto}">
				<a href="javascript:goView('${t_preDto.getNo()}')">
					<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
						<span class="preNextTitle">
									<c:choose>
										<c:when test="${fn:length(t_preDto.getTitle()) > 10}">
											${fn:substring(t_preDto.getTitle(),0,10)}.....
										</c:when>
										<c:otherwise>
											${t_preDto.getTitle()}
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
										<c:when test="${fn:length(t_nextDto.getTitle()) > 10}">
											${fn:substring(t_nextDto.getTitle(),0,10)}.....
										</c:when>
										<c:otherwise>
											${t_nextDto.getTitle()}
										</c:otherwise>	
									</c:choose>
						</span>
					</p>
				</a>
			</c:if>
			</div>			
			<div class="buttonGroup">
			<c:if test="${sessionId eq t_dto.getReg_id() || sessionLevel eq 'admin'}">
				<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
			</c:if>	
			<c:if test="${sessionId eq t_dto.getReg_id()}">
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
			</c:if>		
				<a href="Freeboard" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    