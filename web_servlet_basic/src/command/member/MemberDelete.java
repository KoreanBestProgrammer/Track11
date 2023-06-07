package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.Member_dao;

public class MemberDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		Member_dao dao = new Member_dao();
		
		String id = request.getParameter("t_id");
		
		int result = dao.getDelete(id);
		
//		String url = "MemberList";
		String url = "Member";
		String msg = "삭제성공!";
		if(result != 1) {
			msg = "삭제실패";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);

	}

}
