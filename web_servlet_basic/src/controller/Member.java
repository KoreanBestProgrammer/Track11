package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberDelete;
import command.member.MemberList;
import command.member.MemberSave;
import command.member.MemberUpdate;
import command.member.MemberView;
import common.CommonExecute;


/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("t_gubun");
		String viewPage = "";
		if(gubun == null) {
			gubun = "list";
		}
		
		//목록
		if(gubun.equals("list")) {		
			MemberList member = new MemberList();
			member.execute(request);
//			viewPage = "member/member_list.jsp";
			viewPage = "member/member_list_jstl.jsp";
			
		//등록폼
		}else if(gubun.equals("writeForm")) {
			viewPage = "member/member_write.jsp";
			
		//저장	
		}else if(gubun.equals("memberSave")) {
			MemberSave member = new MemberSave();
			member.execute(request);
//			response.sendRedirect("Member");
			viewPage = "common_alert.jsp";
			
		//상세보기	
		}else if(gubun.equals("memberView")) {
			CommonExecute member = new MemberView();
			member.execute(request);
//			viewPage = "member/member_view.jsp";
			viewPage = "member/member_view_jstl.jsp";
			
		//수정폼
		}else if(gubun.equals("updateForm")) {
			MemberView member = new MemberView();
			member.execute(request);
//			viewPage = "member/member_update.jsp";
			viewPage = "member/member_update_jstl.jsp";
			
		//수정	
		}else if(gubun.equals("memberUpdate")) {
			MemberUpdate member = new MemberUpdate();
			member.execute(request);
//			response.sendRedirect("Member");
			viewPage = "common_alert.jsp";
			
		//삭제	
		}else if(gubun.equals("memberDelete")) {
			MemberDelete member = new MemberDelete();
			member.execute(request);
//			response.sendRedirect("Member");
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
