package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class J0221_김용석2_dao {
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	

	public ArrayList<J0221_김용석2_dto> getResult(String search) {
		ArrayList<J0221_김용석2_dto> arr = new ArrayList<>();
		String query = "select id,name,area,age from e_김용석_member "+
				       "where name like '%"+search+"%' "+
				       "order by id desc ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs  = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				
				J0221_김용석2_dto dto = new J0221_김용석2_dto(id, name, area, age);
				arr.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}



	public void getPrint(ArrayList<J0221_김용석2_dto> arr) {
		System.out.println("==============================");
		System.out.println("id\t성명\t지역\t나이");
		System.out.println("-------------------------------");
		for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.println(arr.get(k).getAge());
		}
		System.out.println("=================================");
	}



	public ArrayList<J0221_김용석2_dto> getResultNameArea(String namearea, String search) {
		ArrayList<J0221_김용석2_dto> arr = new ArrayList<>();
		String query = "select id,name,area,age from e_김용석_member "+
				       "where "+namearea+" like '%"+search+"%' "+
				       "order by id desc ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
					
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				
				J0221_김용석2_dto dto = new J0221_김용석2_dto(id, name, area, age);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
		
	}



	public int insertMember(J0221_김용석2_dto dto) {
		int result = 0;
		String query = "insert into e_김용석_member "+
				       "(id,name,area,age) "+
				       "values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getArea()+"',"+dto.getAge()+") ";
		
		  try {
			  con = DBConnection.getConnection();
			  ps = con.prepareStatement(query);
			  result = ps.executeUpdate();
			  
		  }catch(Exception e) {
			  System.out.println("오류 :"+query);
			  e.printStackTrace();
		  }finally {
			  DBConnection.closeDB(con, ps, rs);
		  }
		
		
		
		return result;
	}



	public int updateMember(J0221_김용석2_dto dto) {
		int result = 0;
		String query = "update e_김용석_member "+
				       "set name = '"+dto.getName()+"', "+
			           "area = '"+dto.getArea()+"', "+
			           "age = "+dto.getAge()+" "+
			           "where id = '"+dto.getId()+"' ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return result;
	}



	public int deleteMember(String id) {
		int result = 0;
		String query = "delete from e_김용석_member "+
				       "where id = '"+id+"' ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}




}
