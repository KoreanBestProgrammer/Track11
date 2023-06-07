package e_배열;

import java.util.Scanner;

public class J0116_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇명? ");
		int count = sc.nextInt(); //3명
		
		String name[] = new String[count];
		
		for(int k = 0 ; k < count ; k++) {
            System.out.print((k+1)+"번째 성명 ? ");
            name[k] = sc.next();
	    }
		//출력
		for(int k = 0 ; k < count ; k++) {
			System.out.println("성명 : "+name[k]);
		}
		
   }
}
