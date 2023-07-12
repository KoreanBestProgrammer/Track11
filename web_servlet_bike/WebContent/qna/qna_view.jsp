<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
<script>
	function goUpdateForm(no){
		qna.t_gubun.value="qnaupdateform";
		qna.t_no.value=no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	function goDelete(no){
		if(confirm("정말 삭제하시겠습니까?")){
			qna.t_gubun.value="qnadelete";
			qna.t_no.value=no;
			qna.method="post";
			qna.action="Qna";
			qna.submit();
		}
	}
	function goAnswerForm(no){
		qna.t_gubun.value="answerform";
		qna.t_no.value=no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	function goAnswerDelete(no){
		if(confirm("정말 삭제하시겠습니까?")){
			qna.t_gubun.value="qnaanswerdelete";
			qna.t_no.value=no;
			qna.method="post";
			qna.action="Qna";
			qna.submit();
		}
	}	
	function goAnswerUpdate(){
		$.ajax({
			type : "POST",     //어떤방식으로 넘길거냐
			url : "QnaAnswerUpdate",
			//url이 실행되면서 url의 소스(브라우저에 찍힌 소스)가 data라는 변수 안에 들어감.
			data: "t_no="+change.t_no.value+"&t_answer="+change.t_answer.value, //t_id = url에 넘어갈 변수(mem.t_id.value를 t_id라는 변수에 담아서 url에 넘긴다 )
			dataType : "text",      //결과를 글자로 받겠다
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				alert("수정하시겠습니까?");
				var result = $.trim(data); // $.trim() : 여백을 지움
				var len = result.length;
				var answer_update_date = result.substring(0,19);
				var answer = result.substring(19,len);
				change.t_answer_update_date.value = answer_update_date;
				change.t_answer.value = answer;
				alert("수정성공!");
				
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
	.img-view{
		width:300px;
		height:300px;
	}
</style>
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<form name="qna">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
				<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">
			</form>
			<form name="change">	
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="50%">
					<col width="15%">
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
						
				<c:if test="${not empty t_dto.getAttach()}">
					<tr>
						<th>첨부</th>
						<td colspan="3">
						<c:choose>
							<c:when test="${not empty t_extension}">
								<img src="attach/qna/${t_dto.getAttach()}" class="img-view">
							</c:when>
							<c:otherwise>
								${t_dto.getAttach()}
							</c:otherwise>
						</c:choose>	
						</td>
					</tr>	
				</c:if>		
					<tr>
						<th>등록자</th>
						<td>${t_dto.getReg_id()}</td>
						<th>등록일</th>
						<td colspan="3">${t_dto.getReg_date()}</td>
					</tr>	
				<c:if test="${not empty t_dto.getUpdate_date()}">	
					<tr>
						<th>질문수정일</th>
						<td colspan="3">${t_dto.getUpdate_date()}</td>
					</tr>	
				</c:if>	
			<c:choose>		
				<c:when test="${not empty t_dto.getAnswer()}">	
					<tr>
						<th>답변자</th>
						<td colspan="3">
							${t_dto.getAnswer_id()}
						</td>
					</tr>
					<tr>				
						<th>관리자 답변</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" name="t_answer" style="resize:none;">${t_dto.getAnswer()}</textarea>
						</td>	
					</tr>
					<tr>
						<th>답변일</th>
						<td>
							${t_dto.getAnswer_date()}
						</td>
						<th>답변수정일</th>
						<td>
							<input type="text" name="t_answer_update_date" value="${t_dto.getAdmin_update_date()}" style="border:none">
						</td>
					</tr>
				</c:when>	
				<c:otherwise>
				<tr>
					<th>관리자 답변</th>																											
					<td colspan="3">
						<textarea class="textArea_H250_noBorder" disabled style="resize:none;">관리자의 답변을 기다려주세요.</textarea>
					</td>	
				</tr>	
				</c:otherwise>
			</c:choose>	
				</tbody>
			</table>
			</form>		
			<div class="buttonGroup">
			
			    <c:if test="${sessionId eq t_dto.getReg_id() && empty t_dto.getAnswer()}">
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">질문삭제</a>
					<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">질문수정</a>
				</c:if>
				
				<c:if test="${sessionLevel eq 'admin' && empty t_dto.getAnswer()}">
					<a href="javascript:goAnswerForm('${t_dto.getNo()}')" class="butt">답변달기</a>
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">질문삭제</a>
				</c:if>
				<c:if test="${sessionLevel eq 'admin' && not empty t_dto.getAnswer()}">
					<a href="javascript:goAnswerDelete('${t_dto.getNo()}')" class="butt">답변삭제</a>
					<a href="javascript:goAnswerUpdate()" class="butt">답변수정</a>
					<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">질문삭제</a>
				</c:if>
				
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    