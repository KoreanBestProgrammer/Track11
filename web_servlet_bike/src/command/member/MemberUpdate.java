package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		
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
		String update_date = CommonUtil.getTodayTime();
		
		MemberDto dto = new MemberDto(id, name, area, address, mobile1, mobile2, mobile3, gender, travel, reading, sports, update_date);
				
		int result = dao.memberUpdate(dto);		
		String url="Index";
		String msg="";
		if(result != 1) {
			msg="정보 수정 실패";
		}else {
			msg="정보 수정 성공";
		}
		request.setAttribute("t_url", url);
		request.setAttribute("t_msg", msg);
		
	}

}
