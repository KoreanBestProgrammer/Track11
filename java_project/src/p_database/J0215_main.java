package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0215_main {

	public static void main(String[] args) {
		J0214_dao dao = new J0214_dao();
		Scanner sc = new Scanner(System.in);
		//J0214_dto dto = dao.getMemberInfo("A006");
		//
		//if(dto == null) {
		//	System.out.println("정보없음");
		//}else {				
		//	System.out.print("ID : "+dto.getId()+"\t");
		//	System.out.print("NAME : "+dto.getName()+"\t");
		//	System.out.print("AREA : "+dto.getArea()+"\t");
		//	System.out.println("AGE : "+dto.getAge());
		//}
		
		ArrayList<J0214_dto> arr =  dao.getMemberList("m.name","");
						
		dao.getArrPrint(arr);
		
		//if(arr.size() == 0) { 
			//System.out.println("정보없음");
		//}else {
		//	System.out.println("총 인원 : "+arr.size());
		//	for(int k = 0 ; k < arr.size() ; k++) {
		//	System.out.print("id : "+arr.get(k).getId()+"\t");
		//	System.out.print("name : "+arr.get(k).getName()+"\t");
		//	System.out.print("area : "+arr.get(k).getArea()+"\t");
		//	System.out.println("age : "+arr.get(k).getAge());
		//	}
		//}
		System.out.println("====================================================================");	
		System.out.println("성명검색 ? ");
		String name = sc.next();
		
		arr =  dao.getMemberList("m.name",name);
		
		dao.getPrintName(arr);
		
		//if(arr.size() == 0) { 
		//	System.out.println("정보없음");
		//}else {
		//	System.out.println("총 인원 : "+arr.size());
		//	for(int k = 0 ; k < arr.size() ; k++) {
		//	System.out.print("id : "+arr.get(k).getId()+"\t");
		//	System.out.print("name : "+arr.get(k).getName()+"\t");
		//	System.out.print("area : "+arr.get(k).getArea()+"\t");
		//	System.out.println("age : "+arr.get(k).getAge());
		//	}
		//}
		
		System.out.println("====================================================================");
		System.out.println("아이디검색 ? ");
		String id = sc.next();
		
		arr =  dao.getMemberList("m.id",id);
		
		dao.getPrintId(arr);
		
		
		
		
		
		

	}

}
