package b_if;

import java.util.Scanner;

public class J0110_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학년 ?");
		int grade = sc.nextInt();
		
		if(grade >=1 && grade <=6) {
		System.out.println("평균 ?");
		int ave = sc.nextInt();
		
		String result = "불합격";
		 
		
		if((grade >= 1 && grade <= 3) && (ave >= 70)) { result = "합격";}
		else if ((grade >= 4 && grade <= 6) && (ave >=80)) {result = "합격";}
	
		System.out.println(grade+"학년"+result);
		}
		else {System.out.println("학년입력오류");}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		String grade = sc.next();
		int level = Integer.parseInt(grade);
		if(level>=1 && level <=6) {
		
		System.out.println("평균 ?");
        int ave = sc.nextInt();
        
        String a = "";
        
        if(grade.equals("1") && ave >= 60) {a = "1학년 합격";}
        else if(grade.equals("2") && ave >= 60) {a = "2학년 합격";}
        else if(grade.equals("3") && ave >= 70) {a = "3학년 합격";}
        else if(grade.equals("4") && ave >= 70) {a = "4학년 합격";}
        else if(grade.equals("5") && ave >= 80) {a = "5학년 합격";}
        else if(grade.equals("6") && ave >= 80) {a = "6학년 합격";}
        else {System.out.println("불합격");}
        System.out.println(a);}
		else {System.out.println("학년입력오류");}
 */       
        
        
	}

}
