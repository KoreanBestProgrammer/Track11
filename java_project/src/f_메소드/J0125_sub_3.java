package f_메소드;

public class J0125_sub_3 {

	
	int getPay(int a, String b) {
		int result = 0;
		if(b.equals("1")) result = a+100000;
		else if(b.equals("2")) result = a+200000;
		return result;
		
	}
}
