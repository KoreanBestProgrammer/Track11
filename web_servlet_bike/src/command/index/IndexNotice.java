package command.index;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.NoticeDao;
import dao.ProductDao;
import dto.NoticeDto;
import dto.ProductDto;

public class IndexNotice implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		ProductDao proDao = new ProductDao();
		
		String select="n.no";
		String search="";
		int start=1;
		int end=7;
				
		ArrayList<ProductDto> proArr = proDao.getListProductIndex();
		ArrayList<NoticeDto> arr = dao.getNoticeListPage(select, search, start, end);

		request.setAttribute("t_proArr", proArr);
		request.setAttribute("t_arr", arr);	
		
		
	}

}
