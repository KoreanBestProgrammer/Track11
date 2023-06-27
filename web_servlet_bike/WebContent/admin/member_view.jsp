<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common_header.jsp" %>
<div id="b_left">
			<%@ include file="../common_menu_admin.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="5%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="20%">
					<col width="15%">
					<col width="25%">
					<col width="5%">
				</colgroup>
				<tbody>
					<tr>
						<th colspan="3">ID</th>
						<td colspan="4">${t_dto.getId()}</td>
					</tr>	
					<tr>
						<th colspan="3">성명</th>
						<td colspan="4">${t_dto.getName()}</td>
					</tr>	
					<tr>
						<th colspan="3">비밀번호</th>
						<td colspan="4">
							<c:forEach begin="1" end="${t_dto.getPassword_len()}">*</c:forEach>
						</td>
					</tr>
					<tr>
						<th colspan="3">지역</th>
						<td colspan="4">${t_dto.getArea()}</td>
					</tr>	
					<tr>
						<th colspan="3">전화번호</th>
						<td colspan="4">${t_dto.getMobile_1()}-${t_dto.getMobile_2()}-${t_dto.getMobile_3()}</td>
					</tr>
					<tr>	
						<th colspan="3">성별</th>
						<td colspan="4">
							<c:if test="${t_dto.getGender() eq 'f'}">여자</c:if>
							<c:if test="${t_dto.getGender() eq 'm'}">남자</c:if>
						</td>
					</tr>	
					<tr>	
						<th colspan="3">취미</th>
						<td colspan="4">
							<c:if test="${t_dto.getHobby_travel() eq 'y'}">여행</c:if>
							<c:if test="${t_dto.getHobby_reading() eq 'y'}">독서</c:if>
							<c:if test="${t_dto.getHobby_sports() eq 'y'}">운동</c:if>
							<c:if test="${t_dto.getHobby_travel() eq 'n' && t_dto.getHobby_reading() eq 'n' && t_dto.getHobby_sports() eq 'n'}">없음</c:if>
						</td>
					</tr>	
					<tr>	
						<th colspan="3">가입일자</th>
						<td colspan="4">${t_dto.getReg_date()}</td>
					</tr>	
					<tr>	
						<th colspan="3">최근 로그인 일자</th>
						<td colspan="4">${t_dto.getLast_login_date()}</td>
					</tr>	
					<tr>	
						<th colspan="3">최근 수정 일자</th>
						<td colspan="4">${t_dto.getUpdate_date()}</td>
					</tr>	
					<tr>
						<th colspan="3">레벨</th>
						<td colspan="4">${t_dto.getMemberLevel()}</td>
					</tr>
					<tr>	
						<th colspan="3">탈퇴여부</th>
						<td colspan="5">
							<c:if test="${not empty t_dto.getExit_date()}">
								탈퇴한 회원&nbsp;&nbsp;  ${t_dto.getExit_date()}
							</c:if>		
						</td>
					</tr>	
				</tbody>
			</table>
			
			<div class="buttonGroup">
				<a href="Admin" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>






    