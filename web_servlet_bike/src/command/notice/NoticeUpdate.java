package command.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		
		String msg = "수정 성공!";  //setAttribute는 try catch 밖에서 설정
		String url = "Notice";
		
		MultipartRequest mpr;
		try {
			mpr = new MultipartRequest(request,CommonUtil.getFile_dir("notice"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
		 
		
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach="";
			String deleteAttach = mpr.getParameter("t_deleteCheckbox");
			String oriAttach = mpr.getParameter("t_ori_attach");
			if(oriAttach == null) oriAttach = "";
			
			String saveAttachName = "";
			
			//첨부 삭제할 때 
			boolean delAttach = true; // 삭제버튼도 누르고 파일도 변경할 때 오류방지용 - 삭제가 되면 true가 false로 바뀌고 새로첨부할때 원래파일의 삭제과정을 안함
			
			if(deleteAttach != null) {
				File file = new File(CommonUtil.getFile_dir("notice"), deleteAttach);
				boolean tf = file.delete();  // 삭제가 안되면 'tf'에 false가 들어옴.  **boolean타입은 무조건 true일때만 실행됨.
				delAttach = false;
				if(!tf) { // 조건문안에 false의 반대인 true가 들어옴.
					System.out.println("첨부파일 삭제 오류"+tf); // 조건문 안에 true가 들어왔으니깐 오류문 실행됨.
				}
			}else {
				saveAttachName = oriAttach;
			}
			
			//새로 첨부할 때
			if(!attach.equals("")) {
				if(!oriAttach.equals("") && delAttach) {
					File file = new File(CommonUtil.getFile_dir("notice"), oriAttach);
					boolean tf = file.delete();
					if(!tf) System.out.println("기존 첨부파일 삭제 오류");
				}
				saveAttachName = attach;
			}
			
			NoticeDto dto = new NoticeDto(no, title, content, saveAttachName);
			
			int result = dao.noticeUpdate(dto);
			if(result != 1) {
				msg = "수정 실패!";
			}
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
		

	}

}
