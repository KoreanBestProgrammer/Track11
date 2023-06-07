package b_if;

import java.util.Scanner;

public class J0106_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 ? ");
		String name = sc.next();
		System.out.println("성명 : "+name);  
		
		System.out.print("국어점수 ? ");
		int kor = sc.nextInt();
		System.out.println("국어점수 : "+kor+"점");
		
		System.out.print("영어점수 ? ");
		int eng = sc.nextInt();
		System.out.println("영어점수 : "+eng+"점");
		
		System.out.print("수학점수 ? ");
		int mat = sc.nextInt();
		System.out.println("수학점수 : "+mat+"점");
		
		int total = kor+eng+mat;
		System.out.println("총점 : "+total+"점");
		
		System.out.print("과목수 ? ");
		double count = sc.nextDouble();
		
		double everage = total/count;
		System.out.println("평균 : "+everage+"점");
		
		System.out.println("------------------------------------------------");
		
		System.out.print("선생님의 한마디 : ");
		System.out.println("여러분 수고했어요");
		
				
				
		
		
		
		
		
		
		
		
		
		
		

	}

}
