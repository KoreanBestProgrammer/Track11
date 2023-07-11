package command.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class Qnaanswer implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
	   QnaDao dao = new QnaDao();
	   
	   String no = request.getParameter("t_no");
	   String answer = request.getParameter("t_answer");
	   HttpSession session = request.getSession();
	   String answer_id = (String)session.getAttribute("sessionName");
	   String answer_date = CommonUtil.getTodayTime();
	   
	   QnaDto dto = new QnaDto(no, answer, answer_id, answer_date);
	   
	   int result = dao.getAnswerSave(dto);
	   
	   String msg = "등록성공!";
	   
	   if(result != 1) {
		   msg = "등록실패!";
	   }
	   
	   request.setAttribute("t_msg", msg);
	   request.setAttribute("t_url", "Qna");
	}

}
