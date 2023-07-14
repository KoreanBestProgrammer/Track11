package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonToday;
import common.freeboard.FreeDelete;
import common.freeboard.FreeList;
import common.freeboard.FreeUpdate;
import common.freeboard.FreeView;
import common.freeboard.FreeWrite;



/**
 * Servlet implementation class Freeboard
 */
@WebServlet("/Freeboard")
public class Freeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Freeboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("t_nowPage", "freeboard");
		
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		
		String viewPage = "";
		
		if(gubun.equals("list")) {
			FreeList free = new FreeList();
			free.execute(request);
			viewPage = "freeboard/freeboard_list.jsp";
			
		}else if(gubun.equals("writeform")) {
			CommonToday free = new CommonToday();
			free.execute(request);
			viewPage = "freeboard/freeboard_writeForm.jsp";
		
		}else if(gubun.equals("save")) {
			FreeWrite free = new FreeWrite();
			free.execute(request);
			viewPage = "common_alert.jsp";
			
		}else if(gubun.equals("view")) {
			FreeView free = new FreeView();
			free.execute(request);
			viewPage = "freeboard/freeboard_view.jsp";
			
		}else if(gubun.equals("updateform")) {
			FreeView free = new FreeView();
			free.execute(request);
			viewPage = "freeboard/freeboard_updateForm.jsp";
			
		}else if(gubun.equals("update")) {
			FreeUpdate free = new FreeUpdate();
			free.execute(request);
			viewPage = "common_alert.jsp";
			
		}else if(gubun.equals("delete")) {
			FreeDelete free = new FreeDelete();
			free.execute(request);
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
