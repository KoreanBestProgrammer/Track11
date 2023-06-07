package dto;

public class FaqDto {
	private String no,title,content,reg_id,reg_date,name,update_date;
	private int hit;

	public FaqDto(String no, String title, String content, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;						
	}

	public FaqDto(String no, String title, String content, String reg_date, String name, int hit, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.name = name;
		this.hit = hit;
		this.update_date = update_date;
	}
	
	public FaqDto(String no, String title, String content, String reg_date, String name, String update_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.name = name;
		this.update_date = update_date;
		this.hit = hit;
	}

	public FaqDto(String no, String title, String content, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
	}

	public String getUpdate_date() {
		return update_date;
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

	public String getName() {
		return name;
	}
	public int getHit() {
		return hit;
	}
	
	
	
	
}
