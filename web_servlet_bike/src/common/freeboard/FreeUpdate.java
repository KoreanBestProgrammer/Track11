package common.freeboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeDao;
import dto.FreeDto;

public class FreeUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeDao dao = new FreeDao();
		String msg = "수정성공!";
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("freeboard"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
		
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach = "";
			String oriAttach = mpr.getParameter("t_oriAttach");
			String deleteAttach = mpr.getParameter("t_deleteAttach");
			String update_date = CommonUtil.getTodayTime();
			
			String saveAttach = "";
			boolean delAttach = true;
			
			if(deleteAttach != null) {
				File file = new File(CommonUtil.getFile_dir("freeboard"), deleteAttach);
				boolean tf = file.delete();
				delAttach = false;
				if(!tf) System.out.println("첨부파일 삭제오류");
			}else {
				saveAttach = oriAttach;
			}
			
			if(!attach.equals("")) {
				if(oriAttach != null && delAttach) {
					File file = new File(CommonUtil.getFile_dir("freeboard"), oriAttach);
					boolean tf = file.delete();
					if(!tf) System.out.println("첨부파일 삭제오류");
				}
				saveAttach = attach;
			}
			
			
			FreeDto dto = new FreeDto(no, title, content, saveAttach, update_date);
			int result = dao.getFreeUpdate(dto);
			
			if(result != 1) {
				msg = "수정실패!";
			}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Freeboard");
	}

}
