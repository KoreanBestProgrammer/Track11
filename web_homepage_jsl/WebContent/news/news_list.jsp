<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ include file = "../common_session.jsp" %>
<%@ include file = "../common_header.jsp"  %>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	NewsDao dao = new NewsDao();
	
	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	if(gubun == null){
		gubun = "n.title";
		search = "";
	}
	

	/* paging 설정 start*/
	int totalCount = dao.getTotalCount(gubun,search);
	int list_setup_count = 5;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	
	String nowPage = request.getParameter("t_nowPage");
	int current_page = 0; // 현재페이지 번호
	int total_page = 0;    // 전체 페이지 수
	
	if(nowPage == null || nowPage.equals("")) current_page = 1; 
	else current_page = Integer.parseInt(nowPage);
	
	total_page = totalCount / list_setup_count;  // 몫 : 2
	int rest = 	totalCount % list_setup_count;   // 나머지:1
	if(rest !=0) total_page = total_page + 1;     // 3
	
	int start = (current_page -1) * list_setup_count + 1;
	int end   = current_page * list_setup_count;
	/* paging 설정 end*/	
	
	
	
	
	
	
	
	//ArrayList<NewsDto> arr = dao.getNewsList(gubun,search);
	ArrayList<NewsDto> arr = dao.getNewsList(gubun,search,start,end);
	
	
	
	

%>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>News</h2>
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
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../notice/notice_list.jsp">공지사항</a>
						<a href="../qna/qna_list.jsp">질문과답변</a>
						<a href="../faq/faq_list.jsp">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount %></span>건</p>
		</div>
		<form name = "view">
			<input type="hidden" name="t_no">
		</form>
		<form name="page">
			<input type="hidden" name="t_nowPage">
		</form>
		<form name="news">
		<div class="search_group">			
				<select name="t_gubun" class="select">
					<option value="n.title" <% if(gubun.equals("n.title")) out.print("selected"); %>>제목</option>
					<option value="n.content" <% if(gubun.equals("n.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button class="btn_search" type="button" onclick="goList()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
		</form>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
					//for(int k = 0 ; k < arr.size() ; k++){
					for(NewsDto dto : arr) {		
				%>
				<tr>
					<td><a href="javascript:goView('<%=dto.getNo() %>')"><%=dto.getNo() %></a></td>
					<td class="title"><a href="javascript:goView('<%=dto.getNo() %>')"><%=dto.getTitle() %></a></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getReg_date()%></td>
					<td><%=dto.getHit() %></td>
				</tr>
				<% } %>			
			</tbody>
		</table>
		<div class="paging">
		<%
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		out.print(paging);
			
		%>
		
		<!--
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
		 -->	
			
			<% if(sessionLevel.equals("top")) { %>
				<a href="news_write.jsp" class="btn_write">글쓰기</a>
			<% } %>
		</div>
	  </div>
	</div>
	<script>
	function goList(){
		news.method="post";
		news.action="news_list.jsp";
		news.submit();
	}
	function goView(no){
		view.t_no.value = no;
		view.method="post";
		view.action="news_view.jsp";
		view.submit();
	}
	function goPage(nowPage){
		page.t_nowPage.value=nowPage;
		page.method="post";
		page.action="news_list.jsp";
		page.submit();
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









    