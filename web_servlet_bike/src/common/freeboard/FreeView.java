package common.freeboard;



import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.FreeDao;
import dto.FreeDto;

public class FreeView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeDao dao = new FreeDao();
		
		String no = request.getParameter("t_no");
		
		dao.getHit(no);
		
		
		
		FreeDto dto = dao.getFreeView(no);
		
		
		if(dto.getAttach() != null) {	
			int num = dto.getAttach().indexOf(".");
			int maxnum = dto.getAttach().length();
			
			String extension = dto.getAttach().substring(num+1, maxnum);
			
			if(extension.equals("jpg") || extension.equals("gif") || extension.equals("png")) {
				request.setAttribute("t_extension", extension);
			}
		}
		
		
		FreeDto preDto = dao.getPreView(no);
		
		FreeDto nextDto = dao.getNextView(no);
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
		
		
	}

}
