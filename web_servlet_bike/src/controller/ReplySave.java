package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.CommonUtil;
import dao.ReplyDao;
import dto.ReplyDto;

/**
 * Servlet implementation class ReplySave
 */
@WebServlet("/ReplySave")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ReplyDao dao = new ReplyDao();
		
		String c_no = dao.getC_no();
		String noname = request.getParameter("t_noname");
		String no = request.getParameter("t_no");
		String reply = request.getParameter("t_reply");
		String reply_date = CommonUtil.getTodayTime();
		
		HttpSession session = request.getSession();
		String reply_name = (String)session.getAttribute("sessionName");
		 
		
		ReplyDto dto = new ReplyDto(c_no, no, noname ,reply, reply_date, reply_name);
		
		int result = dao.getReplySave(dto);
		
		
		/*HashMap<String, Object> hM = new HashMap<String, Object>();
		hM.put("reply",reply);
		JSONObject jsob = new JSONObject();
		JSONArray jsar = new JSONArray();
		jsob.put("reply_date", reply_date);
		jsob.put("reply", reply);
		jsob.put("no",no);
		jsar.add(jsob);
		
		jsob.put("reply_date", reply_date);
		jsob.put("reply", reply);
		jsob.put("no",no);
		jsar.add(jsob);
		
		jsob.put("reply_date", reply_date);
		jsob.put("reply", reply);
		jsob.put("no",no);
		jsar.add(jsob);
		
		jsob.put("reply_date", reply_date);
		jsob.put("reply", reply);
		jsob.put("no",no);
		jsar.add(jsob);
		
		jsob.put("reply_date", reply_date);
		jsob.put("reply", reply);
		jsob.put("no",no);
		jsar.add(jsob);
		*/
		
		
		if(result == 1) {
			out.print(reply);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
