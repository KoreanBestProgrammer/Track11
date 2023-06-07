package p_database;

public class Consulting_김용석_dto {
	String id, sid, mid, date, ename, mname;
	int age;
	public Consulting_김용석_dto(String id, String sid, String mid, String date, String ename, String mname, int age) {
		super();
		this.id = id;
		this.sid = sid;
		this.mid = mid;
		this.date = date;
		this.ename = ename;
		this.mname = mname;
		this.age = age;
	}
	public Consulting_김용석_dto(String id, String sid, String mid, String date) {
		super();
		this.id = id;
		this.sid = sid;
		this.mid = mid;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public String getSid() {
		return sid;
	}
	public String getMid() {
		return mid;
	}
	public String getDate() {
		return date;
	}
	public String getEname() {
		return ename;
	}
	public String getMname() {
		return mname;
	}
	public int getAge() {
		return age;
	}
	
	
	
}
