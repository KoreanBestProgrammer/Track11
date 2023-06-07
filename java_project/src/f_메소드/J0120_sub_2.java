package f_메소드;

public class J0120_sub_2 {
	
	int getTotal(int a, int b, int c) {
		int total = a+b+c;
		return total;
	}
	
	int getTotal(int a, int b, String c) {
		int total = a+b+Integer.parseInt(c);
		return total;
	}
   
	int getTotal(int a, String b, String c) {
		int total = a+Integer.parseInt(b)+Integer.parseInt(c);
		return total;
	}
	
	int getTotal(int a, String b) {
		int total = a+Integer.parseInt(b);
		return total;
	}
	
				
	}		
