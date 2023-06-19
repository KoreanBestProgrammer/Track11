package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.news.NewsDelete;
import command.news.NewsList;
import command.news.NewsSave;
import command.news.NewsUpdate;
import command.news.NewsView;
import common.CommonToday;

/**
 * Servlet implementation class News
 */
@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public News() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		String viewPage = "";
		
		request.setAttribute("t_nowPage", "news");
		
		//리스트
		if(gubun.equals("list")) {
			NewsList news = new NewsList();
			news.execute(request);
			viewPage = "news/news_list.jsp";
		//등록 폼	
		}else if(gubun.equals("writeForm")) {
			CommonToday news = new CommonToday();
			news.execute(request);
			viewPage = "news/news_write.jsp";
		//등록		
		}else if(gubun.equals("save")) {
			NewsSave news = new NewsSave();
			news.execute(request);
			viewPage = "common_alert.jsp";
		//뷰	
		}else if(gubun.equals("view")) {
			NewsView news = new NewsView();
			news.execute(request);
			viewPage = "news/news_view.jsp";
		//업데이트 폼	
		}else if(gubun.equals("updateForm")) {
			NewsView news = new NewsView();
			news.execute(request);
			viewPage = "news/news_update.jsp";
		//업데이트	
		}else if(gubun.equals("update")) {
			NewsUpdate news = new NewsUpdate();
			news.execute(request);
			viewPage = "common_alert.jsp";
		//삭제	
		}else if(gubun.equals("delete")) {
			NewsDelete news = new NewsDelete();
			news.execute(request);
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
