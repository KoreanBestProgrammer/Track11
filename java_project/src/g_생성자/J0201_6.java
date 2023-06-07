package g_생성자;

import java.util.Scanner;

public class J0201_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		J0201_student stu[] = new J0201_student[2];
		
		for(int k = 0 ; k < stu.length ; k ++) {
			System.out.println("이름 ? ");
			String name = sc.next();
			System.out.println("아이디 ? ");
			String id = sc.next();
			
			J0201_student dto = new J0201_student(id,name);
			
			
			
			stu[k] = dto;
			
			
		}
		
        for(int k = 0 ; k < stu.length ; k ++) {
        	System.out.println(stu[k].getName());
        	System.out.println(stu[k].getId());
        }
	}

}
