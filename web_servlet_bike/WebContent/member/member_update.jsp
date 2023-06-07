<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a><span class="fnt"><i class="fas fa-apple-alt"></i></span>Member</a></li>
			</ul>
		</div>
		<script>
			function goUpdate(){
				
					/*	if(checkValue(join.t_id,"id를 입력하시오")) return;	
						
						if(join.t_idCheckValue.value == ""){
							alert("사용가능한 id가 아닙니다");
							join.t_id.fucus();
							return;
						}
						
						if(join.t_id.value != join.t_idCheckValue.value){
							alert("변경된 id 중복검사 하시오");
							join.t_password2.focus();
							return;
						}
					*/
						if(checkValue(join.t_name,"이름를 입력하시오")) return;
					/*	if(checkValue(join.t_password,"비밀번호를 입력하시오")) return; */
					/*	if(checkValue(join.t_password_confirm,"비밀번호확인을 입력하시오")) return; */
					
						
						
						
						
					/*	if(join.t_password_confirm.value != join.t_password2.value){
							alert("비밀번호가 맞는지 확인해주세요");
							join.t_password2.focus();
							return;
						}
					*/
					
						if(checkValue(join.t_address,"주소를 입력하시오")) return;
						
						if(checkValue(join.t_mobile1,"휴대전화번호 3자리를 입력하시오")) return;
						if(checkValue(join.t_mobile2,"휴대전화번호 4자리를 입력하시오")) return;
						if(checkValue(join.t_mobile3,"휴대전화번호 4자리를 입력하시오")) return;
						
						if(checkValue(join.t_password_confirm,"비밀번호 확인을 입력하시오")) return;
						/*if(checkValue(join.t_gender,"성별을 선택하세요")) return; */
						
						checkPassword();
						
						if(join.t_password_check.value=="no"){
							alert("비밀번호를 확인하세요");
							join.t_password_confirm.focus();
							return;
						}else if(join.t_password_check.value=="yes"){
							
						
							join.t_gubun.value="memberUpdate";
							join.method="post";
							join.action="Member";
							join.submit();
						}
					}
				
				function checkPassword(){		
					
					$.ajax({
						type : "POST",     //어떤방식으로 넘길거냐
						url : "MemberCheckPassword",
						//url이 실행되면서 url의 소스(브라우저에 찍힌 소스)가 data라는 변수 안에 들어감.
						async : false,
						data: "t_id="+join.t_id.value+"&t_pw="+join.t_password_confirm.value, //t_id = url에 넘어갈 변수(mem.t_id.value를 t_id라는 변수에 담아서 url에 넘긴다 )
						dataType : "text",      //결과를 글자로 받겠다
						error : function(){
							alert('통신실패!!!!!');
						},
						success : function(data){
							var result = $.trim(data); // $.trim() : 여백을 지움					
							join.t_password_check.value=data;
							//alert(data);								
						}
					});	
				}	
			
			
		</script>
		<div id="b_right">
			<p class="n_title">
				MEMBER UPDATE
			</p>
			<form name="join">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_id" value="${t_dto.getId() }">	
				<input type="hidden" name="t_password_check" >	
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${t_dto.getId() }</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" value="${t_dto.getName() }" type="text" size="8" id="nana"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울" <c:if test="${t_dto.getArea() eq '서울' }">selected</c:if>>서울</option>
						<option value="대전" <c:if test="${t_dto.getArea() eq '대전' }">selected</c:if>>대전</option>
						<option value="부산" <c:if test="${t_dto.getArea() eq '부산' }">selected</c:if>>부산</option>
						<option value="대구" <c:if test="${t_dto.getArea() eq '대구' }">selected</c:if>>대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input name="t_address" value="${t_dto.getAddress() }" type="text" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_mobile1" value="${t_dto.getMobile_1() }" type="text" size="2"> -
					<input name="t_mobile2" value="${t_dto.getMobile_2() }" type="text" size="3"> -
					<input name="t_mobile3" value="${t_dto.getMobile_3() }" type="text" size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" name="t_gender" <c:if test="${t_dto.getGender() eq 'f' }">checked</c:if> class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_gender" <c:if test="${t_dto.getGender() eq 'm' }">checked</c:if> class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" <c:if test="${t_dto.getHobby_travel() eq 'y' }">checked</c:if> name="t_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="y" <c:if test="${t_dto.getHobby_reading() eq 'y' }">checked</c:if> name="t_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="y" <c:if test="${t_dto.getHobby_sports() eq 'y' }">checked</c:if> name="t_sports" class="middleCheck" /> 운동
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
				<tr>
				  <th>비빌번호 확인</th>
				  <td><input name="t_password_confirm"  type="text" size="13"></td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goUpdate()" class="butt">수정</a>
			</div>	
		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    