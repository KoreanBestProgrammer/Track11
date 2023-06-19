package command.news;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;
import dto.NewsDto;

public class NewsSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		String newsDir = CommonUtil.getFile_dir("news");
		int maxSize = CommonUtil.getMaxSize();
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, newsDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
			String no = dao.getMaxNo();
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach = "";
			HttpSession session = request.getSession();
			String reg_id = (String)session.getAttribute("sessionId");
			String reg_date = CommonUtil.getTodayTime();
		
			NewsDto dto = new NewsDto(no, title, content, attach, reg_id, reg_date);
			
			int result = dao.getNewsSave(dto);
		
			String msg = "등록성공!";
			if(result != 1) {
				msg = "등록실패!";
			}
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "News");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
