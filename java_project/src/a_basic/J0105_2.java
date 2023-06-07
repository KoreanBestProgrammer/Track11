package a_basic;

import java.util.Scanner;

public class J0105_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성명 ? ");
		String name = sc.next();
		
		System.out.print("국어 ? ");
		int kor = sc.nextInt();
		
		System.out.print("영어 ? ");
		int eng = sc.nextInt();
		
		System.out.print("수학 ? ");
		int mat = sc.nextInt();
        
		System.out.println("----------------------------------------------------");
		
		System.out.println("성명 : "+name);
		System.out.println("국어 : "+kor+"점");
		System.out.println("영어 : "+eng+"점");
		System.out.println("수학 : "+mat+"점");
		
		int total = kor+eng+mat;
		System.out.println("총점 : "+total+"점");

        double average = total/3.0;
		System.out.println("평균 : "+average+"점");
		
		
		
		
		
		
	}

}
