package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cmentor_김용석_dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int insertMentor(Cmentor_김용석_dto dto) {
		int result = 0;
		String query = "insert into E_김용석_MENTOR "+
				       "(id,name) "+
				       "values('"+dto.getId()+"','"+dto.getName()+"') ";
		
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
	public ArrayList<Cmentor_김용석_dto> menResultAll(String string, String search) {
		ArrayList<Cmentor_김용석_dto> arr = new ArrayList<>();
		String query = "select id,name from E_김용석_MENTOR "+
				       "where "+string+" like '%"+search+"%' ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				Cmentor_김용석_dto dto = new Cmentor_김용석_dto(id, name);
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
	public void menPrintAll(ArrayList<Cmentor_김용석_dto> arr) {
		System.out.println("=============================");
		System.out.println("멘토번호\t성명");
		System.out.println("-----------------------------");
		if(arr.size() == 0) System.out.println("내용없음");
	    for(int k = 0 ; k < arr.size() ; k++) {
	    	System.out.print(arr.get(k).getId()+"\t");
	    	System.out.println(arr.get(k).getName());
	    }
		System.out.println("=============================");
	}
	public int updateMentor(Cmentor_김용석_dto dto) {
		int result = 0;
		String query = "update E_김용석_MENTOR "+
				       "set name = '"+dto.getName()+"' "+
				       "where id = '"+dto.getId()+"' ";
			
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
	public int deleteMentor(String id) {
		int result = 0;
		String query = "delete from E_김용석_MENTOR "+
				       "where id = '"+id+"' ";
		
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
	public Cmentor_김용석_dto menResultId(String id) {
		Cmentor_김용석_dto dto = null;
		String query = "select id,name from E_김용석_MENTOR "+
				       "where id = '"+id+"' ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String idd = rs.getString("id");
				String name = rs.getString("name");
				
				dto = new Cmentor_김용석_dto(idd, name);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	public void menPrintId(Cmentor_김용석_dto dto) {
		System.out.println("==========================");
		System.out.println("멘토번호\t성명");
		System.out.println("--------------------------");
		if(dto == null) System.out.println("정보없음");
		System.out.print(dto.getId()+"\t");
		System.out.println(dto.getName());		
		System.out.println("==========================");
		
	}
	
	
}
