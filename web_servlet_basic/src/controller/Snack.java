package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.DBSnackSave;
import command.member.DBSnackUpdate;
import command.member.SnackDelete;
import command.member.SnackList;
import command.member.SnackSave;
import command.member.SnackUpdate;
import command.member.SnackView;

/**
 * Servlet implementation class Snack
 */
@WebServlet("/Snack")
public class Snack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Snack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun="list";
		String viewPage = "";
		
		//리스트
		if(gubun.equals("list")) {
			SnackList snack = new SnackList();
			snack.execute(request);
			viewPage = "snack/snack_list.jsp";
		//등록폼	
		}else if(gubun.equals("writeForm")) {
			SnackSave snack = new SnackSave();
			snack.execute(request);
			viewPage = "snack/snack_write.jsp";
		//등록	
		}else if(gubun.equals("snackSave")) {
			DBSnackSave snack = new DBSnackSave();
			snack.execute(request);
			viewPage = "common_alert.jsp";
		//상세보기	
		}else if(gubun.equals("snackView")) {
			SnackView snack = new SnackView();
			snack.execute(request);
			viewPage = "snack/snack_view.jsp";
		//수정폼
		}else if(gubun.equals("goUpdateForm")) {
			SnackUpdate snack = new SnackUpdate();
			snack.execute(request);
			viewPage = "snack/snack_update.jsp";
		//수정	
		}else if(gubun.equals("snackUpdate")) {
			DBSnackUpdate snack = new DBSnackUpdate();
			snack.execute(request);
			viewPage = "common_alert.jsp";
		//삭제	
		}else if(gubun.equals("snackDelete")) {
			SnackDelete snack = new SnackDelete();
			snack.execute(request);
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
