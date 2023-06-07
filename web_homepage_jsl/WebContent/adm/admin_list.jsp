<%@page import="common.CommonUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common_header.jsp" %>
<%@ page import="dao.*,dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	AdminDao dao = new AdminDao(); 

	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	if(gubun == null){
		gubun = "id";
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
		
	//ArrayList<MemberDto> arr = dao.getAdminList(gubun,search);
	ArrayList<MemberDto> arr = dao.getAdminListPage(gubun,search,start,end);
	
		
%>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
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
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../notice/notice_list.jsp">공지사항</a>
						<a href="../pna/qna_list.jsp">질문과답변</a>
						<a href="../faq/faq_list.jsp">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<script>
	function goSearch(){
		admin.method="post";
		admin.action="admin_list.jsp";
		admin.submit();
	}
	function goPage(nowPage){
		page.t_nowPage.value=nowPage;
		page.method="post";
		page.action="admin_list.jsp";
		page.submit();
		
	}
	function goView(id){
 		adm.t_id.value=id;
 		adm.method="post";
 		adm.action="admin_view.jsp";
 		adm.submit();
 		
 	}

</script>
	<form name="adm">
		<input type="hidden" name="t_id">
	</form>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount %></span>건</p>
		</div>
		<div class="search_group">
		<form name = "page">
			<input type="hidden" name="t_nowPage">	
		</form>
			<form name="admin">
				<select name="t_gubun" class="select">
					<option value="id" <% if(gubun.equals("id")) out.print("selected"); %>>아이디</option>
					<option value="name" <% if(gubun.equals("name")) out.print("selected"); %>>이름</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button type="button" onclick="goSearch()" class="btn_search" ><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
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
					<th>아이디</th>
					<th>성명</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>회원가입일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<% for(MemberDto dto : arr){ %>			
				<tr>
					<td><a href="javascript:void(0)" onclick="goView('<%=dto.getId() %>')"><%=dto.getId() %></a></td>
					<td class="title"><a href="javascript:goView('<%=dto.getId() %>')"><%=dto.getName()%></a></td>
					<td>
						<% 
							String mobile1 = dto.getMobile().substring(0, 3); 
	                        String mobile2 = dto.getMobile().substring(3, 7);
	                        String mobile3 = dto.getMobile().substring(7);
	                        out.print(mobile1+"-"+mobile2+"-"+mobile3);                     
                        %>
                    </td>
					<td><%=dto.getEmail() %></td>
					<td><%=dto.getReg_date() %></td>												
					<td><%
							if(dto.getTal().equals("1")) out.print("");
							else out.print("탈퇴회원");								
						%>
				    </td>						 						
				</tr>	
			<% } %>			
			</tbody>
		</table>
		<div class="paging">
		
		<%
		 	String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		 	
		 	out.print(paging);
		
		%>
		<!--  	<a href=""><i class="fa  fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
					<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa  fa-angle-double-right"></i></a>
				<a href="notice_write.jsp" class="btn_write">글쓰기</a>
			-->
				
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









    