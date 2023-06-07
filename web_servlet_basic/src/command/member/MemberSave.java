package command.member;

import javax.servlet.http.HttpServletRequest;

import dao.Member_dao;
import dto.Member_dto;

public class MemberSave {
	public void execute(HttpServletRequest request) {
		Member_dao dao = new Member_dao();	
		
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String age = request.getParameter("t_age");
		String reg_date = request.getParameter("t_reg_date");
		
		Member_dto dto = new Member_dto(id,name,Integer.parseInt(age),reg_date);
		int result = dao.MemberSave(dto);
		
		String url = "Member";
		String msg = "등록성공!";
		if(result != 1) {
			msg = "등록실패~";
			//url = "MemberWrite";
		}	
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}
}
