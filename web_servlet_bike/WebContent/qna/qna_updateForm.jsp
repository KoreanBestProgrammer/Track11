<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>   
<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
<script>
	function goUpdate(no){
		if(checkValue(qna.t_title,"제목을 입력하세요")) return;
		if(checkValue(qna.t_content,"내용을 입력하세요")) return;
		
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
	/*	var fileName = qna.t_attach.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
			if(extension != "jpg" && extension != "pdf"){
				alert(extension +" 형식 파일은 업로드 안됩니다. PDF,JPG파일만 가능!");
				return;
			}		
		}
	*/	
		
		// 2.첨부 용량 체크	
		var file = qna.t_attach;
		var fileMaxSize  = 10; // 첨부 최대 용량 설정
		if(file.value !=""){
			// 사이즈체크
			var maxSize  = 1024 * 1024 * fileMaxSize;  
			var fileSize = 0;
			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}

			if(fileSize > maxSize){
				alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
				return;
			}	
		}
		
		qna.t_no.value=no;
		qna.method="post";
		qna.action="Qna?t_gubun=qnaupdate";
		qna.submit();
	}
</script>		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<form name="qna" enctype="multipart/form-data">
				<input type="hidden" name="t_no">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title" value="${t_dto.getTitle()}" class="input600"></td>
					</tr>	
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content">${t_dto.getContent()}</textarea></td>
					</tr>
	<style>
		.img-view{
			width:200px;
			height:200px;
		}
	</style>						
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
						<c:if test="${not empty t_dto.getAttach()}">
							<c:choose>
								<c:when test="${not empty t_extension}">
									<img src="attach/qna/${t_dto.getAttach()}" class="img-view">
								</c:when>
								<c:otherwise>
									${t_dto.getAttach()}
								</c:otherwise>
							</c:choose>	
								<input type="hidden" name="t_ori_attach" value="${t_dto.getAttach()}">
								 삭제<input type="checkbox" name="t_deleteCheckAttach" value="${t_dto.getAttach()}"><br>
						</c:if>	
							<input type="file" name="t_attach" class="input600"> 
						 </td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_id()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goUpdate('${t_dto.getNo()}')" class="butt">Save</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    