package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonToday;
import common.etc.EtcList;
import common.etc.EtcView;
import common.etc.EtcWrite;


/**
 * Servlet implementation class Etc
 */
@WebServlet("/Etc")
public class Etc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Etc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("t_nowPage", "etc");
		
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		
		String viewPage = "";
		
		if(gubun.equals("list")) {
			EtcList etc = new EtcList();
			etc.execute(request);
			viewPage = "etc/etc_list.jsp";
			
		}else if(gubun.equals("writeform")) {
			CommonToday etc = new CommonToday();
			etc.execute(request);
			viewPage = "etc/etc_writeForm.jsp";
			
		}else if(gubun.equals("save")) {
			EtcWrite etc = new EtcWrite();
			etc.execute(request);
			viewPage = "common_alert.jsp";
			
		}else if(gubun.equals("view")) {
			EtcView etc = new EtcView();
			etc.execute(request);
			viewPage = "etc/etc_view.jsp";
			
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
