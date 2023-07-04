package command.productsale;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductsaleDao;
import dto.ProductsaleDto;

public class ProductPurchase implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductsaleDao dao = new ProductsaleDao();
		 
		String d_no = dao.getDeliveryNo();
		String p_no = request.getParameter("t_no");
		String d_state = request.getParameter("t_state");
		String c_id = request.getParameter("t_customerid");
		String d_email = request.getParameter("t_email");
		String d_address = request.getParameter("t_address");
		String price = request.getParameter("t_price");
		String purchase_way = request.getParameter("t_purchaseway");
		String purchase_date = CommonUtil.getTodayTime();
		
		if(purchase_way.equals("카드")) {
			d_state = "배송중";
		}
		
		ProductsaleDto dto = new ProductsaleDto(d_no, p_no, d_state, c_id, d_email, d_address, purchase_way, price, purchase_date);
		
		String msg = "구매완료!";
		
		int result = dao.getPurchaseSave(dto);
		
		if(result != 1) {
			msg = "구매실패!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Productsale?t_gubun=myorder");
	}

}
