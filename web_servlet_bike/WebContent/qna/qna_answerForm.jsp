<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
<script>
	function goAnswer(no){
		qna.t_gubun.value="answer";
		qna.t_no.value=no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
</script>		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<form name="qna">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
			
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
						<td colspan="3">${t_dto.getTitle()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" disabled style="resize:none;">${t_dto.getContent()}</textarea>
						</td>
					</tr>
	<style>
		.img-view{
			width:300px;
			height:300px;
		}
	</style>					
				<c:if test="${not empty t_dto.getAttach()}">
					<tr>
						<th>첨부사진</th>
						<td colspan="3"><img src="attach/qna/${t_dto.getAttach()}" class="img-view"></td>
					</tr>	
				</c:if>		
					<tr>
						<th>등록자</th>
						<td>${t_dto.getReg_id()}</td>
						<th>등록일</th>
						<td colspan="3">${t_dto.getReg_date()}</td>
					</tr>	
					<tr>
						<th>질문수정일</th>
						<td colspan="3">${t_dto.getUpdate_date()}</td>
					</tr>	
					<tr>
						<th>답변자</th>
						<td colspan="3">
							${sessionName}
						</td>
					</tr>
					<tr>				
						<th>관리자 답변</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" name="t_answer" ></textarea>
						</td>	
					</tr>	
				</tbody>
			</table>
			</form>	
			<div class="buttonGroup">
				
				<a href="javascript:goAnswer('${t_dto.getNo()}')" class="butt">답변등록</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    