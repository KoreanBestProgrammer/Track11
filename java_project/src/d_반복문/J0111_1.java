package d_반복문;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 단? ");
		int dan = sc.nextInt();
		
		for(int k=1;k<=9;k++) {
			System.out.println(dan + " * "+ k + " = " + (dan * k));
			
		}

	}

}
