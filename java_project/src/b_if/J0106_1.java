package b_if;

import java.util.Scanner;

public class J0106_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//남자이고 20살 이상이면 생활비100만원 당첨!
		System.out.print("남,여?");
		String gender = sc.next();
		
		System.out.print("나이?");
		int age = sc.nextInt();
		
		if(gender.equals("남") && age >= 20) { System.out.println("생활비 당첨!");
		
		//남자이거나 나이가 20살 이상이면 50만원
		
		
		
		
		if(gender.equals("남") || age >= 20){ System.out.println("50만원 당첨!");
		System.out.print("ㅋㅋㅋ");
		System.out.println("zzzzz");
				
	}
	}
}
}