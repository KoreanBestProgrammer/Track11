package command.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;



import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		
		String msg = "수정성공!";
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("product"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			
			String no = mpr.getParameter("t_no");
			String product_name = mpr.getParameter("t_product_name");
			String product_explain = mpr.getParameter("t_product_explain");
			String product_price = mpr.getParameter("t_product_price");
			String product_size = mpr.getParameter("t_product_size");
			String ranking = mpr.getParameter("t_ranking");
			String product_photo = mpr.getFilesystemName("t_product_photo");
			if(product_photo == null) product_photo = "";
			String oriAttach = mpr.getParameter("t_oriAttach");
			String update_date = CommonUtil.getTodayTime();
			
			String saveAttachName = oriAttach;
			
			//첨부파일 재첨부
			if(!product_photo.equals("")) {
				File file = new File(CommonUtil.getFile_dir("product"), oriAttach);
				boolean tf = file.delete();
				if(!tf) System.out.println("첨부파일 삭제 오류!"+tf);
				saveAttachName = product_photo;
			}
			
			ProductDto dto = new ProductDto(no, product_name, product_explain, product_size, update_date, product_price, saveAttachName, ranking);
			int result = dao.getUpdateProduct(dto);
			
			
			
			if(result != 1) {
				msg = "수정오류!";
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");
		
	}

}
