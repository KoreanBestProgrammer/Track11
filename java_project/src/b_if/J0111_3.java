package b_if;

import java.util.Scanner;

public class J0111_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("계절? 봄 :1, 여름 :2, 가을 :3, 겨울 :4");
		String season = sc.next();
		
		String result = "";
		
		if(season.equals("1")) {result = "3~5월";}
		else if(season.equals("2")) {result = "6~8월";}
		else if(season.equals("3")) {result = "9~11월";}
		else if(season.equals("4")) {result = "12~2월";}
		else result = "입력오류";
		
		System.out.println("월 : "+result);
		

	}

}
