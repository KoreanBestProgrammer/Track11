<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    
<div id="b_left">
			<%@ include file = "../common_menu.jsp" %>
		</div>
<script>
	function goView(no){
		etc.t_gubun.value="view";
		etc.t_no.value=no;
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
	
	function goReply(){
		if(checkValue(reply.t_sessionId,"로그인 후 입력해주세요")) return;
		if(checkValue(reply.t_reply,"내용을 입력해주세요")) return;
		if(checkValue(reply.t_noname,"익명선택을 해주세요")) return;
		$.ajax({
			type : "POST",     //어떤방식으로 넘길거냐
			url : "ReplySave",
			//url이 실행되면서 url의 소스(브라우저에 찍힌 소스)가 data라는 변수 안에 들어감.
			data: "t_c_no="+reply.t_c_no.value+"&t_no="+reply.t_no.value+"&t_reply="+reply.t_reply.value+"&t_noname="+reply.t_noname.value, //t_id = url에 넘어갈 변수(mem.t_id.value를 t_id라는 변수에 담아서 url에 넘긴다 )
			dataType : "text",      //결과를 글자로 받겠다
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				/*var data = JSON.parse(data);
				console.log(data);
				
				console.log(data.length);
				
				for(var k = 0; k<data.length; k++){
					console.log(data[k].reply);
				}
				*/
				
				if(confirm("등록하시겠습니까?")){
					var result = $.trim(data); // $.trim() : 여백을 지움
					reply.t_reply.value = result;
					alert("등록성공!");
					history.go(0);
				}
				
			//	if(result == "사용가능"){
			//	join.t_idCheckValue.value = join.t_id.value;
			//	} else{
			//		join.t_idCheckValue.value = "";
			//	}
				
			}
		});				
		
	}
	function goChange(){
		reply.t_gubun.value="view";
		reply.method="post";
		reply.action="Etc";
		reply.submit();
	}
	function goPage(curpage){
		reply.t_gubun.value="view";
		reply.t_nowPage.value=curpage;
		reply.method="post";
		reply.action="Etc";
		reply.submit();
	}
	
	$(function() {
				$(".accordion").on("click",function() {
				$(".panel").not($(this).next().slideToggle()).slideUp();
				$(".accordion").not($(this)).removeClass("active");
				$(this).toggleClass("active");
			});
	});
</script>	
<style>
	.coment{
		float:left;
	}
	
	.faq-group .accordion {padding:18px; width:97%; text-align:left;border:0 none; background:transparent; font-size:16px; font-weight:bold; cursor:pointer;}
	.faq-group .panel {padding:20px 18px; border-bottom:1px solid #ddd; line-height:1.8; display:none;}
	.faq-group .panel textarea{width:100%; height:100px;}
	
</style>	
		<div id="b_right">
			<p class="n_title">
				ETC
			</p>
			<form name="etc">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_no">
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
						<th>등록자</th>
						<td>${t_dto.getReg_name()}</td>
						<th>등록일</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
					<tr>
						<th>제목</th>
						<td colspan="3">${t_dto.getTitle()}</td>
					</tr>	
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>	
				</tbody>
			</table>
			<form name="reply">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<input type="hidden" name="t_c_no">
			<input type="hidden" name="t_nowPage">
			<input type="hidden" name="t_sessionId" value="${sessionId}">
			<table class="boardForm">
						<colgroup>
							<col width="10%">
							<col width="50%">
							<col width="10%">
						</colgroup>
						<tr>
							<th colspan="3">코멘트</th>
						</tr>
						<tr>
							<th colspan="3">
								<div class="coment">
									<select name="t_order_coment" class="sel_box" onchange="goChange()">
										<option value="desc" <c:if test="${t_order_coment eq 'desc'}">selected</c:if> >최신순</option>
										<option value="asc" <c:if test="${t_order_coment eq 'asc'}">selected</c:if> >오래된순</option>
									</select>
								</div>
								<div class="record_group record_group_left">
									<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
								</div>	
							</th>
						</tr>	
			</table>						
			
				<div class="faq-group">
				
				<c:forEach items="${t_arr}" var="dto">
					<div class="accordion">
						<table class="boardForm">
							<colgroup>
								<col width="65%">
								<col width="15%">
								<col width="20%">
							</colgroup>		
							<tr>
								<td>${dto.getReply()}</td>
								<c:choose>	
									<c:when test="${dto.getNoname() eq '1'}">
										<td style="text-align:center;">${dto.getReply_name()}</td>
									</c:when>
									<c:otherwise>
										<td style="text-align:center;">익명</td>			
									</c:otherwise>
								</c:choose>
								<td style="text-align:center;">${dto.getReply_date()}</td>
							</tr>				
						</table>	
					</div>
					
					
					<div class="panel">
						<c:if test="${not empty sessionId}">
							<td class="t_left"><input type="text" name="" value="" size="80" style="height:40px;"></td>
								<div class="buttonGroup">
									<a href="" class="butt">등록</a>	
									<input type="radio" name="t_noname" value="0">익명
									<input type="radio" name="t_noname" value="1">실명
								</div>	
						</c:if>				
					</div>
				
				</c:forEach>
						<tr>
							<td class="t_left"><input type="text" name="t_reply" size="80" style="height:40px;"></td>
						</tr>
						<input type="radio" name="t_noname" value="0">익명
						<input type="radio" name="t_noname" value="1">실명
				
				<div class="buttonGroup" >
						<a href="javascript:goReply()" class="butt">답글달기</a>
						<a href="Etc" class="butt">List</a>
				</div>	
				
				</div>
						
			</form>
			<div class="paging">
				${t_paging}
			</div>		
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
			
		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    