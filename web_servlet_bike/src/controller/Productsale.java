package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberMyinfo;
import command.product.ProductView;
import command.productsale.ProductPurchase;

/**
 * Servlet implementation class Productsale
 */
@WebServlet("/Productsale")
public class Productsale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productsale() {
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
			gubun = "myorder";
		}
		
		if(gubun.equals("purchaseForm")) {
			ProductView product = new ProductView();
			product.execute(request);
			viewPage="Productsale/Productsale_purchase.jsp";
		}else if(gubun.equals("purchase")) {
			ProductPurchase product = new ProductPurchase();
			product.execute(request);
			viewPage="common_alert.jsp";
		}else if(gubun.equals("myorder")) {
			
			viewPage = "Productsale/Productsale_myorder.jsp";
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
