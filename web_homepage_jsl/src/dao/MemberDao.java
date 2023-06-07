package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnection;
import dto.MemberDto;



public class MemberDao {
	
	Connection        con = null;
	PreparedStatement  ps = null;
	ResultSet          rs = null;
	
	 // 암호화
    public String encryptSHA256(String value) throws NoSuchAlgorithmException{
        String encryptData ="";
         
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(value.getBytes());
 
        byte[] digest = sha.digest();
        for (int i=0; i<digest.length; i++) {
            encryptData += Integer.toHexString(digest[i] &0xFF).toUpperCase();
        }
         
        return encryptData;
    }
 
    public int memberJoin(MemberDto dto,int passleng) {
    	int result = 0;
    	String query = "insert into home_김용석_member\r\n" + 
    			"(id,name,password,job,tell_1,tell_2,tell_3,\r\n" + 
    			" mobile,email,reg_date,pwleng)\r\n" + 
    			"values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getPassword()+"','"+dto.getJob()+"','"+dto.getTell_1()+"','"+dto.getTell_2()+"',\r\n" + 
    			"       '"+dto.getTell_3()+"','"+dto.getMobile()+"','"+dto.getEmail()+"',"
    					+ " to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'),"+passleng+")";
    	
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		result = ps.executeUpdate();
    	}catch(Exception e) {
    		System.out.println("쿼리오류"+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    	return result;
    	
    }
    public String checkLogin(String id,String password) {
    	String name = "";
    	String query = "select name from home_김용석_member\r\n" + 
    				   "where id = '"+id+"'\r\n" + 
    				   "and password = '"+password+"'";
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			name = rs.getString("name");
    		}
    		
    	}catch(Exception e) {
    		System.out.println("쿼리오류"+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);		
    	}
    	return name;
    }
    public MemberDto getMemberView(String sessionId) {
    	MemberDto dto = null;
    	String query = "select id,name,job,tell_1,tell_2,tell_3,\r\n" + 
    			       "mobile,email,to_char(reg_date,'yyyy-mm-dd')as reg_date\r\n" + 
    			       "from home_김용석_member\r\n" + 
    			       "where id = '"+sessionId+"'";
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			String name = rs.getString("name");
    			String job = rs.getString("job");
    			
    			String tell_1 = rs.getString("tell_1");
    			String tell_2 = rs.getString("tell_2");
    			String tell_3 = rs.getString("tell_3");
    			String mobile = rs.getString("mobile");
    			String email = rs.getString("email");
    			String reg_date = rs.getString("reg_date");
    			
    			dto = new MemberDto(sessionId,name,job,"",tell_1,tell_2,tell_3,mobile,email,reg_date); 
    		}
    			
    		}catch(Exception e) {
        		System.out.println("쿼리오류"+query);
        		e.printStackTrace();
        	}finally {
        		DBConnection.closeDB(con, ps, rs);
        	} 	
    	
    	return dto;
    }
    public int getCheckPassword(String id, String password) {
    	int count = 0;
    	String query = "select count(*) as count from home_김용석_member\r\n" + 
    				   "where id = '"+id+"'\r\n" + 
    				   "and password = '"+password+"'";
    	   	
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery();
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
    public int updateMember(MemberDto dto) {
    	int result = 0;
    	String query = "update HOME_김용석_MEMBER\r\n" + 
    				   "    set name = '"+dto.getName()+"',\r\n" + 
    				   "        job = '"+dto.getJob()+"',\r\n" + 
    				   "        tell_1 = '"+dto.getTell_1()+"',\r\n" + 
    				   "        tell_2 = '"+dto.getTell_2()+"',\r\n" + 
    				   "        tell_3 = '"+dto.getTell_3()+"',\r\n" + 
    				   "        mobile = '"+dto.getMobile()+"',   \r\n" + 
    				   "        email = '"+dto.getEmail()+"'\r\n" + 
    				   "where id = '"+dto.getId()+"'\r\n" + 
    				   "and password = '"+dto.getPassword()+"'";
    	
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		result = ps.executeUpdate();
    	}catch(Exception e) {
    		System.out.println("쿼리오류"+query);
    		e.printStackTrace();
    	}finally {
    	DBConnection.closeDB(con, ps, rs);	
    	}
    			
    	return result;
    }
    
    public int checkId(String id) {
    	int count = 0;
    	String query = "select count(*) as count from home_김용석_member\r\n" + 
    			       "where id = '"+id+"'";
    	try {
    		con = DBConnection.getConnection();
    		ps = con.prepareStatement(query);
    		rs = ps.executeQuery();
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
    public int getDeleteMember(String id) {
    	int result=0;
    	String query="update home_김용석_member\r\n" + 
    			"    set tal = '0'\r\n" + 
    			"where id = '"+id+"'";
    	try {
    		con=DBConnection.getConnection();
    		ps=con.prepareStatement(query);
    		result=ps.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    	
    	return result;
    }
    public int getCount(String id,String password) {
    	int count = 0;
    	String query = "";
    	
    	return count;
    }
    
}
