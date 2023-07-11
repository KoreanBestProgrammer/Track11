package command.qna;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class Qnawrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
			QnaDao dao = new QnaDao();
			
			String msg = "등록성공!";
			String url = "Qna";
			
			try {
				MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir("qna"),
						1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
				
				String no = dao.getQnaNo();
				String title = mpr.getParameter("t_title");
				String content = mpr.getParameter("t_content");
				String attach = mpr.getFilesystemName("t_attach");
				if(attach == null) attach="";
				String state = mpr.getParameter("t_state");
				HttpSession session = request.getSession();
				String reg_id = (String)session.getAttribute("sessionId");
				String reg_date = CommonUtil.getTodayTime();
			
				QnaDto dto = new QnaDto(no, title, content, attach, reg_date, reg_id, state);
				
				int result = dao.getSaveQna(dto);
				
				if(result != 1) {
					msg = "등록실패!";
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
			
		
	}

}
