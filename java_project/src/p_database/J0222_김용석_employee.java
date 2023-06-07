package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0222_김용석_employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0222_김용석_employee_dao dao = new J0222_김용석_employee_dao();
		//총무 인사 재무 영업 , 사원 대리 부장 과장
		int gubun = 0;
		do {
			System.out.println("전체조회[1], 등록[2], 수정[3], 삭제[4], 종료[0] ");
			 gubun = sc.nextInt();
			 
			 if(gubun == 1) {
				 System.out.println("전체[A], 사번[I], 성명[N], 부서[D], 직위[R]");
				 String searchgubun = sc.next();
					 if(searchgubun.equals("A") || searchgubun.equals("a") || searchgubun.equals("ㅁ")) {
						 ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("id", "");
						 dao.printResult(arr);
						 
					 }else if(searchgubun.equals("I") || searchgubun.equals("i") || searchgubun.equals("ㅑ")) {
						 System.out.println("사번?");
						 String id = sc.next();
						 ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("id", id);
						 dao.printResult(arr);
						 
					 }else if(searchgubun.equals("N") || searchgubun.equals("n") || searchgubun.equals("ㅜ")) {
						 System.out.println("성명?");
						 String name = sc.next();
						 ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("name", name);
						 dao.printResult(arr);
						 
					 }else if(searchgubun.equals("D") || searchgubun.equals("d") || searchgubun.equals("ㅇ")) {
						 System.out.println("부서?");
						 String depart = sc.next();
						 ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("depart", depart);
						 dao.printResult(arr);
						 
					 }else if(searchgubun.equals("R") || searchgubun.equals("r") || searchgubun.equals("ㄱ")) {
						 System.out.println("직위?");
						 String rank = sc.next();
						 ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("rank", rank);
						 dao.printResult(arr);
					 }
				 
			 }else if(gubun == 2) {
				 System.out.println("등록하시겠습니까?");
				 String yn = sc.next();
					 if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
						 System.out.println("id?");
						 String id = sc.next();
						 if(id.length() != 3) {
							 System.out.println(" id입력오류! 3글자로 입력하시오");
							 continue;
						 }
						 
						 int count = dao.checkId(id);
						 if(count == 1) {
							 System.out.println("중복된id!");
						 }else {							 						 
						 
						/* ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("id", id);
						 if(arr.size() != 0) {
							 System.out.println("id중복입력함! 다시입력하시오.");
							 continue;
						 }*/					 					 
						 System.out.println("name?");
						 String name = sc.next();
						 System.out.println("depart");
						 String depart = sc.next();
						 System.out.println("rank?");
						 String rank = sc.next();
						 System.out.println("age?");
						 int age = sc.nextInt();
						 
						 J0222_김용석_employee_dto dto = new J0222_김용석_employee_dto(id, name, depart, rank, age);
						 //int result = dao.insertEmployee(dto);
						 int result = dao.insertEmployee(id,name,depart,rank,age);
							 if(result == 1) {
								 System.out.println("입력성공");
							 }else {
								 System.out.println("입력실패");
							 }
					 	 }
					 }				 			 
			 }else if(gubun == 3) {
				System.out.println("수정할id?");
				String id = sc.next();
				//J0222_김용석_employee_dto dto = dao.getIdInfo(id);
				//if(dto == null) {
					ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("id", id);				
					if(arr.size() == 0) {
						System.out.println("id정보없음");
						continue;
					}else {	
						//dao.resultPrintDto(dto);
						dao.printResult(arr);
						
						System.out.println("수정하시겠습니까?");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {																													
								System.out.println("name?");
								String name = sc.next();
								System.out.println("depart?");
								String depart = sc.next();
								System.out.println("rank?");
								String rank = sc.next();
								System.out.println("age?");
								int age = sc.nextInt();
								
								J0222_김용석_employee_dto dto2 = new J0222_김용석_employee_dto(id, name, depart, rank, age);
								//int result = dao.updateEmployee(dto2);
								int result = dao.updateEmployee(id,name,depart,rank,age);
								if(result == 1) {
									System.out.println("수정성공");
								}else {
									System.out.println("수정실패");
								}
							}
						}
					 				 
			 }else if(gubun == 4) {
					System.out.println("삭제할 id?");
					String id = sc.next();				 	
					//ArrayList<J0222_김용석_employee_dto> arr = dao.getResultAll("id", id);				 	
				    //if(arr.size() == 0) {
					 	J0222_김용석_employee_dto dto = dao.getIdInfo(id);
					 	if(dto == null) {						 				
						    System.out.println("id정보없음");
						    continue;
						}else {
							dao.resultPrintDto(dto);
							//dao.printResult(arr);
							
							System.out.println("삭제하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {						 						 							 							 								 
								int result = dao.deleteMember(id);
								if(result == 1) {
									System.out.println("삭제성공");
								}else {
									System.out.println("삭제실패");
								}
							}
						}
			 }
			 
		}while(gubun != 0);
			System.out.println("종료~~~~~~~~~");
		
		
		
		
		
		
		}

}
