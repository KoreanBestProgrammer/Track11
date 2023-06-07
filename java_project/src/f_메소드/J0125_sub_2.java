package f_메소드;

public class J0125_sub_2 {

	int getTotal(int a, int b, int c) {
		int result = a+b+c;
		return result;
	}
	
	double getTotal(int a, int b) {
		double result = a/b;
		return result;
	}
	
	String getTotal(double a) {
		String result = "";
		if(a >= 90 && a <101) result = "수";
		else if(a >= 80 && a < 90) result = "우";
		else if(a >= 70 && a < 80) result = "미";
		else if(a >= 60 && a < 70) result = "양";
		else if(a >= 0  && a < 60) result = "가";
		return result;
	}
}
