package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cstudent_김용석_dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public int insertStudent(String id, String name, int age) {
		int result = 0;
		String query = "insert into E_김용석_EDUCATEE "+ 
				       "(id,name,age) "+
				       "values('"+id+"','"+name+"',"+age+") ";
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

	public ArrayList<Cstudent_김용석_dto> stuResultAll(String string, String search) {
		ArrayList<Cstudent_김용석_dto> arr = new ArrayList<>();
		String query = "select id,name,age from E_김용석_EDUCATEE "+
				       "where "+string+" like '%"+search+"%' "; 
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				Cstudent_김용석_dto dto = new Cstudent_김용석_dto(id, name, age);
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

	public void stuPrint(ArrayList<Cstudent_김용석_dto> arr) {
		System.out.println("==========================");
		System.out.println("학생번호\t성명\t나이");
		System.out.println("--------------------------");
		if(arr.size() == 0) System.out.println("정보없음");
		for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.println(arr.get(k).getAge());
		}
		System.out.println("===========================");
	}

	public int updateStudent(String id, String name, int age) {
		int result = 0;
		String query = "update E_김용석_EDUCATEE "+
				       "set name = '"+name+"', "+
			           "age = "+age+" "+
			           "where id = '"+id+"' ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query );
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return result;
	}

	public int deleteStudent(String id) {
		int result = 0;
		String query = "delete from E_김용석_EDUCATEE "+
				       "where id = '"+id+"' ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query );
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	public Cstudent_김용석_dto stuResultId(String id) {
		Cstudent_김용석_dto dto = null;
		String query = "select id,name,age from E_김용석_EDUCATEE "+
				       "where id = '"+id+"' ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String idd = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				 dto = new Cstudent_김용석_dto(idd, name, age);
				
			}
		}catch(Exception e) {
			System.out.println("쿼리오류 "+query );
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}

	public void stuPrintId(Cstudent_김용석_dto dto) {
		System.out.println("==========================");
		System.out.println("학생번호\t성명\t나이");
		System.out.println("--------------------------");
		if(dto == null) System.out.println("정보없음");
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getName()+"\t");
		System.out.println(dto.getAge());
		System.out.println("==========================");
	}

	
		
		
	

}
