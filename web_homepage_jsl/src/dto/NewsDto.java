package dto;

public class NewsDto {
	private String no,title,content,reg_id,reg_date,update_date,name;
	private int hit;	
	
	public NewsDto(String no, String title, String content, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
	
	public NewsDto(String no, String title, String reg_date, String name, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_date = reg_date;
		this.name = name;
		this.hit = hit;
	}

	
	
	
	public NewsDto(String no, String title, String content, String reg_date, String update_date, String name, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.name = name;
		this.hit = hit;
	}


	public NewsDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}


	public NewsDto(String no, String title, String content, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
	}


	public String getName() {
		return name;
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
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public int getHit() {
		return hit;
	}
	
	
}
