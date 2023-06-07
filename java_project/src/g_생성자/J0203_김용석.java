package g_생성자;

import java.util.Scanner;

public class J0203_김용석 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		J0203_김용석_dao dao = new J0203_김용석_dao();
		
		System.out.println("몇 명 ? ");
		int count = sc.nextInt();
		
		J0203_김용석_dto arr[] = new J0203_김용석_dto[count];
		
		for(int k = 0 ; k < arr.length ; k++) {
			System.out.println("성명 ? ");
		    String name = sc.next();
		    System.out.println("국어 ? ");
		    int kor = sc.nextInt();
		    System.out.println("영어 ? ");
		    int eng = sc.nextInt();
		    System.out.println("수학 ? ");
		    int mat = sc.nextInt();
		    
		    int ave = dao.getAve(kor, eng, mat);
		    String result = dao.getResult(ave);
		    
		    J0203_김용석_dto dto = new J0203_김용석_dto(name,result,kor,eng,mat,ave);
		    										
		    arr[k] = dto;		    		    
		}
		
		
		System.out.println("=====================================================================================");
		System.out.println("성명"+"\t"+"국어점수"+"\t"+"영어점수"+"\t"+"수학점수"+"\t"+"평균점수"+"\t"+"결과"+"\t");
		System.out.println("-------------------------------------------------------------------------------------");
		dao.getPrint(arr);
		
		//for(int k = 0 ; k < arr.length ; k++) {											
			//System.out.print(arr[k].getName()+"\t");
			//System.out.print(arr[k].getKor()+"\t");
			//System.out.print(arr[k].getEng()+"\t");
			//System.out.print(arr[k].getMat()+"\t");
			//System.out.print(arr[k].getAve()+"\t");
			//System.out.print(arr[k].getResult()+"\n");														
			//}
		
		System.out.println("성명 검색 ? ");
		String search = sc.next();
		dao.getSearch(arr, search);
		
		
		
		}
	}
	
	
