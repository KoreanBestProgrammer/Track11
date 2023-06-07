package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberJoin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		
		MemberDao dao = new MemberDao();
		
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String password = request.getParameter("t_password");	
		int passwordLen = password.length();
			try {
				password = dao.encryptSHA256(password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		String area = request.getParameter("t_area");
		String address = request.getParameter("t_address");
		String mobile1 = request.getParameter("t_mobile1");
		String mobile2 = request.getParameter("t_mobile2");
		String mobile3 = request.getParameter("t_mobile3");
		String gender = request.getParameter("t_gender");
		String travel = request.getParameter("t_travel");
		if(travel == null) travel = "n";
		String reading = request.getParameter("t_reading");
		if(reading == null) reading = "n";
		String sports = request.getParameter("t_sports");
		if(sports == null) sports = "n";
		String reg_date = CommonUtil.getTodayTime();
			
		MemberDto dto = new MemberDto(id,name,password,passwordLen,area,address,mobile1,mobile2,mobile3,gender,travel,reading,sports,reg_date);
		int result = dao.getMemberSave(dto);
		String url = "Member";
		String msg = name+"님 회원가입 되었습니다";
		if(result != 1) {
			msg = "회원가입 실패";
		}
		request.setAttribute("t_url", url);
		request.setAttribute("t_msg", msg);
	}

}
