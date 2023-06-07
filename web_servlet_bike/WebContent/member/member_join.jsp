<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('memberJoin')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>Join</a></li>
			</ul>
		</div>
		<script>
			function goJoin(){
				
				if(checkValue(join.t_id,"id를 입력하시오")) return;	
				
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
				
				if(checkValue(join.t_name,"이름를 입력하시오")) return;
				if(checkValue(join.t_password,"비밀번호를 입력하시오")) return;
				if(checkValue(join.t_password2,"비밀번호확인을 입력하시오")) return;
				
				if(join.t_password.value != join.t_password2.value){
					alert("비밀번호가 맞는지 확인해주세요");
					join.t_password2.focus();
					return;
				}
				
				if(checkValue(join.t_address,"주소를 입력하시오")) return;
				if(checkValue(join.t_password,"비밀번호를 입력하시오")) return;
				if(checkValue(join.t_mobile1,"휴대전화번호 3자리를 입력하시오")) return;
				if(checkValue(join.t_mobile2,"휴대전화번호 4자리를 입력하시오")) return;
				if(checkValue(join.t_mobile3,"휴대전화번호 4자리를 입력하시오")) return;
				if(checkValue(join.t_gender,"성별을 선택해 주세요")) return;
				
				
				
				join.t_gubun.value="memberSave";
				join.method="post";
				join.action="Member";
				join.submit();
				
			}
			
			function checkID(){		
				
				if(checkValue(join.t_id,"id입력 후 중복검사 하시오")) return;
				
				$.ajax({
					type : "POST",     //어떤방식으로 넘길거냐
					url : "MemberCheckId",
					//url이 실행되면서 url의 소스(브라우저에 찍힌 소스)가 data라는 변수 안에 들어감.
					data: "t_id="+join.t_id.value, //t_id = url에 넘어갈 변수(mem.t_id.value를 t_id라는 변수에 담아서 url에 넘긴다 )
					dataType : "text",      //결과를 글자로 받겠다
					error : function(){
						alert('통신실패!!!!!');
					},
					success : function(data){
						var result = $.trim(data); // $.trim() : 여백을 지움					
					
						join.t_idCheck.value = result;
						
						if(result == "사용가능"){
						join.t_idCheckValue.value = join.t_id.value;
						} else{
							join.t_idCheckValue.value = "";
						}
						
					}
				});				
			}
			
		</script>
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
			<form name="join">
				<input type="hidden" name="t_gubun">	
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" size="10" id="id" title="id입력하세요">
					<input type="button" onclick="checkID()" value="ID중복검사" class="checkB">
					<input type="text" name="t_idCheck" style="border:none" readonly>
					<input type="hidden" name="t_idCheckValue" style="border:none" readonly>
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" type="text" size="8" id="nana"></td>
				</tr>
				<tr>
				  <th>비빌번호</th>
				  <td><input name="t_password" type="text" size="13"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input name="t_password2" type="text" size="13"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
						<option value="대구">대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input name="t_address" type="text" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_mobile1" type="text" size="2"> -
					<input name="t_mobile2" type="text" size="3"> -
					<input name="t_mobile3" type="text" size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" name="t_gender" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_gender" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" name="t_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_sports" class="middleCheck" /> 운동
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goJoin()" class="butt">JOIN</a>
			</div>	
		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    