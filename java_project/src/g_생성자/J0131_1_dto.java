package g_생성자;

public class J0131_1_dto {
    String name;
    int kor, eng, mat, total, ave;
    
    J0131_1_dto(){}
    
	  J0131_1_dto(String name, int kor, int eng, int mat) {	
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	 
	String getName() {
		return name;
	}
	 void setName(String name) {
		this.name = name;
	}
	 int getKor() {
		return kor;
	}
	 void setKor(int kor) {
		this.kor = kor;
	}
	 int getEng() {
		return eng;
	}
	 void setEng(int eng) {
		this.eng = eng;
	}
	 int getMat() {
		return mat;
	}
	 void setMat(int mat) {
		this.mat = mat;
	}
	 int getTotal() {
		return total;
	}
	 void setTotal(int total) {
		this.total = total;
	}
	 int getAve() {
		return ave;
	}
	 void setAve(int ave) {
		this.ave = ave;
	}
    
	
	
	
	
	
}
