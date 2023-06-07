package h_arraylist;

import java.util.ArrayList;

public class J0209_1_dao {

	
	int getMoney(String gender, int age) {
		int result = 1000000;
		
	    if(gender.equals("남") )  result = result+200000;
	    else if(gender.equals("여")) result = result+300000;
	    		
		if(age >= 25) result = result+100000;
		
		if(!gender.equals("남") && !gender.equals("여"))  result = 0;
				
		return result;
	}
	
	void getPrint(ArrayList<J0209_1_dto> arr) {
		System.out.println("==========================================");
		System.out.println("성명\t성별\t나이\t급여");
		System.out.println("-------------------------------------------");
		for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getGender()+"\t");
			System.out.print(arr.get(k).getAge()+"\t");
			System.out.print(arr.get(k).getMoney()+"\n");
		}
		System.out.println("===========================================");
		
		
	}
	
	void getSearch(ArrayList<J0209_1_dto> arr,String search) {
		System.out.println("==========================================");
		System.out.println("성명\t성별\t나이\t급여");
		System.out.println("-------------------------------------------");
		for(int k = 0 ; k < arr.size() ; k++) {
			if(arr.get(k).getName().indexOf(search) != -1) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getGender()+"\t");
			System.out.print(arr.get(k).getAge()+"\t");
			System.out.print(arr.get(k).getMoney()+"\n");
			}
		}
		System.out.println("===========================================");
		
		
		
	}
}
