package b_if;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 월 입니까? ");
		String month = sc.next();
		
		int m = Integer.parseInt(month);
	   
		if(m <= 12 && m >= 1) {
		
		String result = "";
		
		
		if(m == 1 || m == 2 || m == 12) {result = "겨울";}
		else if (m == 3 ||  m == 4 || m == 5) {result = "봄";}
		else if (m == 6 || m == 7 || m == 8) {result = "여름";}
		else if (m == 9 || m == 10 || m == 11) {result = "가을";}
		
		System.out.println("계절 : "+result);
		}
		else {System.out.println("계절입력오류");}
		
		
		
		}
	
		

	}


