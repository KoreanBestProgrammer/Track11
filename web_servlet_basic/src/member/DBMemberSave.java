package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member_dao;
import dto.Member_dto;

/**
 * Servlet implementation class DBMemberSave
 */
@WebServlet("/DBMemberSave")
public class DBMemberSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBMemberSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member_dao dao = new Member_dao();
				
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String age = request.getParameter("t_age");
		String reg_date = request.getParameter("t_reg_date");
		
		Member_dto dto = new Member_dto(id,name,Integer.parseInt(age),reg_date);
		int result = dao.MemberSave(dto);
		
		String url = "MemberList";
		String msg = "등록성공!";
		if(result != 1) {
			msg = "등록실패~";
			url = "MemberWrite";
		}	
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
		RequestDispatcher rd = request.getRequestDispatcher("common_alert.jsp");
		rd.forward(request, response);
		
		
		
//		response.sendRedirect("MemberList");
		
		//ArrayList<Member_dto> arr = dao.getMemberList("id", "");
		//request.setAttribute("t_arr", arr);
		//request.setAttribute("t_select", "id");
		//request.setAttribute("t_search", "");
		
		//RequestDispatcher rd = request.getRequestDispatcher("member/member_list.jsp");
		//rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
