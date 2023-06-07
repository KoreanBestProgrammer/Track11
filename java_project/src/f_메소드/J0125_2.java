package f_메소드;

import java.util.Scanner;

public class J0125_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0125_sub_2 sub = new J0125_sub_2();
		
		System.out.println("국어점수 ? ");
		int kor = sc.nextInt();
		System.out.println("영어점수 ? ");
		int eng = sc.nextInt();
		System.out.println("수학점수 ? ");
		int mat = sc.nextInt();
		
		int total = sub.getTotal(kor, eng, mat);
		double ave = sub.getTotal(total, 3);
		String result = sub.getTotal(ave);
		
		System.out.println(total);
		System.out.println(ave);
		System.out.println(result);

	}

}
