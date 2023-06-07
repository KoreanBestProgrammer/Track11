package d_반복문;

import java.util.Scanner;

public class J0112_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 단 부터? ");
		int start = sc.nextInt();
		
		System.out.println("몇 단 까지? ");
		int end   = sc.nextInt();
		
		
		for(int k=start;k<=end;k++) {
		for(int j=1;j<=9;j++) {    		
           System.out.println(k+"*"+j+"="+(k*j));   
		}
		
	}

}
}