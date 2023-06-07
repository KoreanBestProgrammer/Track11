package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Consulting_김용석_dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertConsult(Consulting_김용석_dto dto) {
		int result = 0;
		String query = "insert into E_김용석_CONSULTING "+
				       "(no,sid,mid,cdate) "+
				       "values('"+dto.getId()+"','"+dto.getSid()+"','"+dto.getMid()+"','"
				                 +dto.getDate()+"') ";		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	public ArrayList<Consulting_김용석_dto> conResultAll(String string, String search) {
		ArrayList<Consulting_김용석_dto> arr = new ArrayList<>();
		String query = "select c.no,c.sid,c.mid,c.cdate,e.age,e.name as ename, m.name as mname\r\n" + 
				       "from E_김용석_CONSULTING c, E_김용석_EDUCATEE e, E_김용석_MENTOR m \r\n" + 
				       "where c.sid = e.id \r\n" + 
				       "and c.mid = m.id\r\n" + 
				       "and "+string+" like '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("no");
				String sid = rs.getString("sid");
				String ename = rs.getString("ename");
				int age = rs.getInt("age");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String date = rs.getString("cdate");
				
				date = date.substring(0, 10);
				
				Consulting_김용석_dto dto = new Consulting_김용석_dto(id, sid, mid, date,ename,mname,age);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return arr;
	}

	public void conPrintAll(ArrayList<Consulting_김용석_dto> arr) {
		System.out.println("===============================================================");
		System.out.println("번호\t학생번호\t학생이름\t학생나이\t멘토번호\t멘토이름\t상담일자");
		System.out.println("---------------------------------------------------------------");
		if(arr.size() == 0) System.out.println("정보없음");
		for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getSid()+"\t");
			System.out.print(arr.get(k).getEname()+"\t");
			System.out.print(arr.get(k).getAge()+"\t");
			System.out.print(arr.get(k).getMid()+"\t");
			System.out.print(arr.get(k).getMname()+"\t");
			System.out.print(arr.get(k).getDate()+"\n");
		}
		System.out.println("=================================================================");
	}

	public Consulting_김용석_dto getResultId(String search, String id) {
		Consulting_김용석_dto dto = null;
		String query = "select c.no,c.sid,c.mid,c.cdate,e.age,e.name as ename, m.name as mname\r\n" + 
						"from E_김용석_CONSULTING c, E_김용석_EDUCATEE e, E_김용석_MENTOR m \r\n" + 
						"where c.sid = e.id \r\n" + 
						"and c.mid = m.id\r\n" + 
						"and "+search+" = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String idd = rs.getString("no");
				String sid = rs.getString("sid");
				String ename = rs.getString("ename");
				int age = rs.getInt("age");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String date = rs.getString("cdate");
				
				date = date.substring(0, 10);
				
				dto = new Consulting_김용석_dto(idd, sid, mid, date, ename, mname, age);
				
			}
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}

	public int updateConsult(String id, String sid, String mid, String cdate) {
		int result = 0;
		String query = "update e_김용석_consulting\r\n" + 
				       "set sid = '"+sid+"',\r\n" + 
				       "    mid = '"+mid+"',\r\n" + 
				       "    cdate = '"+cdate+"'\r\n" + 
				       "where no = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("쿼리오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	public void conPrintId(Consulting_김용석_dto dto) {
		System.out.println("=========================================================");
		System.out.println("번호\t학생번호\t학생이름\t학생나이\t멘토번호\t멘토이름\t상담일자");
		System.out.println("---------------------------------------------------------");
		if(dto == null) System.out.println("정보없음");
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getSid()+"\t");
		System.out.print(dto.getEname()+"\t");
		System.out.print(dto.getAge()+"\t");
		System.out.print(dto.getMid()+"\t");
		System.out.print(dto.getMname()+"\t");
		System.out.print(dto.getDate()+"\n");
		System.out.println("==========================================================");
		
	}

	public int deleteConsult(String id) {
		int result = 0;
		String query = "delete from E_김용석_CONSULTING\r\n" + 
				       "where no = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("쿼리오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
}
