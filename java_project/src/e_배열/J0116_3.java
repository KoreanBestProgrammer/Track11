package e_배열;

import java.util.Scanner;

public class J0116_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명 ? ");
		int count = sc.nextInt();
		
		String name[] = new String[count];
		
		for(int k = 0 ; k < count ; k++) {
			System.out.print("사람 이름 ? ");
			name[k] = sc.next();			
		}
		
		for(int k = 0 ; k < count ; k++) {
			System.out.println("성명 : "+name[k]);
		}
		System.out.println("========================================");
		
		System.out.println("이름 검색? ");
		String search = sc.next();
		
		int order = 0;
		for(int k = 0 ; k < count ; k++) {
			if(name[k].indexOf(search) != -1) order = k;
		}
		            System.out.println("순서 : "+order);
		
		
	}

}
