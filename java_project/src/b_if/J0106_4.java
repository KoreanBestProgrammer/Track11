package b_if;

import java.util.Scanner;

public class J0106_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 학년?");
		int g = sc.nextInt();
		
		System.out.print("점수");
		int s = sc.nextInt();
		
		if(((g == 1) || (g == 2) || (g == 3)) && (s >= 70)) {System.out.println("합격");}
		else if(((g == 4) || (g == 5) || (g == 6)) && (s >=80)) {System.out.println("합격");}
		else if(g >=7) {System.out.println("학년입력오류");} 
		else if((s > 100) ||( s < 0)) {System.out.println("점수입력오류");}
		else {System.out.println("불합격");}
		
		
		
        				
	

}
}