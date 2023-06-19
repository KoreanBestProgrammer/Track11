package command.news;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NewsDao;
import dto.NewsDto;

public class NewsUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		
		String msg = "수정 성공!";
		
		MultipartRequest mpr;
		try {
			mpr = new MultipartRequest(request, CommonUtil.getFile_dir("news"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach="";
			String deleteAttach = mpr.getParameter("t_deleteAttachCheck");
			String oriAttach = mpr.getParameter("t_oriAttach");
			String updateDate = CommonUtil.getTodayTime();
			
			String saveAttach = "";
			
			
			//기존 첨부파일 삭제
			boolean del = true;
			if(deleteAttach != null) {
				File file = new File(CommonUtil.getFile_dir("news"),deleteAttach);
				boolean tf = file.delete();
				if(!tf) System.out.println("첨부파일 삭제 오류!"+tf);
				del = false;
			}else {
				saveAttach = oriAttach;
			}
			
			//새로운 파일 첨부
			if(!attach.equals("")) {
				if(oriAttach != null && del) {
					File file = new File(CommonUtil.getFile_dir("news"), oriAttach);
					boolean tf = file.delete();
					if(!tf) System.out.println("첨부파일 삭제 오류!"+tf+"hhh");
				}
				saveAttach = attach;
			}
			
			NewsDto dto = new NewsDto(no, title, saveAttach, content, updateDate);
			
			int result = dao.getUpdateNews(dto);
			
			if(result != 1) {
				msg = "수정 실패!";
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "News");
	}

}
