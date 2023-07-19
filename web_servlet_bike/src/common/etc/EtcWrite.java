package common.etc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

public class EtcWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		
		String no = dao.getNo();
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		HttpSession session = request.getSession();
		String reg_id = (String)session.getAttribute("sessionId");
		String reg_name = (String)session.getAttribute("sessionName");
		String reg_date = CommonUtil.getTodayTime();
		
		EtcDto dto = new EtcDto(no, title, content, reg_id, reg_name, reg_date);
		
		int result = dao.getEtcSave(dto);
		
		String msg = "등록성공!";
		
		if(result != 1) {
			msg = "등록실패!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Etc");
	}

}
