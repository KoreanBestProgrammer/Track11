package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;
import dto.ProductDto;

public class ProductView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		
		String no = request.getParameter("t_no");
		
		dao.getHit(no);
		
		ProductDto dto = dao.getProductView(no);
		//이전글
		ProductDto preDto = dao.getPreView(no);
		//다음글
		ProductDto nextDto = dao.getNextView(no);	
		
		
		
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
		request.setAttribute("t_dto", dto);

	}

}
