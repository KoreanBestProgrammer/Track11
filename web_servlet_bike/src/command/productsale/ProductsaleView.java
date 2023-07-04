package command.productsale;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductsaleDao;
import dto.ProductsaleDto;

public class ProductsaleView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductsaleDao dao = new ProductsaleDao();
		
		String d_no = request.getParameter("t_d_no");
		
		
		//뷰
		ProductsaleDto dto = dao.getProductsaleView(d_no);
		//이전뷰
		ProductsaleDto preDto = dao.getProductsalePreView(d_no);
		//다음뷰
		ProductsaleDto nextDto = dao.getProductsaleNextView(d_no);		
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
	}

}
