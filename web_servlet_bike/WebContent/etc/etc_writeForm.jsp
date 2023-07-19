<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    
<div id="b_left">
			<%@ include file = "../common_menu.jsp" %>
		</div>
<script>
	function goSave(){
		etc.t_gubun.value="save";
		etc.method="post";
		etc.action="Etc";
		etc.submit();
	}
</script>		
		<div id="b_right">
			<p class="n_title">
				ETC
			</p>
			<form name="etc">
			<input type="hidden" name="t_gubun">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${sessionName}</td>
						<th>RegDate</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Etc" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    