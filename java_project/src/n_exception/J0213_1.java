package n_exception;

import java.util.Scanner;

public class J0213_1 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		System.out.println("시스탬 시작~");
		String kor= "100";
				
		int korNum = 0;
		try {    //try영역에서 오류가 발생하면 catch가 실행된다. 오류가 발생하지않으면 catch는 실행되지 않는다.
			                                          //(try영역 안에서는 오류가 난 부분부터 실행이 멈춘다.)
			System.out.println("try 100");
			korNum = Integer.parseInt(kor);
			System.out.println("try 111");
		}catch(Exception e) {  
			System.out.println("오류~~");
		}finally {   //오류가 발생하던 안하던 무조건 finally문을 실행해라.
			System.out.println("finally~~~");
		}
		
		System.out.println("korNum : "+korNum);
		
		System.out.println("시스탬 종료~");

	}

}
