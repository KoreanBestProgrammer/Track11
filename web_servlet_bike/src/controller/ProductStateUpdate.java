package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.ProductsaleDao;
import dto.ProductsaleDto;

/**
 * Servlet implementation class ProductStateUpdate
 */
@WebServlet("/ProductStateUpdate")
public class ProductStateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductStateUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ProductsaleDao dao = new ProductsaleDao();
		
		String d_no = request.getParameter("t_d_no");
		String d_state = request.getParameter("t_select_state");
		String d_date = "";
		
		if(d_state.equals("배송완료")) {
			d_date = CommonUtil.getTodayTime();
		}
		
		ProductsaleDto dto = new ProductsaleDto(d_no, d_state, d_date);
		
		int result = dao.getUpdateState(dto);
		
		
		
		if(result == 1) {
			out.print(d_date);
			out.print("*"+d_state);
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
