package e_배열;

import java.util.Scanner;

public class J0118_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 명 ? ");
		int row = sc.nextInt();
		System.out.print("몇 과목 ? ");
		int col = sc.nextInt();
		
		String score[][] = new String[row][col+1];
		
		for(int k = 0 ; k < score.length ; k++) {
			for(int j = 0 ; j < score[k].length ; j++) {           // k문은 행의 개수를 나타냄
				if(j == 0) {                                       // j문은 하나의 행을 나타냄
					System.out.print("성명 ? " );
					score[k][j] = sc.next();
				} else {
					System.out.print(j + "번째 점수"); 
					score[k][j] = sc.next();
				}
				          
			}
		}
        for(int k = 0 ; k < score.length ; k++) {
        	for(int j = 0 ; j < score[k].length ; j++) {
        		System.out.print(score[k][j]+"\t");
        	}
        	System.out.print("\n");
        }
	}

}
