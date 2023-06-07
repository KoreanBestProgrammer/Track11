<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@ page import="dao.*,dto.*" %>
<%
	PdsDao dao = new PdsDao();

	String no = request.getParameter("t_no");
	
	dao.getHit(no);
	
	PdsDto dto = dao.getViewPds(no);
	
	String attachName = "";
	if(dto.getAttach() != null) attachName = dto.getAttach();
	
	//다음
	PdsDto nextDto = dao.getNextPds(no);
	
	//이전
	PdsDto preDto = dao.getPrePds(no);
	
	

%>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자료실</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="allclass.jsp">학과및모집안내</a>
						<a href="portfolio.jsp">포트폴리오</a>
						<a href="online.jsp">온라인접수</a>
						<a href="notice.jsp">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">질문답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="gratings.jsp">질문답변</a>
						<a href="gratings.jsp">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<script>
	function goView(no){
		pds.t_no.value=no;
		pds.method="post";
		pds.action="pds_view.jsp";
		pds.submit();
	}
	function goUpdateForm(no){
		pds.t_no.value=no;
		pds.method="post";
		pds.action="pds_update.jsp";
		pds.submit();
	}
	function goDelete(no){
		if(confirm("정말 삭제하시겠습니까?")){	
			pds.t_no.value=no;
			pds.method="post";
			pds.action="db_pds_delete.jsp";
			pds.submit();
		}
	}
		
</script>
<style>
	.aa{
		width:850px;
		height:300px;
	}
</style>
	<div class="container">
	<form name="pds">
		<input type="hidden" name="t_no">
		<input type="hidden" name="t_attach" value=<%=attachName%>>
	</form>
		<div class="board_view">
			<h2><%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getName() %></span> | 등록일 : <%=dto.getReg_date() %> | <%if(sessionLevel.equals("top")) if(dto.getUpdate_date() != null) out.print("수정날짜 : "+dto.getUpdate_date()+"|");  %>   <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_pds">
			<textarea class="aa" disabled style="resize:none"><%=dto.getContent() %></textarea>
			<% if(dto.getAttach() != null) { %>
				<p>
					<img src="../images/clip.png">
					<a href="../common/filedown.jsp?t_fileDir=pds&t_fileName=<%=dto.getAttach()%>">첨부파일 :<%=dto.getAttach() %></a>
				</p>
			<% } %>
			</div>
			<div class="prev_next">
			    <% if(preDto != null){
					String preTitle = preDto.getTitle();
					if(preTitle.length() > 10){
						preTitle = preTitle.substring(0, 9)+"...";
					}
				%>
			
				<a href="javascript:goView('<%=preDto.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preTitle %></span>
				</span>
				</a>
				<% } %>
				<div class="btn_3wrap">
					<a href="pds_list.jsp">목록</a>
					<% if(sessionLevel.equals("top")) { %>
						<a href="javascript:goUpdateForm('<%=no%>')">수정</a> 
						<a href="javascript:goDelete('<%=no%>')" onClick="return confirm('삭제하시겠어요?')">삭제</a>
					<% } %>
				</div>
				<% if(nextDto != null) {
						String nextTitle = nextDto.getTitle();
						if(nextTitle.length() > 10){
							nextTitle = nextTitle.substring(0, 9)+"...";
						}
				%>
				<a href="javascript:goView('<%=nextDto.getNo() %>')" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span><%=nextTitle %></span>
				</span>
				<i class="fa fa-angle-right"></i>
				</a>
				<% } %>
			</div>
		</div>
	</div>

	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

<footer class="footer">
		<div class="container clearfix">
			<address class="address">
				<p class="title">본사</p>
				(우)12345 대전광역시 중구 계룡로 825 (용두동, 희영빌딩) 5층,6층/고객센터: 042-242-4412 	사업자등록번호: 305-86-06709
			</address>
			<p class="copyright">Copyright &copy JSL 인재개발원주식회사. All rights reserved.</p>
		</div>
</footer>

 </body>
</html>









    