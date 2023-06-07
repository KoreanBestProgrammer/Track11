package g_생성자;

public class J0202_1_dto {
	String sabun, name, depart, rank;
	int salary;
			
	J0202_1_dto(){}
		
	public J0202_1_dto(String sabun, String name, String depart, String rank, int salary) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.depart = depart;
		this.rank = rank;
		this.salary = salary;
	}
	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
