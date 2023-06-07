package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0216_main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		J0216_student_dao dao = new J0216_student_dao();
		
		ArrayList<J0216_student_dto> arr = dao.getStu();
		
			
		dao.ResultPrint(arr);
		
		int gubun = 0;
		do {
			System.out.println("검색 전체[1], id[2], 성명[3], 등록[4], 수정[5], 삭제[6], 종료[0]?");
	        gubun = sc.nextInt();
	        if(gubun == 1) {
	        	ArrayList<J0216_student_dto> arr2 = dao.getSearchList("id","");
	        	dao.ResultPrint(arr2);
	        }
	        else if(gubun == 2) {
				System.out.println("id?");
				String id = sc.next();
				ArrayList<J0216_student_dto> arr2 = dao.getSearchList("id",id);
				dao.ResultPrint(arr2);
			}
	        else if(gubun == 3) {
				System.out.println("성명?");
				String name = sc.next();
				ArrayList<J0216_student_dto> arr2 = dao.getSearchList("name",name);
				dao.ResultPrint(arr2);
			}
	        else if(gubun == 4) {
	        	System.out.println("id?");
	        	String id = sc.next();
	        	
	        	if(id.length() != 3) {
	        		System.out.println("id입력오류, 3자리입력!");
	        		continue;             //continue : if문의 조건에 맞을 때 (오류가 있을때) 실행이 중단되고 다시 처음 질문으로 돌아감.
	        	}
	        	
	        	System.out.println("성명?");
	        	String name = sc.next();
	        	
	        	if(name.length() > 6) {
	        		System.out.println("이름입력오류,6자이내입력!");
	        	    continue;
	        	}
	        	
	        	int kor = 0, eng = 0, mat = 0;
	        	System.out.println("국어점수?");	              	
	        	try {
	        		 kor = sc.nextInt();
	        	}catch(Exception e) {
	        		System.out.println("국어점수입력오류!");
	                kor = 101;
	        	}
	        	if(kor > 100 || kor < 0) {
	        		System.out.println("점수입력오류, 0~100사이");
	        		continue;
	        	}
	        	
	        	System.out.println("영어점수?");	        	
	        	try {
	        		eng = sc.nextInt();
	        	}catch(Exception e) {
	        		System.out.println("영어점수입력오류!");
	        		eng = -1;
	        	}
	        	if(eng > 100 || eng < 0) {
	        		System.out.println("점수입력오류, 0~100사이");
	        		continue;
	        	}
	        	
	        	System.out.println("수학점수?");	        	
	        	try {
	        		 mat = sc.nextInt();   		
	        	}catch(Exception e) {
	        		System.out.println("수학점수입력오류!");	
	        		mat = -1;
	        	}
	        	if(mat > 100 || mat < 0) {
	        		System.out.println("점수입력오류, 0~100사이");
	        		continue;
	        	}
	        	
	        	int total = dao.getTotal(kor,eng,mat);
	        	String result = dao.getResult(total);
	        	
	        	J0216_student_dto dto = new J0216_student_dto(id, name, kor, eng, mat, total, result);
	        	
	        	int yn = dao.saveStudent(dto);            //insert update delete는 int로 받음
	        	if(yn == 1) System.out.println("등록됨");
	        	else System.out.println("등록실패");
	        }else if(gubun ==5) {
	        	System.out.print("수정id?");
	        	String id = sc.next();
	        	if(id.length() != 3) {
	        		System.out.println("id 3자리 입력!");
	        	}else {
	        		
	        		J0216_student_dto dto = dao.getStudentinfo(id);
	        		if(dto == null) {
	        			System.out.println("정보없음");
	        		}else {
	        			ArrayList<J0216_student_dto> arr4 = new ArrayList<>();
	        			arr4.add(dto);
	        			dao.ResultPrint(arr4);
	        			
	        			System.out.println("수정하시겠습니까? 예[y], 아니오[n]");
	        			String yn = sc.next();
	        			if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
	        				System.out.println("성명?");
	        				String name = sc.next();
	        				System.out.println("국어점수?");
	        				int kor = sc.nextInt();
	        				System.out.println("영어점수?");
	        				int eng = sc.nextInt();
	        				System.out.println("수학점수?");
	        				int mat = sc.nextInt();
	        				int total = dao.getTotal(kor, eng, mat);
	        				String result = dao.getResult(total);
	        				
	        				J0216_student_dto dto2 = new J0216_student_dto(id, name, kor, eng, mat, total, result);
	        				int updateResult = dao.updateStudent(dto2);
	        				if(updateResult == 1) {
	        					System.out.println("수정성공");
	        				}else {
	        					System.out.println("수정실패");
	        				}
	        			}  	        			
	        		}	        		        		
	        	}	        		        		        	
	        }else if(gubun == 6) {
	        	System.out.println("수정id?");
	        	String id = sc.next();
	        	
	        	J0216_student_dto dto = dao.getStudentinfo(id);
	        	if(dto == null) {
	        		System.out.println("정보없음");
	        	}else {
	        		ArrayList<J0216_student_dto> arr5 = new ArrayList<>();
	        		arr5.add(dto);
	        		dao.ResultPrint(arr5);
	        		System.out.println("삭제? 에[y], 아니오[n]");
	        		String yn = sc.next();
	        		if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
	        			int deleteResult = dao.deleteStudent(id);
	        			if(deleteResult == 1) {
	        				System.out.println("삭제성공");
	        			}else { 
	        				System.out.println("삭제실패");	        				
	        			}
	        		}
	        	}	        		        	
	        }
	        
	        
	        
		}while(gubun != 0);{
			System.out.println("종료~~~~~");
			
			
			
		}
       
		
		
		
		
		
		
		
		
		
	}
}
