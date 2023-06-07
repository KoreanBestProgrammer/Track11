package b_if;

import java.util.Scanner;

public class J0110_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 : 1, 주부 : 2, 회사원 : 3");
		String job = sc.next();
		
		int a = 500000;
		
		String aa = "";
		
		if(job.equals("1")) {a = a+100000; aa = "학생";}
		else if(job.equals("2")) {a = a+300000; aa = "주부";}
		else if(job.equals("3")) {a = a+400000; aa = "회사원";}
		else System.out.println("입력오류"); a = 0;
		
	System.out.println(aa+" : "+a+"원");
		

	}

}
