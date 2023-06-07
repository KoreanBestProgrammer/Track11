package g_생성자;

import java.util.Scanner;

public class J0203_1 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		J0203_1_dao dao = new J0203_1_dao();
		
		System.out.println("몇 명 ? ");
		int count = sc.nextInt();
		
		J0203_1_dto arr[] = new J0203_1_dto[count];
		
		for(int k = 0 ; k < arr.length ; k++) {
		
			System.out.println("성명 ? ");
			String name = sc.next();
			System.out.println("성별 ? [남 : m, 여 : f]");
			String gender = sc.next();
			System.out.println("나이 ? ");
			int age = sc.nextInt();
										
			gender = dao.getGender(gender);			
			int money = dao.getMoney(gender, age);
	
			J0203_1_dto dto = new J0203_1_dto(name,gender,age,money);
	
			arr[k] = dto;
		}
		
			dao.getPrint(arr);
		
			//for(int k = 0 ; k < arr.length ; k++) {
			//System.out.println("성명 : "+arr[k].getName());
			//System.out.println("성별 : "+arr[k].getGender());
			// System.out.println("나이 : "+arr[k].getAge());
			// System.out.println("용돈 : "+arr[k].getMoney());
			//}
			System.out.println("성명 찾기 ? ");
			String search = sc.next();
			dao.getSearch(arr, search);
   
	}

}
