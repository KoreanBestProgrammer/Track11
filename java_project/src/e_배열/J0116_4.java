package e_배열;

import java.util.Scanner;

public class J0116_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 과목 ? ");
		int count = sc.nextInt();
				
		int score[] = new int[count];
		int total = 0;
		for(int k = 0 ; k < count ; k++) {			
			System.out.print((k+1)+"번째 점수 ? ");
			score[k] = sc.nextInt();
			total += score[k];
		}
          System.out.println("==================");
          //출력
          
        for(int k = 0 ; k < count ; k++) { 
        	System.out.print(score[k]+"\t");
        	
        }
        System.out.print("총합 : "+total);
        
        
	}

}
