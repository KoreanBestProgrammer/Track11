package d_반복문;

import java.util.Scanner;

public class J0112_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 부터?");
		int start = sc.nextInt();
		
	    System.out.println("몇 까지?");
	    int end = sc.nextInt();
	    
	    
	    int jjack = 0;
	    for(int k = start ; k <= end ; k++) {
	   	      
	          if(k%2 == 0) {System.out.println("k : "+k);
	                        jjack = jjack + 1;
	    }
	          System.out.println("jjack : "+jjack);
	   
	    }
	    System.out.println("짝수 : "+jjack+"개");
}
}
