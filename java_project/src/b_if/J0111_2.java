package b_if;

import java.util.Scanner;

public class J0111_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇월입니까? ");
		int month = sc.nextInt();
		
		String m = Integer.toString(month);
		
		
		
		String result = "";
		
		
		
		if(m.equals("12") || m.equals("1") || m.equals("2")) {result = "겨울";}
		else if(m.equals("3") || m.equals("4") || m.equals("5")) {result = "봄";}
		else if(m.equals("6") || m.equals("7") || m.equals("8")) {result = "여름";}
		else if(m.equals("9") || m.equals("10") || m.equals("11")) {result = "가을";}
		else result ="계절입력오류";
		
		System.out.println("계절 : "+result);
		
		
	}

}
