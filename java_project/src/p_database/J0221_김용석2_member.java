package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0221_김용석2_member {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		J0221_김용석2_dao dao = new J0221_김용석2_dao();
		
		String gubun = "";
		do{
			System.out.println("전체 1, 성명,지역으로 찾기 2, 등록 3, 수정 4, 삭제 5, 종료0");
			gubun = sc.next();
		
			if(gubun.equals("1")) {
			ArrayList<J0221_김용석2_dto> arr = dao.getResult("");
			
			dao.getPrint(arr);
			
			}else if(gubun.equals("2")) {
				System.out.println("이름으로 찾으려면'1' 지역으로 찾으려면 '2'를 입력하시오");
				String namearea = sc.next();
				if(namearea.equals("1")) {
					namearea = "name";
				}else if(namearea.equals("2")) {
					namearea = "area";
				}else {
					System.out.println("다시입력하시오");
					continue;
				}
				System.out.println("찾을내용");
				String search = sc.next();
				ArrayList<J0221_김용석2_dto> arr = dao.getResultNameArea(namearea,search);
				dao.getPrint(arr);
			}else if(gubun.equals("3")) {				
				
				System.out.println("등록하시겠습니까?");
				String yn = sc.next();
				if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
					System.out.println("id");
					String id = sc.next();
					if(id.length() != 3) {
						System.out.println("3자리수입력");
						continue;
					}
					ArrayList<J0221_김용석2_dto> arr = dao.getResultNameArea("id", id);
					if(arr.size() != 0) {
						System.out.println("아이디중복");
						continue;
					}
					System.out.println("name");
					String name = sc.next();
					System.out.println("area");
					String area = sc.next();
					System.out.println("age");
					int age = sc.nextInt();
					
					J0221_김용석2_dto dto = new J0221_김용석2_dto(id, name, area, age);
					int inMember = dao.insertMember(dto);
					if(inMember == 1) {
						System.out.println("입력성공");
					}else {
						System.out.println("입력실패");
					}
				}
					
					
				}else if(gubun.equals("4")) {
					System.out.println("찾을 id?");
					String id = sc.next();
					ArrayList<J0221_김용석2_dto> arr = dao.getResultNameArea("id", id);
					if(arr.size() == 0) {
						System.out.println("정보없음");
					}else {
						dao.getPrint(arr);
				
						System.out.println("수정하시겠습니까?");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {					
							System.out.println("name");
							String name = sc.next();
							System.out.println("area");
							String area = sc.next();
							System.out.println("age");
							int age = sc.nextInt();
						
							J0221_김용석2_dto dto = new J0221_김용석2_dto(id, name, area, age);
							int upMember = dao.updateMember(dto);
							if(upMember == 1) {
								System.out.println("수정성공");
							}else {
								System.out.println("수정실패");
							}
						}
					}
				
			}else if(gubun.equals("5")) {
				System.out.println("삭제id?");
				String id = sc.next();
				ArrayList<J0221_김용석2_dto> arr = dao.getResultNameArea("id", id);
				if(arr.size() == 0) {
					System.out.println("정보없음");
				}else {
					dao.getPrint(arr);
				
					System.out.println("삭제하시겠습니까?");
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
			}
		}while(!gubun.equals("0"));
	      System.out.println("종료~~");
		
	}

}
