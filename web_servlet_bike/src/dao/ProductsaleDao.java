package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

import common.CommonUtil;
import common.DBConnection;
import common.RandomString;
import dto.ProductsaleDto;

public class ProductsaleDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public String getRandomNo(){
		String no = UUID.randomUUID().toString();
	/*	
		Random r = new Random();
		RandomString rs = new RandomString(11,r);
		String no = rs.nextString();
	*/	
		return no;
	}

	
	public String getDeliveryNo() {
		String no = "";
		String today = CommonUtil.getToday();
		today = today.replaceAll("-", "");
		String query="select nvl(max(d_no),'S"+today+"000') as d_no from bike_김용석_productsale \r\n" ; 
					
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("d_no"); //S20230630001
				int number = Integer.parseInt(no.substring(9))+1; //2
				DecimalFormat df = new DecimalFormat("000"); 
				String order = df.format(number); //002
				no = no.substring(0,9)+order;
				//number = number+1; //20230630001
				//DecimalFormat df = new DecimalFormat("S00000000000"); 
				//no = df.format(number); //S20230630001
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return no;
	}

	public int getPurchaseSave(ProductsaleDto dto) {
		int result = 0;
		String query="insert into bike_김용석_productsale\r\n" + 
				"(d_no,p_no,d_state,c_id,purchase_way,price,purchase_date,d_email,d_address)\r\n" + 
				"values('"+dto.getD_no()+"','"+dto.getP_no()+"','"+dto.getD_state()+"','"+dto.getC_id()+"','"+dto.getPurchase_way()+"','"+dto.getPrice()+"',\r\n" + 
				"to_date('"+dto.getPurchase_date()+"','yyyy-mm-dd hh24:mi:ss'),'"+dto.getD_email()+"','"+dto.getD_address()+"')";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
}
