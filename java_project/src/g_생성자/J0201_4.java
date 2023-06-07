package g_생성자;

import java.util.Scanner;

public class J0201_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str[] = new String[3];
		
		for(int k = 0 ; k < str.length ; k++) {
			System.out.println("ddddd");
			String dd = sc.next();
			str[k]=dd;
		}
		
		for(int k = 0 ; k < str.length ; k++) {
			System.out.println("str : "+str[k]);
		}

	}

}
