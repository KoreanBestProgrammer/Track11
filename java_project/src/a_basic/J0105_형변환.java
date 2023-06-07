package a_basic;

public class J0105_형변환 {

	public static void main(String[] args) {
		int a = 10;
		double aa = a;
		System.out.println("aa : "+aa);
		 // int - double : 정수를 실수로
		int total = 185;
	    int count = 3;
		double ave = total/(double)count;   
		System.out.println("ave"+ave);
		
		// double - int : 실수를 정수로
		double d = 85.855555;
		int dd = (int)d;
		System.out.println("dd : "+dd);
		
		// string - int : 문자열을 정수로 
	    String v = "100";
	    int ss = Integer.parseInt(v);
	    System.out.println("ss : "+ss);
	    
	    // int - string : 정수를 문자열로
	    int i = 85;
	    String ii = Integer.toString(i);
	    System.out.println("ii : "+ii);

	}

}
