package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberLogin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String password = request.getParameter("t_password");
		try {
			password = dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDto dto = dao.checkLogin(id, password);
		
		String exit_date = "";
		String name = "";
		String memberLevel = "";
		if(dto != null) {
			 name = dto.getName();
			 memberLevel = dto.getMemberLevel();
			 exit_date = dto.getExit_date();
		}
		
		String url = "";
		String msg = "";
		
		if(name.equals("")) {
			url = "Member";
			msg = "id나 비밀번호를 잘못입력하셨습니다";
		}else if(exit_date != null) {
			msg="탈퇴한 회원입니다";
			url="Index";	
		}else {
			url = "Index";
			msg = name+"님 로그인 되셨습니다";
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionName", name);
			session.setAttribute("sessionLevel", memberLevel);		
			session.setMaxInactiveInterval(60*60*2);
			
			int result = dao.getLastLogin(id,CommonUtil.getTodayTime());
			if(result != 1) {
				System.out.println("최근 로그인 날짜 업데이트 오류");
			}
		}
		
		
		
		
		request.setAttribute("t_url", url);
		request.setAttribute("t_msg", msg);
		
		
	}

}
