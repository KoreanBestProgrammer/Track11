package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class J0221_김용석_dao {

	Connection con; 
	PreparedStatement ps;
	ResultSet rs;
	 ArrayList<J0221_김용석_dto> getResult(String gubun, String search) {
		ArrayList<J0221_김용석_dto> arr = new ArrayList<>();
		String query =  "select id,name,area,age from e_김용석_member "+
				        "where "+gubun+" like '%"+search+"%' ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String names = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				
				J0221_김용석_dto dto = new J0221_김용석_dto(id, names, area, age);
				arr.add(dto);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("getResult"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	public void ResultPrint(ArrayList<J0221_김용석_dto> arr) {
		System.out.println("===========================");
		System.out.println("id\t성명\t지역\t나이");
		System.out.println("---------------------------");
		for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.println(arr.get(k).getAge());
		}
		System.out.println("===========================");
		
	}
	public int insertMember(J0221_김용석_dto dto) {
		int result = 0 ;
		String query = "insert into e_김용석_member "+
				       "(id,name,area,age) "+
				       "values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getArea()+"',"+dto.getAge()+") ";
				
				try {
					con = DBConnection.getConnection();
					ps = con.prepareStatement(query);
					result = ps.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					DBConnection.closeDB(con, ps, rs);
				}
				
				
		return result;
	
	
	
	
	}
	public J0221_김용석_dto getResultAll(String id) {
		J0221_김용석_dto dto = null;
		String query = "select id,name,area,age from e_김용석_member "+
				       "where id = '"+id+"' ";	
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String idd = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				
				 dto = new J0221_김용석_dto(idd, name, area, age);
				
				
			}
			
		  	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
			return dto;
	}
	public int updateMember(J0221_김용석_dto dto2) {
		int result = 0;
		String query = "update e_김용석_member "+
				       "set name = '"+dto2.getName()+"', "+
			           "area = '"+dto2.getArea()+"', "+
			           "age = "+dto2.getAge()+" "+
			           "where id = '"+dto2.getId()+"' ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(query);
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
		try{
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("deleteMember"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}																
				
		return result;
	}
	   
}

