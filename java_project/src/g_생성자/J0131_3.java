package g_생성자;

import java.util.Scanner;

public class J0131_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0131_1_dao dao = new J0131_1_dao();
		
		System.out.println("몇 명 ? ");
		int count = sc.nextInt();
		
		J0131_1_dto[] arr = new J0131_1_dto[count];
		
		for(int k = 0 ; k < arr.length ; k++) {
			System.out.print("이름  ?");
			String name = sc.next();
			System.out.print("국어점수  ?");
			int kor = sc.nextInt();	    	    
			System.out.print("영어점수  ?");
			int eng = sc.nextInt();
			System.out.print("수학점수  ?");
			int mat = sc.nextInt();
			J0131_1_dto dto = new J0131_1_dto(name,kor,eng,mat);
			arr[k] = dto;
			dao.setTotal(arr[k]);
			dao.setAve(arr[k]);			
					
		}
		
		dao.dtoArrPrint(arr);
		
       //for(int k = 0 ; k < arr.length ; k++) {
    	   
    	   //System.out.println("성명 : "+arr[k].getName());
    	   //System.out.println("총점 : " +arr[k].getTotal());
    	   //System.out.println("평균 : "+arr[k].getAve());
    	   
       }
	}


