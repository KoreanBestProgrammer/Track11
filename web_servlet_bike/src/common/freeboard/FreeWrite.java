package common.freeboard;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeDao;
import dto.FreeDto;

public class FreeWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeDao dao = new FreeDao();
		
		String msg = "등록성공!";
		
		try {
			MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir("freeboard"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			
			String no = dao.getNo();
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach = "";
			HttpSession session = request.getSession();
			String reg_id = (String)session.getAttribute("sessionId");
			String reg_name = (String)session.getAttribute("sessionName");
			String reg_date = CommonUtil.getTodayTime();
			String open = mpr.getParameter("t_open");
			
			FreeDto dto = new FreeDto(no, title, content, attach, reg_id, reg_name, reg_date, open);
			int result = dao.getFreeSave(dto);
			
			if(result != 1) {
				msg = "등록실패!";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Freeboard");

	}

}
