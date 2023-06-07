package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Tdto;

/**
 * Servlet implementation class TestTwo
 */
@WebServlet("/TestTwo")
public class TestTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = "홍길동";
		int age = 25;
		
		request.setAttribute("t_name", name);
		request.setAttribute("t_age", age);
		
		Tdto dto = new Tdto("김정은","평양",39);
		request.setAttribute("t_dto", dto);
		
		ArrayList<Tdto> arr = new ArrayList<>();
		arr.add(new Tdto("바이든","워싱턴 dc",75));
		arr.add(new Tdto("푸틴","모스크바",65));		
		request.setAttribute("t_arr", arr);
	
		
		RequestDispatcher rd = request.getRequestDispatcher("test_two.jsp");
				
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
