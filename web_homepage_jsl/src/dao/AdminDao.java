package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.MemberDto;

public class AdminDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void getLastLogin(String id) {
		String query = "update home_김용석_member \r\n" + 
				"    set login_date = to_date('"+CommonUtil.getTodayTime()+"','yyyy-mm-dd hh24;mi:ss')\r\n" + 
				"    where id = '"+id+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			int k = ps.executeUpdate();
			if(k != 1) System.out.println("실패!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	public ArrayList<MemberDto> getAdminList(String gubun, String search){
		ArrayList<MemberDto> arr = new ArrayList<>();
		String query = "select id,name,mobile,\r\n" + 
				"email,to_char(reg_date,'yyyy-mm-dd')as reg_date,tal\r\n" + 
				"from home_김용석_member\r\n" + 
				"where "+gubun+" like '%"+search+"%'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				String tal = rs.getString("tal");
				
				MemberDto dto = new MemberDto(id,name,mobile,email,reg_date,tal);
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
	public int getTotalCount(String gubun,String search) {
		int count=0;
		String query="select count(*) as count\r\n" + 
				"from home_김용석_member\r\n" + 
				"where "+gubun+" like '%"+search+"%'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	public ArrayList<MemberDto> getAdminListPage(String gubun,String search,int start, int end){
		ArrayList<MemberDto> arr = new ArrayList<>();
		String query="select * from\r\n" + 
				"(select rownum as rnum, tbl.* from\r\n" + 
				"(select id,name,mobile,\r\n" + 
				"email,to_char(reg_date,'yyyy-mm-dd')as reg_date,tal\r\n" + 
				"from home_김용석_member\r\n" + 
				"where "+gubun+" like '%"+search+"%')tbl)\r\n" + 
				"where rnum >= "+start+" and rnum <= "+end+"";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				String tal = rs.getString("tal");
				
				MemberDto dto = new MemberDto(id,name,mobile,email,reg_date,tal);
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
	public MemberDto getAdminView(String id) {
		MemberDto dto = null;
		String query="select id,name,password,job,tell_1,tell_2,tell_3,mobile,email,"
				+ " to_char(reg_date,'yyyy-mm-dd') as reg_date,"
				+ " to_char(login_date,'yyyy-mm-dd hh24:mi:ss') as login_date,"
				+ " tal,pwleng from home_김용석_member\r\n" + 
				     "where id = '"+id+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String job = rs.getString("job");
				String tell_1 = rs.getString("tell_1");
				String tell_2 = rs.getString("tell_2");
				String tell_3 = rs.getString("tell_3");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				String login_date = rs.getString("login_date");
				String tal = rs.getString("tal");
				String pwleng = rs.getString("pwleng");
				
				dto = new MemberDto(id,name,password,job,tell_1,tell_2,tell_3,mobile,email,reg_date,login_date,tal,pwleng);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
}
