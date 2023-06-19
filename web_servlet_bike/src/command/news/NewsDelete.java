package command.news;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;

public class NewsDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		
		int result = dao.getNewsDelete(no);
		
		String msg = "삭제 성공!";
		
		if(result == 1) {
			if(!attach.equals("")) {
				File file = new File(CommonUtil.getFile_dir("news"), attach);
				boolean tf = file.delete();
				if(!tf) System.out.println("첨부파일 삭제 오류!"+tf);
			}
		}else {
			msg="삭제 실패!";
		}

		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "News");
		
	}

}
