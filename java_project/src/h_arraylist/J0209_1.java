package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0209_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0209_1_dao dao = new J0209_1_dao();
		System.out.println("몇 명?");
		int count = sc.nextInt();
		
		ArrayList<J0209_1_dto> arr = new ArrayList<>();

		for(int k = 0 ; k <count ; k++) {
			System.out.print("성명 ? ");
			String name = sc.next();
			System.out.print("성별 ? ");
			String gender = sc.next();
			System.out.print("나이 ? ");
			int age = sc.nextInt();
			
			int money = dao.getMoney(gender, age);
			
			J0209_1_dto dto = new J0209_1_dto(name,gender,age,money);
			
			arr.add(dto);
		}
		
		dao.getPrint(arr);
		
		//System.out.println("==========================================");
		//System.out.println("성명\t성별\t나이\t급여");
		//System.out.println("-------------------------------------------");
		//for(int k = 0 ; k < arr.size() ; k++) {
			//System.out.print(arr.get(k).getName()+"\t");
			//System.out.print(arr.get(k).getGender()+"\t");
			//System.out.print(arr.get(k).getAge()+"\t");
			//System.out.print(arr.get(k).getMoney()+"\n");
		//}
		//System.out.println("===========================================");
		
		System.out.println("성명찾기 ? ");
		String search = sc.next();	
		
		dao.getSearch(arr, search);
	}

}
