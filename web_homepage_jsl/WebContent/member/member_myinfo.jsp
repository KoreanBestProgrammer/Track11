<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	MemberDao dao = new MemberDao();

	String sessionId = (String)session.getAttribute("sessionId");	
	
	if(sessionId == null){		 
%>
	<script>
	alert("로그인정보가 만료되었습니다.");
	location.href="../login/member_login.jsp";
	</script>	
<% 
	}else{
	MemberDto dto = dao.getMemberView(sessionId);
%>
<%@ include file="../common_header.jsp" %>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>My Infomation</h2>
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
						<a href="notice.jsp">공지사항</a>
						<a href="qa.jsp">질문과답변</a>
						<a href="faq.jsp">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<form name="admin">
	<input type="hidden" name="t_id" value="<%=sessionId%>">
</form>
	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                         	<%=dto.getName() %> 
                        </td>
                    </tr>
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>                        
							<%=dto.getId() %>
						</td>
                    </tr>                  
                    <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>                           
                            <%=dto.getJob() %>					                           
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                        	<%
                        	 if(dto.getTell_1() != null){ 
                        		 out.print(dto.getTell_1()+" - "+dto.getTell_2()+" - "+dto.getTell_3());
                        	 }             	
                        	%>                        	
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>               		                       	                       		
                            <%=dto.getMobile().substring(0,3) %> -
                            <%=dto.getMobile().substring(3,7) %> -
                            <%=dto.getMobile().substring(7) %>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <%=dto.getEmail() %>
                        </td>
                    </tr>
                    <tr>
                    	<th>가입일</th>
                    	<td>
							<%=dto.getReg_date() %>                    	
                    	</td>
                    </tr>
                </tbody> 
            </table>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.back();" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:updateForm();" class="btn_round btn_large btn_pointColor w180"><b>내정보 수정</b></a>
        <a href="javascript:goDelete();" class="btn_round btn_large btn_pointColor w180"><b>회원탈퇴</b></a>
    </div>
	
	
	<script>
		function goDelete(){
			admin.method="post";
			admin.action="member_delete.jsp";
			admin.submit();
		}
		function updateForm(){
			location.href="member_update.jsp";
		}
	
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
	

<%@ include file="../common_footer.jsp" %>

 </body>
 
</html>
<% }%>