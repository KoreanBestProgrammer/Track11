package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0208_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0208_1_dao dao = new J0208_1_dao();
        
        System.out.print("몇 명 ? ");
        int count = sc.nextInt();
        
        ArrayList<J0208_1_dto> arr = new ArrayList<>();
        
        for(int k = 0 ; k < count ; k++) {
        	System.out.print("학년 ? ");
        	String grade = sc.next();
        	System.out.print("이름 ? ");
        	String name = sc.next();
        	System.out.print("반 ? ");
        	String ban = sc.next();
        	System.out.print("번호 ? ");
        	String number = sc.next();
        	System.out.print("국어점수 ? ");
        	int kor = sc.nextInt();
        	System.out.print("영어점수 ? ");
        	int eng = sc.nextInt();
        	System.out.print("수학점수? ");
        	int mat = sc.nextInt();
        	
        	J0208_1_dto dto = new J0208_1_dto(grade,name,ban,number,kor,eng,mat,count);
        	
        	arr.add(dto);
        }
        
       // dao.getPrint(arr);
        

		System.out.println("===========================================================");
		System.out.println("학년\t이름\t반\t번호\t국어\t영어\t수학");
		System.out.println("-----------------------------------------------------------");
		for(int k = 0 ; k < arr.size() ; k++) {	
			System.out.print(arr.get(k).getGrade()+"\t");			
			System.out.print(arr.get(k).getBan()+"\t");
			System.out.print(arr.get(k).getNumber()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"점\t");
			System.out.print(arr.get(k).getEng()+"점\t");
			System.out.print(arr.get(k).getMat()+"점\n");
		}
			System.out.println("=========================================================");
			System.out.println("총 "+arr.get(0).getCount()+"명"+"\t\t\t\t"+dao.getTotalKor(arr)+"점\t"
			                                           +dao.getTotalEng(arr)+"점\t"
					                                   +dao.getTotalMat(arr)+"점\t");
	
           System.out.println("\t\t\t\t"+dao.getTAveKor(arr)+"점\t"
        		                        +dao.getAveEng(arr)+"점\t"
        		                        +dao.getAveMat(arr)+"점\t");
        System.out.println("=========================================================");
        
	}

}
