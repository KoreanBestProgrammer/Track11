package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;

public class MemberExit implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		HttpSession session = request.getSession();
		
			String id = (String)session.getAttribute("sessionId");
		
			String name = (String)session.getAttribute("sessionName");
			
			String exit_date = CommonUtil.getTodayTime();
			
			String msg = name+"님 탈퇴 되셨습니다";	
			if(id != null) {
				int result = dao.getMemberExit(id,exit_date);
				if(result == 1) {
					session.invalidate();
				}else {
					msg = "탈퇴 실패";	
				}
			}else {
				msg = "로그인정보가 만료되었씁니다.";
			}
			request.setAttribute("t_url", "Index");
			request.setAttribute("t_msg", msg);
			
		
	}	
		
}	