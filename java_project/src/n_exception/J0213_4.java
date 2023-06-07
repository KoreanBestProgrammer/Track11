package n_exception;

import java.util.Scanner;

public class J0213_4 {

	public static void main(String[] args) {
		J0213_4_sub sub = new J0213_4_sub();
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("국어점수 ? ");
	   // String kor = sc.next();
	    //System.out.println("영어점수 ? ");
        //String eng = sc.next();
		String kor = "80";
		String eng = "90";
        
        int total = 0;
		try {
			total = sub.getTotal(kor, eng);
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
        System.out.println("total : "+total);
        
        int ave = 0;
		try {
			ave = sub.getAve(total, "2kkk");
		} catch (Exception e) {			
			e.printStackTrace();
		}
        System.out.println("ave : "+ave);
        System.out.println("종료");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
