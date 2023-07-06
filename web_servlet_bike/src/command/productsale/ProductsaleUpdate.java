package command.productsale;

import javax.servlet.http.HttpServletRequest;


import common.CommonExecute;
import common.CommonUtil;
import dao.ProductsaleDao;
import dto.ProductsaleDto;

public class ProductsaleUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductsaleDao dao = new ProductsaleDao();
		
			String d_no = request.getParameter("t_d_no");
			String d_state = request.getParameter("t_select_state");
			String d_date = "";
			if(d_state.equals("배송완료")) {
				 d_date = CommonUtil.getTodayTime();
			}
			
		    ProductsaleDto dto = new ProductsaleDto(d_no, d_state, d_date);
			int result = dao.getUpdateState(dto);
			
			String msg = "변경성공";
			String url = "Productsale";
			
			if(result != 1) {
				msg = "변경실패";
			}
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
		
			
	}

}
