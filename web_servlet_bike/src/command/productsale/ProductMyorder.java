package command.productsale;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductsaleDao;
import dto.ProductsaleDto;

public class ProductMyorder implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductsaleDao dao = new ProductsaleDao();
		
		String d_no = request.getParameter("t_d_no");
		
		ProductsaleDto dto = dao.getMyorderView(d_no);
		//이전뷰
		String preD_no = dao.getMyorderPreView(d_no);
		//다음뷰
		String nextD_no = dao.getMyorderNextView(d_no);
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preD_no", preD_no);
		request.setAttribute("t_nextD_no", nextD_no);
	}

}
