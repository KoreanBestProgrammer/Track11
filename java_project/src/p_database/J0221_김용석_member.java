package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0221_김용석_member {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0221_김용석_dao dao = new J0221_김용석_dao();
		
		
		int gubun = 0;
		do {
			System.out.println("검색 : 전체[1], 성명[2], 지역[3], "+"\n"+
					           "등록[4], 수정[5], 삭제[6], 종료[0] ");
			gubun = sc.nextInt();
			if(gubun == 1) {//전체조회
				
				ArrayList<J0221_김용석_dto> arr = dao.getResult("name","");
				
				dao.ResultPrint(arr);
				
			}else if(gubun == 2) {//성명검색				
				System.out.println("이름검색");
				String search = sc.next();
				ArrayList<J0221_김용석_dto> arr = dao.getResult("name", search);
				
				dao.ResultPrint(arr);
				
			}else if(gubun == 3) {//지역검색
				System.out.println("지역검색");
				String search = sc.next();
				ArrayList<J0221_김용석_dto> arr = dao.getResult("area", search);
				
				dao.ResultPrint(arr);
				
			}else if(gubun == 4) {//등록
						
					System.out.println("id?");
					String id = sc.next();
					System.out.println("성명?");
					String name = sc.next();
					System.out.println("지역?");
					String area = sc.next();
					System.out.println("나이?");
					int age = sc.nextInt();
									
					J0221_김용석_dto dto = new J0221_김용석_dto(id, name, area, age);
					int inMember = dao.insertMember(dto);
				if(inMember == 1) {
					System.out.println("입력성공");
				}else {
					System.out.println("입력실패");
				}										
								
			}else if(gubun == 5) {//수정
				System.out.println("수정id?");
				String id = sc.next();
				J0221_김용석_dto dto = dao.getResultAll(id);
				ArrayList<J0221_김용석_dto> arr = new ArrayList<>();
				arr.add(dto);
				dao.ResultPrint(arr);
				
					System.out.println("수정하시겠습니까?");
					String yn = sc.next();
					if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
						System.out.println("이름?");
						String name = sc.next();
						System.out.println("지역?");
						String area = sc.next();
						System.out.println("나이?");
						int age = sc.nextInt();
                    
						J0221_김용석_dto dto2 = new J0221_김용석_dto(id, name, area, age);
                    
						int upMember =  dao.updateMember(dto2);
						if(upMember == 1) {
							System.out.println("수정성공");
						}else {
							System.out.println("수정실패");
						}
					}																			
			}else if(gubun == 6) {//삭제
				System.out.println("삭제 할 id?");
				String id = sc.next();
				ArrayList<J0221_김용석_dto> arr = dao.getResult("id", id);
				
				
				dao.ResultPrint(arr);
				
				System.out.println("삭제하겠습니까?");
				String yn = sc.next();
				if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
					 int deMember = dao.deleteMember(id);
					 if(deMember == 1) {
						 System.out.println("삭제성공");						 
					 }else {
						 System.out.println("삭제실패");
					 }
				}
			}
			
			
			
			
			
		}while(gubun != 0); { 
	        System.out.println("시스탬 종료");
		}

	}

}
