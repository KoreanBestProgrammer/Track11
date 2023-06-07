package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ArrayList<J0207_1_dto> dtos = new ArrayList<>();
        
        System.out.println("몇 명 ? ");
		int count = sc.nextInt();
		
		for(int k = 0 ; k < count ; k++) {
			System.out.println("id ? ");
			String id = sc.next();
			System.out.println("성명 ? ");
			String name = sc.next();
			System.out.println("지역 ? ");
			String area = sc.next();
			System.out.println("나이 ? ");
			int age = sc.nextInt();
			
			J0207_1_dto dto = new J0207_1_dto(id,name,area,age);
			
			dtos.add(dto);
			
		}

		for(int k = 0 ; k < dtos.size() ; k++) {
			System.out.print(dtos.get(k).getId());
			System.out.print(dtos.get(k).getName());
			System.out.print(dtos.get(k).getArea());
			System.out.println(dtos.get(k).getAge());
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
