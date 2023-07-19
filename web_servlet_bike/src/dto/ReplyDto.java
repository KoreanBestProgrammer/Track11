package dto;

public class ReplyDto {
	private String no,reply,reply_date,reply_name;

	

	public ReplyDto(String reply, String reply_date, String reply_name) {
		super();
		this.reply = reply;
		this.reply_date = reply_date;
		this.reply_name = reply_name;
	}

	public ReplyDto(String no, String reply, String reply_date, String reply_name) {
		super();
		this.no = no;
		this.reply = reply;
		this.reply_date = reply_date;
		this.reply_name = reply_name;
	}

	public String getReply() {
		return reply;
	}

	public String getReply_date() {
		return reply_date;
	}

	public String getReply_name() {
		return reply_name;
	}
	public String getNo() {
		return no;
	}
	
}
