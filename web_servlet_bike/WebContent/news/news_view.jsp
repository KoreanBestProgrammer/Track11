<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>
       <div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		<script>
			function goView(no){
				news.t_gubun.value="view";
				news.t_no.value=no;
				news.method="post";
				news.action="News";
				news.submit();
			}
			function goUpdateForm(no){
				news.t_gubun.value="updateForm";
				news.t_no.value=no;
				news.method="post";
				news.action="News";
				news.submit();
			}
			function goDelete(no){
				if(confirm("정말 삭제하시겠습니까?")){
					news.t_gubun.value="delete";
					news.t_no.value=no;
					news.method="post";
					news.action="News";
					news.submit();
				}
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				VIEW
			</p>
			<form name="news">
				<input type="hidden" name="t_gubun">
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
						<td> <i class="far fa-eye"></i> ${t_dto.getHit()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>
<style>
		.ViewImg{
			width:500px;
			height:300px;
			
		}
		.imgDiv{
			width:500px;
			height:300px;
			padding:10px;
			border:1px solid gray;
			margin: 10px 90px;
		}
</style>									
					<tr>
					<c:if test="${not empty t_dto.getAttach()}">
						<th>사진 미리보기</th>
						<td colspan="3">	
							<div class="imgDiv">
								<img src="attach/news/${t_dto.getAttach()}" class="ViewImg">
							</div>		
						</td>
					</c:if>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
							<a href="FileDown?t_fileDir=news&t_fileName=${t_dto.getAttach()}">${t_dto.getAttach()}</a>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getName()}</td>
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
								<c:choose>
									<c:when test="${fn:length(t_preDto.getTitle()) > 10}">
										${fn:substring(t_preDto.getTitle(),0,5)}.....
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
											${fn:substring(t_nextDto.getTitle(),0,5)}.....
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
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goDelete('${t_dto.getNo()}')" class="butt">Delete</a>
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
			</c:if>	
				<a href="News" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>

    