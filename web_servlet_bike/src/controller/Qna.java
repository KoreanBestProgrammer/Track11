package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.qna.QnaAnswerDelete;
import command.qna.Qnaanswer;
import command.qna.Qnadelete;
import command.qna.Qnalist;
import command.qna.Qnaupdate;
import command.qna.Qnaview;
import command.qna.Qnawrite;
import common.CommonToday;

/**
 * Servlet implementation class Qna
 */
@WebServlet("/Qna")
public class Qna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qna() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		
		if(gubun == null) gubun = "qnalist";
		String viewPage = "";
		
		request.setAttribute("t_nowPage", "qna");
		
		if(gubun.equals("qnalist")) {
			Qnalist qna = new Qnalist();
			qna.execute(request);
			viewPage = "qna/qna_list.jsp";
			
		}else if(gubun.equals("qnawriteform")) {
			CommonToday qna = new CommonToday();
			qna.execute(request);
			viewPage = "qna/qna_write.jsp";
			
		}else if(gubun.equals("qnawrite")) {
			Qnawrite qna = new Qnawrite();
			qna.execute(request);
			viewPage="common_alert.jsp";
			
		}else if(gubun.equals("qnaview")) {
			Qnaview qna = new Qnaview();
			qna.execute(request);
			viewPage = "qna/qna_view.jsp";
			
		}else if(gubun.equals("qnaupdateform")) {
			Qnaview qna = new Qnaview();
			qna.execute(request);
			viewPage = "qna/qna_updateForm.jsp";
			
		}else if(gubun.equals("qnaupdate")) {
			Qnaupdate qna = new Qnaupdate();
			qna.execute(request);
			viewPage="common_alert.jsp";
			
		}else if(gubun.equals("qnadelete")) {
			Qnadelete qna = new Qnadelete();
			qna.execute(request);
			viewPage="common_alert.jsp";
			
		}else if(gubun.equals("answerform")) {
			Qnaview qna = new Qnaview(); 
			qna.execute(request);
			viewPage = "qna/qna_answerForm.jsp";
			
		}else if(gubun.equals("answer")) {
			Qnaanswer qna = new Qnaanswer();
			qna.execute(request);
			viewPage="common_alert.jsp";
		}
		
		else if(gubun.equals("qnaanswerdelete")) {
			QnaAnswerDelete qna = new QnaAnswerDelete();
			qna.execute(request);
			viewPage="common_alert.jsp";
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
