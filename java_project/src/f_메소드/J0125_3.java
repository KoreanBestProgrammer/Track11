package f_메소드;

import java.util.Scanner;

public class J0125_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0125_sub_3 sub = new J0125_sub_3();
		
		System.out.println("기본 급여 ? ");
		int basic = sc.nextInt();
		System.out.println("남여? 남:1, 여:2");
		String gender = sc.next();
		
		int pay = sub.getPay(basic, gender);
        System.out.println("급여 : "+pay);
	}

}
