package command.product;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;

public class ProductDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		
		String no = request.getParameter("t_no");
		String nowAttach = request.getParameter("t_nowAttach");
		
		int result = dao.getDeleteProduct(no);
	
		String msg = "삭제실패!";
		boolean tf = true;
		
		if(result == 1) {
			File file = new File(CommonUtil.getFile_dir("product"), nowAttach);
			tf = file.delete();
			if(!tf) System.out.println("첨부파일 삭제 오루!");
		}
		
		if(result == 1 && tf) {
			msg="삭제성공!";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");
		
	}

}
