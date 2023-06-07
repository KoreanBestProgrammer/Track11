package c_swich;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇월입니까? ");
		String month = sc.next();
		
		String sea = "";
		
		switch(month) {case "1" : case "2" : case "12" :
			          sea = "겨울";
			          break;
		             case "3": case "4" : case "5" :
		              sea = "봄";
		              break;
		             case "6" : case "7" : case "8" :
		              sea = "여름";
		              break;
		             case "9" : case "10" : case "11" :
		              sea = "가을";
		              break;
		             default:
		              sea = "입력오류";
		}	 
			        	System.out.println("계절00 : "+sea);  
		
	}
}	

