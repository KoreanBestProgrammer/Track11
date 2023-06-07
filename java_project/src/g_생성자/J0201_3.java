package g_생성자;

import java.util.Scanner;

public class J0201_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        J0201_1_dto[]arr = new J0201_1_dto[2];
        J0201_1_dao dao = new J0201_1_dao();
        
        for(int k = 0 ; k < arr.length ; k ++) {
        	System.out.println("성명 ? ");
            String name = sc.next();
            System.out.println("나이 ? ");
            int age = sc.nextInt();
            System.out.println("지역 ? ");
            String area = sc.next();
            System.out.println("학력 ? ");
            String edu = sc.next();
            
            J0201_1_dto dto = new J0201_1_dto(name,area,edu,age);
            arr[k] = dto;
        }
        
        dao.dtoPrint(arr);
        
        
        
        }
        
        
        
 	


}

