package b_if;

import java.util.Scanner;

public class J0109_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수");
		double f = sc.nextDouble();
		
		System.out.print("연산자");
		String a = sc.next();
		
		System.out.print("두번째 수");
		double s = sc.nextDouble();
		
		double result = 0;
		
		if(a.equals("+")) { result = f+s;}
		else if(a.equals("-")) {result = f-s;}
		else if(a.equals("*")) {result = f*s;}
		else if(a.equals("/")) {result = f/s;}
		else {System.out.println("입력오류");}
        
		System.out.println("결과 : "+result);
}

	}


