package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Consulting_김용석_main {

	public static void main(String[] args) {				
		Scanner sc= new Scanner(System.in);
		Cstudent_김용석_dao studao = new Cstudent_김용석_dao();
		Cmentor_김용석_dao mendao = new Cmentor_김용석_dao();		
		Consulting_김용석_dao condao = new Consulting_김용석_dao();
		
		String gubun = "";
		do {
			System.out.println("[S]학생관리, [M]멘토관리, [C]상담관리, [Q]종료");
			gubun = sc.next();
			if(gubun.equalsIgnoreCase("S") || gubun.equals("ㄴ")) {
				int gubun2 = 0;
				do {
					System.out.println("조회[1], 등록[2], 수정[3], 삭제[4], 뒤로[5]");
					gubun2 = sc.nextInt();
					if(gubun2 == 1) {	
						System.out.println("전체조회[1], 학번조회[2], 성명조회[3]");
						String searchgubun = sc.next();
						if(searchgubun.equals("1")) {
							ArrayList<Cstudent_김용석_dto> arr = studao.stuResultAll("id","");				
							studao.stuPrint(arr);
						}else if(searchgubun.equals("2")) {
							System.out.println("찾을학번?");
							String search = sc.next();
							ArrayList<Cstudent_김용석_dto> arr2 = studao.stuResultAll("id", search);
							studao.stuPrint(arr2);
						}else if(searchgubun.equals("3")) {
							System.out.println("찾을성명?");
							String search = sc.next();
							ArrayList<Cstudent_김용석_dto> arr3 = studao.stuResultAll("name", search);
							studao.stuPrint(arr3);
						}
					}else if(gubun2 == 2) {
						System.out.println("등록하시겠습니까?");
						String yn = sc.next();
						if(yn.equalsIgnoreCase("y") || yn.equals("ㅛ")) {
							System.out.println("등록할id?");
							String id = sc.next();
							if(id.length() != 4) {
								System.out.println("4글자를 입력하시오");
								continue;
							}
							ArrayList<Cstudent_김용석_dto> arr = studao.stuResultAll("id", id);
							if(arr.size() != 0) {
								System.out.println("id중복입력함");
								continue;
							}else {
							    System.out.println("등록할 성명?");
							    String name = sc.next();
								System.out.println("등록할 나이?");
								int age = sc.nextInt();
															
								int result = studao.insertStudent(id,name,age);
								if(result == 1) {
									System.out.println("등록성공");
								}else {
									System.out.println("등록실패");
								}
							}	
						}						
					}else if(gubun2 == 3) {
						System.out.println("수정할 id?");
						String id = sc.next();
						Cstudent_김용석_dto dto = studao.stuResultId(id);
						if(dto == null) {
							System.out.println("id정보없음");
							continue;
						}else {
							studao.stuPrintId(dto);
							System.out.println("수정하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
								System.out.println("성명");
								String name = sc.next();
								System.out.println("나이?");
								int age = sc.nextInt();
								
								int result = studao.updateStudent(id,name,age);
								if(result == 1) {
									System.out.println("수정성공");
								}else {
									System.out.println("수정실패");
								}
							}								
						}
					}else if(gubun2 == 4) {
						System.out.println("삭제할id?");
						String id = sc.next();
						Cstudent_김용석_dto dto = studao.stuResultId(id);
						if(dto == null) {
							System.out.println("id정보없음");
							continue;
						}else if(condao.getResultId("sid", id) != null) {
							System.out.println("상담테이블에서 사용중!");
						}else {
							studao.stuPrintId(dto);
							System.out.println("삭제하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
								int result = studao.deleteStudent(id);
								if(result == 1) {
									System.out.println("삭제성공");
								}else {
									System.out.println("삭제실패");
								}
							}
						}
					}					
				}while(gubun2 != 5);
				
			}else if(gubun.equalsIgnoreCase("M") || gubun.equals("ㅡ")) {
				int gubun2 = 0;
				do {
					System.out.println("조회[1], 등록[2], 수정[3], 삭제[4], 뒤로[5]");				
					gubun2 = sc.nextInt();
					if(gubun2 == 1) {
						System.out.println("전체[1], id or 성명으로 찾기[2]");
						String searchgubun = sc.next();
						if(searchgubun.equals("1")) {
							ArrayList<Cmentor_김용석_dto> arr = mendao.menResultAll("id","");
							mendao.menPrintAll(arr);
						}else if(searchgubun.equals("2")) {
							System.out.println("id[1], 성명[2]");
							String searchidname = sc.next();
							if(searchidname.equals("1")) {
								searchidname = "id";
							}else if(searchidname.equals("2")) {
								searchidname = "name";
							}
							System.out.println("검색할 내용");
							String search = sc.next();
							ArrayList<Cmentor_김용석_dto> arr2 = mendao.menResultAll(searchidname, search);
							mendao.menPrintAll(arr2);
						}
					}else if(gubun2 == 2) {
						System.out.println("등록하시겠습니까?");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
							System.out.println("등록할id?");
							String id = sc.next();
							if(id.length() != 4) {
								System.out.println("4자리입력하삼");
								continue;
							}
							ArrayList<Cmentor_김용석_dto> arr = mendao.menResultAll("id", id);
							if(arr.size() != 0) {
								System.out.println("id중복입력함");
								continue;
							}
							System.out.println("등록할 이름?");
							String name = sc.next();
							
							Cmentor_김용석_dto dto = new Cmentor_김용석_dto(id, name);															
							int result = mendao.insertMentor(dto);
							if(result == 1) {
								System.out.println("등록성공");
							}else {
								System.out.println("등록실패");
							}						
						}
					}else if(gubun2 == 3) {
						System.out.println("수정할 ID?");
						String id = sc.next();
						Cmentor_김용석_dto dto = mendao.menResultId(id);
						if(dto == null) {
							System.out.println("id정보없음");
							continue;
						}else {
							mendao.menPrintId(dto);
							System.out.println("수정하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
								System.out.println("수정할 성명");
								String name = sc.next();
							
								 Cmentor_김용석_dto dto2 = new Cmentor_김용석_dto(id, name);
								 int result = mendao.updateMentor(dto2);
								 if(result == 1) {
									 System.out.println("수정성공");
								 }else {
									 System.out.println("수정실패");
								 }
							} 
						}						
					}else if(gubun2 == 4) {
						System.out.println("삭제할ID?");
						String id = sc.next();
						Cmentor_김용석_dto dto = mendao.menResultId(id);
						if(dto == null) {
							System.out.println("id정보없음");
							continue;
						}else if(condao.getResultId("mid", id) != null){
							System.out.println("상담테이블에서 사용중!");
					    }else {	
					    	mendao.menPrintId(dto);
							System.out.println("삭제하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
								int result = mendao.deleteMentor(id);
								if(result == 1) {
									System.out.println("삭제성공");
								}else {
									System.out.println("삭제실패");
								}
							}
						}																
					}
				}while(gubun2 != 5);	
			}else if(gubun.equalsIgnoreCase("C") || gubun.equals("ㅊ")) {				
				int gubun2 = 0;
				do {	
					System.out.println("조회[1], 등록[2], 수정[3], 삭제[4], 뒤로[5]");
					gubun2 = sc.nextInt();
					
					if(gubun2 == 1) {
						System.out.println("전체조회[1], 학생 or 멘토 번호조회[2], 날짜조회[3]");
						String searchgubun = sc.next();
						if(searchgubun.equals("1")) {
							ArrayList<Consulting_김용석_dto> arr = condao.conResultAll("no","");
							condao.conPrintAll(arr);
						}else if(searchgubun.equals("2")) {
							System.out.println("학생조회[1], 멘토조회[2]");
							String searchstumen = sc.next();
							if(searchstumen.equals("1")) {
								searchstumen = "sid";
							}else if(searchstumen.equals("2")) {
								searchstumen = "mid";
							}
							System.out.println("검색할 내용?");
							String search = sc.next();
							ArrayList<Consulting_김용석_dto> arr2 = condao.conResultAll(searchstumen, search);
							condao.conPrintAll(arr2);
						}else if(searchgubun.equals("3")) {
							System.out.println("찾을 날짜?");
							String searchdate = sc.next();
							ArrayList<Consulting_김용석_dto> arr3 = condao.conResultAll("cdate", searchdate);
							condao.conPrintAll(arr3);
						}
					}else if(gubun2 == 2) {
						System.out.println("등록하시겠습니까?");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
							System.out.println("등록할 id?");
							String id = sc.next();
							if(id.length() != 4) {
								System.out.println("id 4자리 입력!");
								continue;
							}
							Consulting_김용석_dto dto = condao.getResultId("no",id);
							if(dto != null) {
								System.out.println("id중복입력! 다시입력하시오");
								continue;
							}							
							System.out.println("학생번호?");
							String sid = sc.next();
							if(studao.stuResultId(sid) == null) {
								System.out.println("없는학생id입니다!");
								continue;
							}
							System.out.println("멘토번호?");
							String mid = sc.next();
							if(mendao.menResultId(mid) == null) {
								System.out.println("없는멘토id입니다!");
								continue;
							}
							System.out.println("상담일자");
							String date = sc.next();
							
							Consulting_김용석_dto dto2 = new Consulting_김용석_dto(id, sid, mid, date);
							int result = condao.insertConsult(dto2);
							if(result == 1) {
								System.out.println("등록성공");
							}else {
								System.out.println("등록실패");
							}
						}
					}else if(gubun2 == 3) {
						System.out.println("수정할id?");
						String id = sc.next();
						Consulting_김용석_dto dto = condao.getResultId("no",id);
						if(dto == null) {
							System.out.println("id정보없음");
							continue;
						}else {
							condao.conPrintId(dto);
							System.out.println("수정하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {								
								System.out.println("수정할 학생번호");
								String sid = sc.next();
								if(studao.stuResultId(sid) == null) {
									System.out.println("없는학생id입니다.");
									continue;
								}
								System.out.println("수정할 멘토번호");								
								String mid = sc.next();
								if(mendao.menResultId(mid) == null) {
									System.out.println("없는멘토id입니다");
									continue;
								}
								System.out.println("수정할 날짜");
								String cdate = sc.next();
								
								int result = condao.updateConsult(id,sid,mid,cdate);
								if(result == 1) {
									System.out.println("수정성공");
								}else {
									System.out.println("수정실패");
								}
							}
						}
					}else if(gubun2 == 4) {
						System.out.println("삭제할id?");
						String id = sc.next();
						Consulting_김용석_dto dto = condao.getResultId("no",id);
						if(dto == null) {
							System.out.println("id정보없음");
							continue;
						}else {
							condao.conPrintId(dto);
							System.out.println("삭제하시겠습니까?");
							String yn = sc.next();
							if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
								int result = condao.deleteConsult(id);
								if(result == 1) {
									System.out.println("삭제성공");
								}else {
									System.out.println("삭제실패");
								}
							}	
						}	
					}											
				}while(gubun2 != 5) ; 
			}																						
		}while(!gubun.equalsIgnoreCase("Q") && !gubun.equals("ㅂ"));
               System.out.println("종료~~~~");
	}
}
