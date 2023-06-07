package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.QnaDto;

public class QnaDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//no
	public String getMaxNO() {
		String no = "";
		String query = "select nvl(max(no),'N000') as no from home_김용석_qna";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no"); // "N001"
				no = no.substring(1); // "001"
			    int intNo = Integer.parseInt(no); //1
			    intNo = intNo + 1; //2
			    DecimalFormat df = new DecimalFormat("N000");
			    no = df.format(intNo); //"N002"
			    
			}
		}catch(Exception e) {
			System.out.println("쿼리문 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return no;
	}
	//등록
	public int getSaveQna(QnaDto dto) {
		int result = 0;
		String query="insert into home_김용석_qna\r\n" + 
				     "(no,title,content,reg_id,reg_date,state)\r\n" + 
				     "values('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'),'"+dto.getState()+"'\r\n" + 
				     ")";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리문 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	// list조회
	public ArrayList<QnaDto> getListQna(String gubun, String search){
		ArrayList<QnaDto> arr = new ArrayList<>();
		String query = "select q.no,q.title,q.content,q.state,q.reg_id,to_char(q.reg_date,'yyyy-mm-dd') as reg_date,m.name,q.hit,q.answer\r\n" + 
				       "from home_김용석_qna q, home_김용석_member m\r\n" + 
				       "where q.reg_id = m.id\r\n" + 
				       "and "+gubun+" like '%"+search+"%'\r\n" + 
				       "order by q.no desc";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String state = rs.getString("state");
				String reg_id = rs.getString("reg_id");
				String reg_date = rs.getString("reg_date");
				String name = rs.getString("name");
				int hit = rs.getInt("hit");
				String answer = rs.getString("answer");
				
				QnaDto dto = new QnaDto(no,title,content,state,reg_id,reg_date,name,hit,answer);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	//view
	public QnaDto getQnaView(String no) {
		QnaDto dto = null;
		String query = "select q.no,q.title,q.reg_id,q.content,m.name,to_char(q.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date,\r\n" + 
				       "to_char(q.update_date,'yyyy-mm-dd hh24:mi:ss') as update_date,q.hit,q.answer,q.answerid\r\n" + 
				       "from home_김용석_qna q, home_김용석_member m\r\n" + 
				       "where q.reg_id = m.id\r\n" + 
				       "and q.no = '"+no+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String reg_id = rs.getString("reg_id");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				String answer = rs.getString("answer");
				String answerid = rs.getString("answerid");
				int hit = rs.getInt("hit");
				
				
				dto = new QnaDto(no,title,reg_id,content,reg_date,update_date,name,answer,answerid,hit);
			}
		}catch(Exception e) {
			System.out.println("쿼리문 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	//hit
	public void getHit(String no) {
		String query="update home_김용석_qna\r\n" + 
				     " set hit = hit + 1\r\n" + 
				     " where no = '"+no+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			int result=ps.executeUpdate();
			if(result == 0) System.out.println("공지사항 조회수 증가 오류");
		}catch(Exception e) {
			System.out.println("쿼리문 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	//답변
	public int getQnaReply(QnaDto dto) {
		int result = 0;
		String query="update home_김용석_qna\r\n" + 
				     "    set answer = '"+dto.getAnswer()+"',\r\n" + 
				     "        answerid = '"+dto.getAnswerid()+"',\r\n" + 
				     "        update_date = to_date('"+dto.getUpdate_date()+"','yyyy-mm-dd hh24:mi:ss')\r\n" + 
				     "where no = '"+dto.getNo()+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	//이전글
	public QnaDto getPreView(String no) {
		QnaDto dto = null;
		String query = "select a.no,b.title\r\n" + 
					   "from\r\n" + 
					   "(select max(no) as no from home_김용석_qna\r\n" + 
					   "where no < '"+no+"') a, home_김용석_qna b\r\n" + 
					   "where a.no = b.no";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				String title = rs.getString("title");
				
				dto = new QnaDto(preNo,title);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	//다음글
	public QnaDto getNextView(String no) {
		QnaDto dto = null;
		String query = "select a.no,b.title\r\n" + 
				       "from\r\n" + 
				       "(select min(no) no from home_김용석_qna\r\n" + 
				       "where no > '"+no+"') a, home_김용석_qna b\r\n" + 
				       "where a.no = b.no";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String nextNo = rs.getString("no");
				String title = rs.getString("title");
				
				dto = new QnaDto(nextNo,title);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
     //삭제
	public int getQnaDelete(String no) {
		int result = 0;
		String query="delete from home_김용석_qna\r\n" + 
				"where no = '"+no+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	//수정
	public int getQnaUpdate(String no,String title,String content) {
		int result = 0;
		String query="update home_김용석_qna\r\n" + 
				     "    set title = '"+title+"',\r\n" + 
				     "        content = '"+content+"'\r\n" + 
				     "where no = '"+no+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//답변수정
	public int getQnaReplyUpdate(String no,String answer) {
		int result = 0;
		String query="update home_김용석_qna\r\n" + 
				     "    set answer = '"+answer+"'\r\n" + 
				     "where no = '"+no+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	//답변삭제
	public int getDeleteReply(String no) {
		int result=0;
		String query="update home_김용석_qna\r\n" + 
					 "    set answer = ''\r\n" + 
					 "where no = '"+no+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	public int getTotalCount(String gubun,String search) {
		int count = 0;
		String query ="select count(*) as count from home_김용석_qna q\r\n" + 
				"where "+gubun+" like '%"+search+"%'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();{
				if(rs.next()) {
					count=rs.getInt("count");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	public ArrayList<QnaDto> getListQnaPage(String gubun, String search, int start, int end){
		ArrayList<QnaDto> arr = new ArrayList<>();
		String query = "select * from\r\n" + 
				"(select rownum as rnum, tbl.* from\r\n" + 
				"(select q.no,q.title,q.content,q.state,q.reg_id,to_char(q.reg_date,'yyyy-mm-dd') as reg_date,m.name,q.hit,q.answer\r\n" + 
				"from home_김용석_qna q, home_김용석_member m\r\n" + 
				"where q.reg_id = m.id\r\n" + 
				"and "+gubun+" like '%"+search+"%'\r\n" + 
				"order by q.no desc)tbl)\r\n" + 
				"where rnum >= "+start+" and rnum <= "+end+"";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String state = rs.getString("state");
				String reg_id = rs.getString("reg_id");
				String reg_date = rs.getString("reg_date");
				String name = rs.getString("name");
				int hit = rs.getInt("hit");
				String answer = rs.getString("answer");
				
				QnaDto dto = new QnaDto(no,title,content,state,reg_id,reg_date,name,hit,answer);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return arr;
	}
}
