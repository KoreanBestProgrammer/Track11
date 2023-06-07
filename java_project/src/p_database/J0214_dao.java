package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0214_dao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//성명
    String getName(String id){
    	String name = "";
    	String query = "select name from member " + 
    			       "where id = '"+id+"' ";
    	
    	try {
    		con = DBConnection.getConnection(); //변수 안에 주소값을 넣어줌
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//name = rs.getString(1);
				name = rs.getString("name");
			}
			
		} catch (SQLException e) {	
			System.out.println("getName() : "+query);
			e.printStackTrace();
		} finally { DBConnection.closeDB(con, ps, rs);			
		}
    	
    	return name;
    }

    //회원정보 조회
    J0214_dto getMemberInfo(String id){
    	J0214_dto dto = null;
    	String query = "select id,name,area,age from member "+
    			       "where id = '"+id+"' ";
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			//String idd = rs.getString(1);
    			//String name = rs.getString(2);
    			//String area = rs.getString(3);
    			//String age = rs.getString(4);
    			
    			String idd = rs.getString("id");
    			String name = rs.getString("name");
    			String area = rs.getString("area");
    			int age = rs.getInt("age");
    			
    			dto = new J0214_dto(idd,name,area,age);  			
    		}
    		
    	}catch(SQLException e) {
    		System.out.println("getMemberInfo() : "+query);
    		e.printStackTrace();
    		
    	}finally { DBConnection.closeDB(con, ps, rs);
    		
    	}
	   return dto;
	}
    
    //회원목록조회
    
    ArrayList<J0214_dto> getMemberList(String gubun, String search){
    	ArrayList<J0214_dto> arr = new ArrayList<>();
    	String query = "select m.id, m.name, a.area_name as akkk, m.age \r\n" + 
    			       "from member m, areacommon a\r\n" + 
    			       "where m.area = a.area_code\r\n" + 
    			       "and "+gubun+" like '%"+search+"%'";
    	      //System.out.println(query);
    	
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery(); 
    		
    		while(rs.next()) {
    			
    			
    			String id = rs.getString("id");
    			String name = rs.getString("name");
    			String area = rs.getString("akkk");
    			int age = rs.getInt("age");
    			
    			J0214_dto dto = new J0214_dto(id,name,area,age);
    			
    		    arr.add(dto);
    		}
    		
    	}catch(SQLException e) {
    		System.out.println("getMemberList() : "+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);   		
    	}
    	
    	return arr;
    	
    	
    }
	
    void getArrPrint(ArrayList<J0214_dto> arr) {
    	if(arr.size() == 0) { 
			System.out.println("정보없음");
		}else {
			System.out.println("총 인원 : "+arr.size());
			for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print("id : "+arr.get(k).getId()+"\t");
			System.out.print("name : "+arr.get(k).getName()+"\t");
			System.out.print("area : "+arr.get(k).getArea()+"\t");
			System.out.println("age : "+arr.get(k).getAge());
			}
		}
    }
    	void getPrintName(ArrayList<J0214_dto> arr) {
    		
    		if(arr.size() == 0) { 
    			System.out.println("정보없음");
    		}else {
    			System.out.println("총 인원 : "+arr.size());
    			for(int k = 0 ; k < arr.size() ; k++) {
    			System.out.print("id : "+arr.get(k).getId()+"\t");
    			System.out.print("name : "+arr.get(k).getName()+"\t");
    			System.out.print("area : "+arr.get(k).getArea()+"\t");
    			System.out.println("age : "+arr.get(k).getAge());
    			}
    		}
    	
    	
    }
    
    	void getPrintId(ArrayList<J0214_dto> arr) {
    		if(arr.size() == 0) { 
    				System.out.println("정보없음");
    			}else {
    				System.out.println("총 인원 : "+arr.size());
    				for(int k = 0 ; k < arr.size() ; k++) {
    				System.out.print("id : "+arr.get(k).getId()+"\t");
    				System.out.print("name : "+arr.get(k).getName()+"\t");
    				System.out.print("area : "+arr.get(k).getArea()+"\t");
    				System.out.println("age : "+arr.get(k).getAge());
    				}
    			}
    	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
	
	


