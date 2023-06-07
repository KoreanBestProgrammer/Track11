package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class DBSnackSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String price = request.getParameter("t_price");
		String m_code = request.getParameter("t_m_code");
		
		SnackDto dto = new SnackDto(p_code,p_name,m_code,Integer.parseInt(price));
		
		int result = dao.getSaveSnack(dto);
		
		String msg = "등록성공";
		String url = "Snack";
		if(result != 1) {
			msg="등록실패";
			//url="SnackWrite";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		

	}

}
