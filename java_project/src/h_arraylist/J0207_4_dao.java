package h_arraylist;

import java.util.ArrayList;

public class J0207_4_dao {

	String getDepart(String a) {
		String result = "";
		
		if(a.equals("10")) result = "총무";
		else if(a.equals("20")) result = "재무";
		else if(a.equals("30")) result = "영업";
		else result = "부서입력오류";
		
		return result;
		
	}
	
	String getRank(String b) {
		String result = "";
		
		if(b.equals("s")) result = "사원";
		else if(b.equals("d")) result = "대리";
		else if(b.equals("g")) result = "과장";
		else result = "직위입력오류";
		
		return result;
	}
	
	void getPrint(ArrayList<J0207_4_dto> arr) {

		System.out.println("===================================");
		System.out.println("ID\t성명\t나이\t부서\t직위");
		System.out.println("-----------------------------------");
	    for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getAge()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.println(arr.get(k).getRank());
	    }
	    System.out.println("===================================");												
	}
		
		
	}
	
	
	

