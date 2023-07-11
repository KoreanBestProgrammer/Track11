package command.qna;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;

public class Qnadelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
			QnaDao dao = new QnaDao();
			
			String no = request.getParameter("t_no");
			
			String attach = request.getParameter("t_attach");
			
			int result = dao.getQnaDelete(no);
			
			boolean tf = true;
			
			if(result == 1) {
				if(!attach.equals("")) {
					File file = new File(CommonUtil.getFile_dir("qna"),attach);
				    tf = file.delete();
					if(!tf) System.out.println("첨부파일 삭제오류");
				}
			}
			String msg = "삭제실패!";
			if(result == 1 && tf) {
				msg = "삭제성공!";
			}
			
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Qna");
	}
}