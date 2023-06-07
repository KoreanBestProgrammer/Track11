package b_if;

import java.util.Scanner;

public class J0111_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성명?");
		String name = sc.next();		
							
		System.out.print("학년?");
		String g = sc.next();	
		
		System.out.print("국어점수?");
		int kor = sc.nextInt();
		
		System.out.print("영어점수?");
		int eng = sc.nextInt();
		
		System.out.print("수학점수?");
		int mat = sc.nextInt();
		
		int total = kor+eng+mat;
		double ave = total/3.0;
										
		String result = "불합격";
		
		
		if((g.equals("1") || g.equals("2") || g.equals("3")) && (ave >= 70)) result = "합격";
		else if((g.equals("4") || g.equals("5") || g.equals("6")) && (ave >= 80)) result = "합격";
		
		
		
		System.out.println("성명 : "+name);
		System.out.println("학년 : "+g);
		System.out.println("평균 : "+ave);
		System.out.println("결과 : "+result);
		
		
		

	}

}
