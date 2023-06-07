<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%@ include file = "../common_session.jsp" %>
<%@ include file = "../common_header.jsp"  %>
<%
	NewsDao dao = new NewsDao();
	
	String no = request.getParameter("t_no");
	
	dao.getHit(no);
	//뷰
	NewsDto dto = dao.getNewsView(no);
	//이전
	NewsDto preDto = dao.getPreView(no);
	//다음
	NewsDto nextDto = dao.getNextView(no);


%>

	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">질문답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="gratings.html">질문답변</a>
						<a href="gratings.html">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
	<form name="view">
		<input type="hidden" name="t_no">
	</form>
	<div class="container">
		<div class="board_view">
			<h2>[공지] <%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getName() %></span> | <%="등록일 : "+dto.getReg_date() %> | <% if(sessionLevel.equals("top")) if(dto.getUpdate_date() != null) out.print("수정날짜 : "+dto.getUpdate_date()+"|");%>  <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_body">
				<textarea disabled><%=dto.getContent() %></textarea>
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
					<a href="news_list.jsp">목록</a> 
					<% if(sessionLevel.equals("top")) { %>
						<a href="javascript:goUpdateForm('<%=no%>')">수정</a> 
						<a href="javascript:goDelete('<%=no%>')">삭제</a>
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
				<% }%>
			</div>
		</div>
	</div>
	<script>
	function goView(no){
				view.t_no.value = no;
				view.method="post";
				view.action="news_view.jsp";
				view.submit();			
			}
			function goUpdateForm(no){
				view.t_no.value = no;
				view.method="post";
				view.action="news_update.jsp";
				view.submit();
			}
			function goDelete(no){
				if(confirm("정말삭제하시겠습니까?")){
					view.t_no.value = no;
					view.method="post";
					view.action="db_news_delete.jsp";
					view.submit();
				}
			}
	</script>

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









    