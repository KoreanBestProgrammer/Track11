package b_if;

import java.util.Scanner;

public class J0109_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      System.out.print("국어점수 ?");
      int kor = sc.nextInt();
      
      System.out.print("영어점수 ?");
      int eng = sc.nextInt();
      
      System.out.print("수학점수 ?");
      int mat = sc.nextInt();
      
      int total = kor+eng+mat;
      int ave = total/3;
      
      String result = "";
      if(ave >= 90) {result = "A";}
      else if(ave >=80) {result = "B";}
      else if(ave >=70) {result = "C";}
      else {result = "F";}
 
      
      System.out.println("총점 : "+total);
      System.out.println("평균 : "+ave);
      System.out.println("결과 : "+result);
      
}
    		  
      
      
      
      
     
	}


