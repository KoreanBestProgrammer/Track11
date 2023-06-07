package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.FaqDto;

public class FaqDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//넘버
	public String getMaxNo() {
		String no="";
		String query="select nvl(max(no),'F000') as no\r\n" + 
				     "from home_김용석_faq";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				String subNo = no.substring(1);
				int intNo = Integer.parseInt(subNo);
				intNo = intNo + 1;
				DecimalFormat df = new DecimalFormat("F000");
				no = df.format(intNo);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return no;
	}
	//저장
	public int getSaveFaq(FaqDto dto) {
		int result=0;
		String query="insert into home_김용석_faq\r\n" + 
				     "(no,title,content,reg_id,reg_date)\r\n" + 
				     "values('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss')\r\n" + 
				     ")";
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
	//리스트
	public ArrayList<FaqDto> getFaqList(String gubun,String search,int start,int end){
		ArrayList<FaqDto> arr = new ArrayList<>();
		String query="select * from\r\n" + 
				"(select rownum as rnum, tbl.*from\r\n" + 
				"(select f.no,f.title,f.content,m.name,to_char(f.reg_date,'yyyy-mm-dd') as reg_date ,f.hit,\r\n" + 
				"to_char(f.update_date,'yyyy-mm-dd') as update_date\r\n" + 
				"from home_김용석_faq f, home_김용석_member m\r\n" + 
				"where f.reg_id = m.id\r\n" + 
				"and "+gubun+" like '%"+search+"%'\r\n" + 
				"order by f.no desc)tbl)\r\n" + 
				"where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String content = rs.getString("content");				
				String reg_date = rs.getString("reg_date");
				String name = rs.getString("name");
				int hit = rs.getInt("hit");
				String update_date = rs.getString("update_date");
				FaqDto dto = new FaqDto(no,title,content,reg_date,name,hit,update_date);
				
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	//view
	public FaqDto getFaqView(String no) {
		FaqDto dto = null;
		String query ="select f.no,f.title,f.content,m.name,to_char(f.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date ,f.hit,to_char(f.update_date,'yyyy-mm-dd hh24:mi:ss') as update_date\r\n" + 
				"from home_김용석_faq f, home_김용석_member m\r\n" + 
				"where f.reg_id = m.id\r\n" + 
				"and f.no = '"+no+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				int hit = rs.getInt("hit");
				
				dto = new FaqDto(no,title,content,reg_date,name,update_date,hit);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	//수정
	public int getUpdateFaq(FaqDto dto) {
		int result = 0;
		String query="update home_김용석_faq\r\n" + 
					 "    set title = '"+dto.getTitle()+"',\r\n" + 
					 "        content = '"+dto.getContent()+"',\r\n" + 
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
	//삭제
	public int getDeleteFaq(String no) {
		int result=0;
		String query="delete from home_김용석_faq\r\n" + 
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
		String query="select count(*) as count from home_김용석_faq f \r\n" + 
				"where "+gubun+" like '%"+search+"%'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
}
