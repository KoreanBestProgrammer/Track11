package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.QnaDao;
import dto.QnaDto;

public class Qnaview implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		
		String no = request.getParameter("t_no");
		
		QnaDto dto = dao.getQnaView(no);
		
		if(dto.getAttach() != null) {
			int maxNum = dto.getAttach().length();
			int num = dto.getAttach().indexOf(".");
			
			String extension = dto.getAttach().substring(num+1, maxNum);
			
			if(extension.equals("jpg") || extension.equals("gif") || extension.equals("png")) {
				request.setAttribute("t_extension", extension);
			}
		}
		
		request.setAttribute("t_dto", dto);
		
		
		
	}

}
