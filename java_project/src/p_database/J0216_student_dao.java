package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0216_student_dao {

	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	
	ArrayList<J0216_student_dto> getStu(){
		ArrayList<J0216_student_dto> arr = new ArrayList<>();
		
		String query = "select id,name,kor,eng,mat,total,result "+
				       "from e_김용석_student "+				      
				       "order by id desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("total");
				String result = rs.getString("result");
				
				J0216_student_dto dto = new J0216_student_dto(id,name,kor,eng,mat,total,result);
				arr.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println("getStu() : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);			
		}
		
		return arr;
		
	}
	
	void ResultPrint(ArrayList<J0216_student_dto> arr) {
		System.out.println("총 인원 : "+arr.size()+"명");
		System.out.println("===================================================");
		System.out.println("id\t성명\t국어\t영어\t수학\t총점\t결과");
		System.out.println("---------------------------------------------------");
		 if(arr.size() == 0) {
	        	System.out.println("정보없음...");
	        }else {	        	
			   for(int k = 0 ; k < arr.size() ; k++) {
				   System.out.print(arr.get(k).getId()+"\t");
				   System.out.print(arr.get(k).getName()+"\t");
				   System.out.print(arr.get(k).getKor()+"\t");
				   System.out.print(arr.get(k).getEng()+"\t");
				   System.out.print(arr.get(k).getMat()+"\t");
				   System.out.print(arr.get(k).getTotal()+"\t");
				   System.out.println(arr.get(k).getResult());
			   }
	        }
		 System.out.println("===================================================");
	}

      ArrayList<J0216_student_dto> getSearchList(String gubun, String search) {
    	  ArrayList<J0216_student_dto> arr = new ArrayList<>();
    	  String query = "select id,name,kor,eng,mat,total,result "+
    			         "from e_김용석_student "+
    			         "where "+gubun+" like '%"+search+"%' "+
    			         "order by id desc ";
    	  
    	  try {
    		  con = DBConnection.getConnection();
    		  ps = con.prepareStatement(query);
    		  rs = ps.executeQuery();
    		  
    		  while(rs.next()) {
    			  String id = rs.getString("id");
    			  String name = rs.getString("name");
    			  int kor = rs.getInt("kor");
    			  int eng = rs.getInt("eng");
    			  int mat = rs.getInt("mat");
    			  int total = rs.getInt("total");
    			  String result = rs.getString("result");
    			  
    			  J0216_student_dto dto = new J0216_student_dto(id,name,kor,eng,mat,total,result);   			  
    			  arr.add(dto);
    		  }   		  
    	  }catch(SQLException   e) {
    		     System.out.println("getSearchList : "+query);
    		     e.printStackTrace();
    	  }finally { 
    		  DBConnection.closeDB(con, ps, rs);		  
    	  }
    	  
    	  
		return arr;
	}

	 int getTotal(int kor, int eng, int mat) {
		int total = kor+eng+mat;
		return total;
	}

	 String getResult(int total) {
		double ave = total/3.0;
		String result = "";
		if(ave >= 90) result = "수";
		else if(ave >=80) result = "우";
		else if(ave >=70) result = "미";
		else if(ave >=60) result = "양";
		else result = "가";
 		return result;
	}
     //등록
	 int saveStudent(J0216_student_dto dto) {
		int result = 0;
		String query = "insert into e_김용석_student\r\n" + 
				"(id,name,kor,eng,mat,total,result)\r\n" + 
				"values('"+dto.getId()+"','"+dto.getName()+"',"+dto.getKor()+","
				          +dto.getEng()+","+dto.getMat()+","
				          +dto.getTotal()+",'"+dto.getResult()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate(); // int
				
		}catch(SQLException e) {
			   e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);			
		}	
		
		return result;
	}

	 J0216_student_dto getStudentinfo(String id) {
		 J0216_student_dto dto = null;
		 String query = "select id,name,kor,eng,mat,total,result from e_김용석_student "+
				         "where id = '"+id+"' ";
		 
		 try {
			 con = DBConnection.getConnection();
			 ps = con.prepareStatement(query);
			 rs = ps.executeQuery();
			 
			 
			 if(rs.next()) {
		      //String idd = rs.getString("id");			 
   			  String name = rs.getString("name");
   			  int kor = rs.getInt("kor");
   			  int eng = rs.getInt("eng");
   			  int mat = rs.getInt("mat");
   			  int total = rs.getInt("total");
   			  String result = rs.getString("result");
   			  
   			    dto = new J0216_student_dto(id,name,kor,eng,mat,total,result); 
   			    
   			    
			 }
		 }catch(Exception e) {
			   System.out.println("getStudentinfo : "+query);
			   e.printStackTrace();
		 }finally {
			 DBConnection.closeDB(con, ps, rs);
		 }
		 
		 return dto;
		 		 		 		 		 		 		 				 		 		 		
	}

	 void getPrintDto(J0216_student_dto dto) {
		 System.out.print(dto.getId()+"\t");
		 System.out.print(dto.getName()+"\t");
		 System.out.print(dto.getKor()+"\t");
		 System.out.print(dto.getEng()+"\t");
		 System.out.print(dto.getMat()+"\t");
		 System.out.print(dto.getTotal()+"\t");
		 System.out.println(dto.getResult());
		 
	 }

	public int updateStudent(J0216_student_dto dto2) {
		int result = 0;
		String query =  "update e_김용석_student "+
				        "set name = '"+dto2.getName()+"', "+
			            "kor = "+dto2.getKor()+", "+
			            "eng = "+dto2.getEng()+", "+
			            "mat = "+dto2.getMat()+", "+
			            "total = "+dto2.getTotal()+", "+
			            "result = '"+dto2.getResult()+"' "+
			            "where id = '"+dto2.getId()+"'";
		
		try {
                con = DBConnection.getConnection();
                ps = con.prepareStatement(query);
                result = ps.executeUpdate();
                
                
		}catch(SQLException e) {
			 System.out.println("updateStudent() : "+query);
			 e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);			
		}
		
		
		return result;
	}

	public int deleteStudent(String id) {
		int result = 0;
		String query = "delete from e_김용석_student "+
				       "where id = '"+id+"' ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			 System.out.println("deleteStudent : "+query);
			 e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
