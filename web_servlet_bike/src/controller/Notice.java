package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.notice.NoticeDelete;
import command.notice.NoticeList;
import command.notice.NoticeSave;
import command.notice.NoticeUpdate;
import command.notice.NoticeView;
import common.CommonToday;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
     
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		String viewPage = "";
				
		//리스트
		if(gubun.equals("list")) {
			NoticeList notice = new NoticeList();
			notice.execute(request);
			viewPage = "notice/notice_list.jsp";	
		//등록 폼	
		}else if(gubun.equals("writeForm")) {
			CommonToday notice = new CommonToday();
			notice.execute(request);
			viewPage = "notice/notice_write.jsp";	
		//등록	
		}else if(gubun.equals("save")) {
			NoticeSave notice = new NoticeSave();
			notice.execute(request);
			viewPage = "common_alert.jsp";
		//뷰	
		}else if(gubun.equals("view")) {
		NoticeView notice = new NoticeView();
		notice.execute(request);	
		viewPage = "notice/notice_view.jsp";
		//업데이트 폼	
		}else if(gubun.equals("updateForm")) {
		NoticeView notice = new NoticeView();
		notice.execute(request);
		viewPage = "notice/notice_update.jsp";
		//업데이트	
		}else if(gubun.equals("update")) {
		NoticeUpdate notice = new NoticeUpdate();
		notice.execute(request);
		viewPage = "common_alert.jsp";
		//삭제	
		}else if(gubun.equals("delete")) {
		NoticeDelete notice = new NoticeDelete();
		notice.execute(request);
		viewPage = "common_alert.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
