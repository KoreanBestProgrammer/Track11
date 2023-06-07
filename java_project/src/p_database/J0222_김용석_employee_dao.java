package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class J0222_김용석_employee_dao {
	
	Connection         con = null;
	PreparedStatement   ps = null;
	ResultSet           rs = null;

	public int insertEmployee(J0222_김용석_employee_dto dto) {						
		int result = 0;
		String query = "insert into e_김용석_employee "+
				       "(id,name,depart,rank,age) "+
				       "values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getDepart()
				                 +"','"+dto.getRank()+"',"+dto.getAge()+") ";
				
			try {
				con = DBConnection.getConnection();
				ps = con.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(Exception e) {
				System.out.println("쿼리오류 : "+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			
		return result;
	}

	public ArrayList<J0222_김용석_employee_dto> getResultAll(String gubun, String search) {
		ArrayList<J0222_김용석_employee_dto> arr = new ArrayList<>();
		String query = "select id,name,depart,rank,age from e_김용석_employee "+
				       "where "+gubun+" like '%"+search+"%' "+
				       "order by id desc ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String depart = rs.getString("depart");
				String rank = rs.getString("rank");
				int age = rs.getInt("age");
				
				J0222_김용석_employee_dto dto = new J0222_김용석_employee_dto(id, name, depart, rank, age);
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

	public void printResult(ArrayList<J0222_김용석_employee_dto> arr) {
		System.out.println("==================================");
		System.out.println("id\t성명\t부서\t직위\t나이");
		System.out.println("----------------------------------");
		if(arr.size() == 0) {
			System.out.println("\t\t정보없음");
		}
		for(int k = 0 ; k < arr.size() ; k++) {			
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getRank()+"\t");
			System.out.println(arr.get(k).getAge());
		}
		System.out.println("----------------------------------");
		if(arr.size() != 0) {
			System.out.println("총 몇명 : "+arr.size());
			System.out.println("----------------------------------");
		}
	}

	public int updateEmployee(J0222_김용석_employee_dto dto) {
		int result = 0;
		String query = "update E_김용석_EMPLOYEE "+				       
			           "set name = '"+dto.getName()+"', "+
			           "depart = '"+dto.getDepart()+"', "+
			           "rank = '"+dto.getRank()+"', "+
			           "age = '"+dto.getAge()+"' "+
			           "where id = '"+dto.getId()+"' ";
			           
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	public int insertEmployee(String id, String name, String depart, String rank, int age) {
		int result = 0;
		String query = "insert into e_김용석_employee "+
				       "(id,name,depart,rank,age) "+
				       "values('"+id+"','"+name+"','"+depart
				                 +"','"+rank+"',"+age+") ";
				       
				
			try {
				con = DBConnection.getConnection();
				ps = con.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(Exception e) {
				System.out.println("쿼리오류 : "+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			
		return result;
	}

	public int updateEmployee(String id, String name, String depart, String rank, int age) {
		int result = 0;
		String query = "update E_김용석_EMPLOYEE "+				       
			           "set name = '"+name+"', "+
			           "depart = '"+depart+"', "+
			           "rank = '"+rank+"', "+
			           "age = '"+age+"' "+
			           "where id = '"+id+"' ";
			           
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
		
	}

	public int deleteMember(String id) {
		int result = 0;
		String query = "delete from E_김용석_EMPLOYEE "+
				       "where id = '"+id+"' ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
    //id중복검사
	public int checkId(String id) {
		int count = 0;
		String query = "select count(*) as count "+
		               "from e_김용석_employee "+
				       "where id = '"+id+"' ";
				try {
					con = DBConnection.getConnection();
					ps = con.prepareStatement(query);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						count = rs.getInt("count");
					}
				}catch(Exception e) {
					System.out.println("쿼리오류 : "+query);
					e.printStackTrace();
				}finally {
					DBConnection.closeDB(con, ps, rs);
				}
				
				
				
		return count;
	}

	public J0222_김용석_employee_dto getIdInfo(String id) {
		J0222_김용석_employee_dto dto = null;
		String query = "select id,name,depart,rank, age from E_김용석_EMPLOYEE "+
				       "where id = '"+id+"' ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String idd = rs.getString("id");
				String name = rs.getString("name");
				String depart = rs.getString("depart");
				String rank = rs.getString("rank");
				int age = rs.getInt("age");
				
				dto = new J0222_김용석_employee_dto(idd, name, depart, rank, age);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}

	public void resultPrintDto(J0222_김용석_employee_dto dto) {
		System.out.println("==================================");
		System.out.println("id\t성명\t부서\t직위\t나이");
		System.out.println("----------------------------------");
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getDepart()+"\t");
		System.out.print(dto.getRank()+"\t");
		System.out.println(dto.getAge()+"\n");
		System.out.println("----------------------------------");
	}
	  
}
