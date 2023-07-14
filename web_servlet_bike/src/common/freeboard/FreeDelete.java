package common.freeboard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeDao;

public class FreeDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeDao dao = new FreeDao();
		
		String no = request.getParameter("t_no");
		String attachName = request.getParameter("t_attachName");
		if(attachName == null) attachName = "";
		
		int result = dao.getFreeDelete(no);
		
		boolean tf = true;
		
		if(result == 1) {
			if(!attachName.equals("")) {
				File file = new File(CommonUtil.getFile_dir("freeboard"), attachName);
				tf = file.delete();
				if(!tf) System.out.println("첨부파일 삭제오류");
			}
		}
		
		String msg = "삭제실패!";
		if(result == 1 && tf) {
			msg = "삭제성공!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Freeboard");
		
	}

}
