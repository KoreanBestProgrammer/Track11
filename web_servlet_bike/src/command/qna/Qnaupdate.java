package command.qna;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class Qnaupdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
			QnaDao dao = new QnaDao();
			
			String msg = "수정성공!";
			String url = "Qna";
			
			try {
				MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir("qna"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
				
				String no = mpr.getParameter("t_no");
				String title = mpr.getParameter("t_title");
				String content = mpr.getParameter("t_content");
				String attach = mpr.getFilesystemName("t_attach");
				if(attach == null) attach="";
				String oriAttach = mpr.getParameter("t_ori_attach");
				if(oriAttach == null) oriAttach = "";
				String deleteAttach = mpr.getParameter("t_deleteCheckAttach");
				String update_date = CommonUtil.getTodayTime();
				
				String saveAttach = "";
				
				boolean delAttach = true;
				
				//첨부파일 삭제할때
				if(deleteAttach != null) {
					File file = new File(CommonUtil.getFile_dir("qna"), deleteAttach);
					boolean tf = file.delete();
					delAttach = false;
					if(!tf) System.out.println("첨부파일 삭제오류");
				}else {
					saveAttach = oriAttach;
				}
				
				//새로 첨부할때
				if(!attach.equals("")) {
					if(!oriAttach.equals("") && delAttach) {
						File file = new File(CommonUtil.getFile_dir("qna"), oriAttach);
						boolean tf = file.delete();
						if(!tf) System.out.println("첨부파일 삭제오류");
					}
					saveAttach = attach;
				}
				
				QnaDto dto = new QnaDto(no, title, content, saveAttach, update_date);
				
				int result = dao.getQnaUpdate(dto);
				
				if(result != 1) {
					msg = "수정실패!";
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			
	}

}
