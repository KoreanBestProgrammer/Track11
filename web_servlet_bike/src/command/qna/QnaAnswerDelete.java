package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.QnaDao;
import dto.QnaDto;

public class QnaAnswerDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		
		String no = request.getParameter("t_no");
		String answer = "";
		String admin_update_date = "";
		
		
		
		QnaDto dto = new QnaDto(no, answer, admin_update_date);
		
		int result = dao.getAnswerDelete(dto);
		
		String msg = "삭제성공!";
		
		if(result != 1) {
			msg = "삭제실패!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Qna");
	}

}
