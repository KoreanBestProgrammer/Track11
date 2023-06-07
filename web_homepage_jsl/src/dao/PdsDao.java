package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.PdsDto;

public class PdsDao {

	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public String getMaxNo() {
		String no = "";
		String query= "select nvl(max(no),'N000') as no from home_김용석_pds ";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no"); //	"N001"
				no = no.substring(1); // "001"
				int n = Integer.parseInt(no); // 1
				n += 1; // 2 -> "002"
				
				DecimalFormat df = new DecimalFormat("N000");
				no = df.format(n); // "N002"
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return no;
	}
		
	public int getSavePds(PdsDto dto) {
		int result = 0;
		String query="insert into home_김용석_pds\r\n" + 
				"(no,title,content,attach,reg_id,reg_date)\r\n" + 
				"values('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss')\r\n" + 
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
	public ArrayList<PdsDto> getListPds(String gubun,String search){
		ArrayList<PdsDto> arr = new ArrayList<>();
		String query = "select p.no,p.title,p.attach,m.name,to_char(p.reg_date,'yyyy-mm-dd') as reg_date,p.hit from\r\n" + 
				"home_김용석_pds p, home_김용석_member m\r\n" + 
				"where p.reg_id = m.id\r\n" + 
				"and "+gubun+" like '%"+search+"%'\r\n" + 
				"order by no desc";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String attach = rs.getString("attach");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				
				PdsDto dto = new PdsDto(no,title,attach,name,reg_date,hit);
				
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
	public PdsDto getViewPds(String no) {
		PdsDto dto = null;
		String query = "select p.no,p.title,p.content,p.attach,m.name,to_char(p.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date,p.hit,to_char(p.update_date,'yyyy-mm-dd hh24:mi:ss') as update_date from\r\n" + 
				"home_김용석_pds p, home_김용석_member m\r\n" + 
				"where p.reg_id = m.id\r\n" + 
				"and p.no = '"+no+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String attach = rs.getString("attach");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				int hit = rs.getInt("hit");
				
				dto = new PdsDto(no,title,content,attach,name,reg_date,hit,update_date);
				
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return dto;
	}
	public void getHit(String no) {
		String query="update home_김용석_pds\r\n" + 
				"    set hit = hit+1\r\n" + 
				"    where no = '"+no+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("공지사항 조회수 증가 오류");
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}
	//이전
	public PdsDto getPrePds(String no) {
		PdsDto dto = null;
		String query="select a.no,b.title from\r\n" + 
				"(select max(no) as no from home_김용석_pds\r\n" + 
				"where no < '"+no+"') a, home_김용석_pds b\r\n" + 
				"where a.no = b.no";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				String title = rs.getString("title");
				
				dto = new PdsDto(preNo,title);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	public PdsDto getNextPds(String no) {
		PdsDto dto = null;
		String query="select a.no,b.title from\r\n" + 
				"(select min(no) as no from home_김용석_pds\r\n" + 
				"where no > '"+no+"') a, home_김용석_pds b\r\n" + 
				"where a.no = b.no";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String nextNo = rs.getString("no");
				String title = rs.getString("title");
				
				dto = new PdsDto(nextNo,title);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	public int getTotalCount(String gubun,String search) {
		int count = 0;
		String query="select count(*) as count from home_김용석_pds p\r\n" + 
				"where "+gubun+" like '%"+search+"%'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return count;
	}
	public ArrayList<PdsDto> getListPds(String gubun,String search, int start, int end){
		ArrayList<PdsDto> arr = new ArrayList<>();
		String query="select * from\r\n" + 
					 "(select rownum as rnum , tbl.* from \r\n" + 
					 "(select p.no,p.title,p.attach,m.name,to_char(p.reg_date,'yyyy-mm-dd') as reg_date,p.hit from\r\n" + 
					 "home_김용석_pds p, home_김용석_member m\r\n" + 
					 "where p.reg_id = m.id\r\n" + 
					 "and "+gubun+" like '%"+search+"%'\r\n" + 
					 "order by no desc) tbl )\r\n" + 
					 "where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String attach = rs.getString("attach");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				
				PdsDto dto = new PdsDto(no,title,attach,name,reg_date,hit);
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
	public int getUpdatePds(PdsDto dto) {
		int result = 0;
		String query="update home_김용석_pds\r\n" + 
				"    set title='"+dto.getTitle()+"',\r\n" + 
				"        content='"+dto.getContent()+"',\r\n" + 
				"        update_date=to_date('"+dto.getUpdate_date()+"','yyyy-mm-dd hh24:mi:ss'),\r\n" + 
				"        attach='"+dto.getAttach()+"'\r\n" + 
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
	public int getDeletePds(String no) {
		int result=0;
		String query="delete from home_김용석_pds\r\n" + 
					 " where no = '"+no+"'";
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
}
