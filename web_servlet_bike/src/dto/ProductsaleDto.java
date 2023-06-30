package dto;

public class ProductsaleDto {
	private String d_no,p_no,d_state,c_id,d_email,d_address,purchase_way,price,purchase_date;

	
	
	
	
	
	public ProductsaleDto(String d_no, String p_no, String d_state, String c_id, String d_email, String d_address,
			String purchase_way, String price, String purchase_date) {
		super();
		this.d_no = d_no;
		this.p_no = p_no;
		this.d_state = d_state;
		this.c_id = c_id;
		this.d_email = d_email;
		this.d_address = d_address;
		this.purchase_way = purchase_way;
		this.price = price;
		this.purchase_date = purchase_date;
	}

	public String getD_no() {
		return d_no;
	}

	public String getP_no() {
		return p_no;
	}

	public String getD_state() {
		return d_state;
	}

	public String getC_id() {
		return c_id;
	}

	public String getD_email() {
		return d_email;
	}

	public String getD_address() {
		return d_address;
	}

	public String getPurchase_way() {
		return purchase_way;
	}

	public String getPrice() {
		return price;
	}

	public String getPurchase_date() {
		return purchase_date;
	}
		
	
}
