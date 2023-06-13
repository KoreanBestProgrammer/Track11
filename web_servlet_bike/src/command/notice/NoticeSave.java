package command.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		//cos파일 있어야 첨부가능!
		NoticeDao dao = new NoticeDao();
		
		
			String msg="등록되었습니다"; 
		
		try {
			MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir("notice"),
									1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			
			String no = dao.getMaxNo();
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach="";
			HttpSession session = request.getSession();
			String reg_id = (String)session.getAttribute("sessionId");
			String reg_date = CommonUtil.getTodayTime();
			
			NoticeDto dto = new NoticeDto(no,title,content,attach,reg_id,reg_date);
			
			int result = dao.noticeSave(dto);
			
			
			if(result != 1) {
				msg="등록실패";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Notice");
		
	}

}
