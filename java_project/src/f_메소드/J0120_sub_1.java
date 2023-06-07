package f_메소드;

public class J0120_sub_1 {
	
	int getTotal_1(int a, int b) { 
		int total = a+b;
		return total;
	}
   
	int getTotal_2(int a, int b, int c) {
		int total = a+b+c;
		return total;		
	}
	
	String getTotal_3(int a, int b) {
		int total = a+b;
		return Integer.toString(total);
	}
	
	int getAve_1(int a) {
		int ave = a/3;
		return ave;
	}
	
	int getAve_2(String a, int b) {
		int ave = Integer.parseInt(a)/b;
		return ave;		
	}
	
	String getAve_3(int a, String b) {
		int ave = a/Integer.parseInt(b);
		return Integer.toString(ave);				
	}
	
	String getAve_4(String a, String b) {
		int ave = Integer.parseInt(a)/Integer.parseInt(b);
		return Integer.toString(ave);		
	}
	
	int getTotal_4(int a, String b, int c, String d) {
		int total = a+Integer.parseInt(b)+c+Integer.parseInt(d);
		return total;
	}
	
	double getAve_5(int a, String b) {
		int ave = a/Integer.parseInt(b);
		return (double)ave;
	}
}























