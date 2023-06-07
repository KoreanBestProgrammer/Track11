package dto;

public class PdsDto {

	private String no,title,content,attach,reg_id,name,reg_date,update_date;
	private int hit;
	
	
	
	
	public PdsDto(String no, String title, String content,String update_date, String attach) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
		this.attach = attach;
	}



	public PdsDto(String no, String title, String content, String attach, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
	
	
	public PdsDto(String no, String title, String attach, String name, String reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.attach = attach;
		this.name = name;
		this.reg_date = reg_date;
		this.hit = hit;
	}



	public PdsDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}



	public PdsDto(String no, String title, String content, String attach, String name, String reg_date, int hit, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.name = name;
		this.reg_date = reg_date;
		this.hit = hit;
		this.update_date = update_date;
	}



	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getAttach() {
		return attach;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getName() {
		return name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getHit() {
		return hit;
	}
	public String getUpdate_date() {
		return update_date;
	}
	
	
	
	
	
	
}