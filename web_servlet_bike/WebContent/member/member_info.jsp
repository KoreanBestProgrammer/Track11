<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file = "../common_header.jsp" %>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a><span class="fnt"><i class="fas fa-apple-alt"></i></span>Member</a></li>
				<c:if test="${sessionLevel eq 'member'}">
					<li><a href="javascript:goMyorder()">MY ORDER</a></li>
				</c:if>
			</ul>
		</div>
		<script>
			function goUpdateForm(){
				bike.t_gubun.value="memberUpdateForm";
				bike.method="post";
				bike.action="Member";
				bike.submit();
			}
			function goExit(){
				if(confirm("정말로 탈퇴하시겠습니까?")){
					bike.t_gubun.value="memberExit";
					bike.method="post";
					bike.action="Member";
					bike.submit();
				}
			}
			function goPasswordForm(){
				bike.t_gubun.value="memberPasswordForm";
				bike.method="post";
				bike.action="Member";
				bike.submit();
			}
			function goMyorder(){
				bike.t_gubun.value="myorder";
				bike.method="post";
				bike.action="Productsale";
				bike.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				MEMBER INFOMATION
			</p>
			
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					 ${t_dto.getId() }
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${t_dto.getName() }</td>
				</tr>
				<tr>
				  <th>비빌번호</th>
				  <td>
				  	<c:forEach begin="1" end="${t_dto.getPassword_len() }">*</c:forEach>
				  </td>
				</tr>
				
				<tr>
				  <th>지역</th>
				  <td>
					${t_dto.getArea() }
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td>${t_dto.getAddress() }</td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					${t_dto.getMobile_1() } -
					${t_dto.getMobile_2() } -
					${t_dto.getMobile_3() }
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <c:if test="${t_dto.getGender() eq 'f'}">여성</c:if>		   
					  <c:if test="${t_dto.getGender() eq 'm'}">남성</c:if>		   		  
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <c:if test="${t_dto.getHobby_travel() eq 'y' }">여행</c:if>
					  <c:if test="${t_dto.getHobby_reading() eq 'y' }">독서</c:if>
					  <c:if test="${t_dto.getHobby_sports() eq 'y' }">운동</c:if>
				  </td>
				</tr>
				<tr>
				  <th>회원가입일</th>			  
					<td>${t_dto.getReg_date() }</td>			  
				</tr>
				<tr>
				  <th>최근로그인일자</th>		  
					<td>${t_dto.getLast_login_date() }</td>			
				</tr>
				<tr>
				  <th>최근정보수정일</th>		  
					<td>${t_dto.getUpdate_date() }</td>			
				</tr>
			  </tbody>
			</table>
			
			<div class="buttonGroup_center">
				<a href="javascript:goUpdateForm()" class="butt">내정보수정</a>
				<a href="javascript:goPasswordForm()" class="butt">비밀번호 변경</a>
				<a href="javascript:goExit()" class="butt">회원탈퇴</a>
			</div>	
		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    