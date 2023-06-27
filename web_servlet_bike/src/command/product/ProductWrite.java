package command.product;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		
		HttpSession session = request.getSession();
		
		try {
			MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir("product"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			
			
			String no = dao.getProductNo();
			String product_name = mpr.getParameter("t_name");
			String product_explain = mpr.getParameter("t_explain");
			String product_size = mpr.getParameter("t_size");
			String product_price = mpr.getParameter("t_price");
			String ranking = mpr.getParameter("t_rank");
			String product_photo = mpr.getFilesystemName("t_attach");
			if(product_photo == null) product_photo = "";
			String reg_id = (String)session.getAttribute("sessionId"); 
			String reg_date = CommonUtil.getTodayTime();
			ProductDto dto = new ProductDto(no, product_name, product_explain, product_size, product_price, product_photo, ranking, reg_date, reg_id);
			int result = dao.getSaveProduct(dto);
		
			String msg = "등록성공!";
			
			if(result != 1) {
				msg = "등록실패!";	
			}
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "Product");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
