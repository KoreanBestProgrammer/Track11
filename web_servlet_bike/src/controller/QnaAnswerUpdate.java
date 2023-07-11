package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

/**
 * Servlet implementation class QnaAnswerUpdate
 */
@WebServlet("/QnaAnswerUpdate")
public class QnaAnswerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaAnswerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaDao dao = new QnaDao();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String no = request.getParameter("t_no");
		String answer = request.getParameter("t_answer");
		String admin_update_date = CommonUtil.getTodayTime();
		
		QnaDto dto = new QnaDto(no, answer, admin_update_date);
		
		int result = dao.getAnswerUpdate(dto);
		
		if(result == 1) {
			out.print(admin_update_date);
			out.print(answer);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
