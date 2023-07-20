package common.etc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.EtcDao;
import dao.ReplyDao;
import dto.EtcDto;
import dto.ReplyDto;

public class EtcView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		ReplyDao reDao = new ReplyDao();
		
		String no = request.getParameter("t_no");
		String order_coment = request.getParameter("t_order_coment");
		
		if(order_coment == null) {
			order_coment = "desc";
		}
		
		EtcDto dto = dao.getEtcView(no);
		
		EtcDto preDto = dao.getEtcPreView(no);
		
		EtcDto nextDto = dao.getEtcNextView(no);
		
		/* paging 설정 start*/
		int totalCount = reDao.getTotalCount(no);
		int list_setup_count = 10;  //한페이지당 출력 행수 
		int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
		
		String nowPage = request.getParameter("t_nowPage");
		int current_page = 0; // 현재페이지 번호
		int total_page = 0;    // 전체 페이지 수
		
		if(nowPage == null || nowPage.equals("")) current_page = 1; 
		else current_page = Integer.parseInt(nowPage);
		
		total_page = totalCount / list_setup_count;  // 몫 : 2
		int rest = 	totalCount % list_setup_count;   // 나머지:1
		if(rest !=0) total_page = total_page + 1;     // 3
		
		int start = (current_page -1) * list_setup_count + 1;
		int end   = current_page * list_setup_count;
		/* paging 설정 end*/	
		
		
		ArrayList<ReplyDto> arr = reDao.getReplyList(order_coment,start,end,no);
		
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		
		String today = CommonUtil.getToday();
		String todayTime = CommonUtil.getTodayTime();
		request.setAttribute("t_today", today);
		request.setAttribute("t_todayTime", todayTime);
		request.setAttribute("t_order_coment", order_coment);
		request.setAttribute("t_paging", paging);
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
		
	}

}
