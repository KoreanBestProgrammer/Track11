package command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		
		String select = request.getParameter("t_select");
		String count = request.getParameter("t_displayCount");
		String search = request.getParameter("t_search");
		String productLevel = request.getParameter("t_productLevel");
		
		if(select == null) {
			select = "product_name";
			search = "";
			count = "5";
			productLevel = "";
		}
		
		/* paging 설정 start*/
		int totalCount = dao.getTotalCount(select,search,productLevel);
		int list_setup_count = Integer.parseInt(count);  //한페이지당 출력 행수 
		int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
		
		String nowPage = request.getParameter("t_nowPage");
		int current_page = 0; // 현재페이지 번호
		int total_page = 0;    // 전체 페이지 수
		
		if(nowPage == null || nowPage.equals("")) current_page = 1; 
		else current_page = Integer.parseInt(nowPage);
		
		total_page = totalCount / list_setup_count;  // 몫 : 2
		int rest = 	totalCount % list_setup_count;   // 나머지:1
		if(rest !=0) total_page = total_page + 1;     // 3
		
		int start = (current_page -1) * list_setup_count + 1;
		int end   = current_page * list_setup_count;
		/* paging 설정 end*/	
		
		int order = totalCount - ((current_page - 1)*list_setup_count);
		
		ArrayList<ProductDto> arr = dao.getListProduct(select,search,start,end,productLevel);
		
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		
		request.setAttribute("t_productLevel", productLevel);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_count", count);
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_paging", paging);
		request.setAttribute("t_order", order);
		request.setAttribute("t_totalCount", totalCount);

	}

}
