package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;

public class MemberPasswordUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");	
		String name = (String)session.getAttribute("sessionName");	
		
		String now_pw = request.getParameter("t_now_pw");
		String newPassword = request.getParameter("t_change_pw1");
		int pwLeng = newPassword.length();
		
		
		String msg = "";
		if(id == null) {
			msg="로그인 정보가 만료되었습니다.";
		}else {
			try {
				now_pw = dao.encryptSHA256(now_pw);
				newPassword = dao.encryptSHA256(newPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int count = dao.getPasswordCheck(id, now_pw);
			if(count == 1) {
				int result = dao.setMemberPassword(id,newPassword,pwLeng);
				if(result == 1) {
					msg = name+"님 비밀번호가 변경되었습니다.";
					session.invalidate();
				}else {
					msg = name+"님 비밀번호 변경 실패! 관리자에게 문의하세요";
				}
			}					
		}
		request.setAttribute("t_url", "Member");
		request.setAttribute("t_msg", msg);
	}
}
