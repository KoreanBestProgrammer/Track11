package d_반복문;

import java.util.Scanner;

public class J0112_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 부터 ?");
		int start = sc.nextInt();
		System.out.println("몇 까지 ?");
		int end = sc.nextInt();
		
		int total = 0;
		
		for(int k=start;k<=end;k++) { 
			total = k+1;
		                             
		}
		
		             
           System.out.println("total : "+total);
	}

}
