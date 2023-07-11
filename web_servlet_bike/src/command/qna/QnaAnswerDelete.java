package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaAnswerDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		
		String no = request.getParameter("t_no");
		String answer = request.getParameter("t_answer");
		
		answer = "";
		
		QnaDto dto = new QnaDto(no, answer);
		
		int result = dao.getAnswerDelete(dto);
		
	}

}
