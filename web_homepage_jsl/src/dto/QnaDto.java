package dto;

public class QnaDto {
	private String no,title,content,state,reg_id,reg_date,update_date,name,answer,answerid;
	private int hit;
	
	//등록
	public QnaDto(String no, String title, String reg_id, String content, String state, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.state = state;
		this.reg_id = reg_id;
		this.reg_date = reg_date;	
	}
	//조회
	public QnaDto(String no, String title, String content, String state, String reg_id, String reg_date, String name,
			int hit,String answer) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.state = state;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.name = name;
		this.hit = hit;
		this.answer = answer;
	}
	//view
	public QnaDto(String no, String title, String reg_id, String content, String reg_date, String update_date, String name,
			String answer, String answerid, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_id = reg_id;
		this.content = content;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.name = name;
		this.answer = answer;
		this.answerid = answerid;
		this.hit = hit;
	}
	//답변등록	
	public QnaDto(String no, String update_date, String answer, String answerid) {
		super();
		this.no = no;
		this.update_date = update_date;
		this.answer = answer;
		this.answerid = answerid;
	}
	//이전 다음글
	public QnaDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
		
		
	}
	public String getAnswer() {
		return answer;
	}
	
	public String getAnswerid() {
		return answerid;
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
	public String getState() {
		return state;
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
	public String getName() {
		return name;
	}
	
	
	
}
