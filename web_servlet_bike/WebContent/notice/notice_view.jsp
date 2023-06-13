<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>    

		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		<script>
			function goView(no){
				notice.t_gubun.value="view";
				notice.t_no.value=no;
				notice.method="post";
				notice.action="Notice";
				notice.submit();
			}
			function goUpdateForm(no){
				notice.t_gubun.value="updateForm";
				notice.t_no.value=no;
				notice.method="post";
				notice.action="Notice";
				notice.submit();
			}
			function goDelete(no){
				notice.t_gubun.value="delete";
				notice.t_no.value=no;
				notice.method="post";
				notice.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="notice">
				<input type="hidden" name="t_gubun" >
				<input type="hidden" name="t_no">
				<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">
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
						<th>Title</th>
						<td colspan="2">${t_dto.getTitle()}</td>
						<td> <i class="far fa-eye"></i>${t_dto.getHit()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
								<a href="FileDown?t_fileDir=notice&t_fileName=${t_dto.getAttach()}">${t_dto.getAttach()}</a>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	

				</tbody>
			</table>
			<div class="preNext">
			<c:if test="${not empty t_preDto}">
					<a href="javascript:goView('${t_preDto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
							<span class="preNextTitle">
									<!--  	${t_preDto.getTitle()}
										=${fn:length(t_preDto.getTitle())}=
										<c:if test="${fn:length(t_preDto.getTitle()) > 5}">
											${fn:substring(t_preDto.getTitle(),0,5)}...
										</c:if>
									-->	
										<c:choose>
											<c:when test="${fn:length(t_preDto.getTitle()) > 5}">
												${fn:substring(t_preDto.getTitle(),0,5)}...
											</c:when>
											<c:otherwise>
												${t_preDto.getTitle()}
											</c:otherwise>
										</c:choose>
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${not empty t_nextDto}"> <!-- jstl방식으로는 'null이 아닐때'를 '공백이 아닐때'로 표현해줌 -->
					<a href="javascript:goView('${t_nextDto.getNo()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
							<span class="preNextTitle">
										<!-- ${t_nextDto.getTitle()} -->
										<c:choose>
											<c:when test="${fn:length(t_nextDto.getTitle()) > 5}">
												${fn:substring(t_nextDto.getTitle(),0,5)}...
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
				<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				<a href="Notice" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    