package g_생성자;

import java.util.Scanner;

public class J0201_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0201_1_dto dto = new J0201_1_dto();
		J0201_1_dao dao = new J0201_1_dao();
		
		System.out.println("이름 ? ");
		String name = sc.next();
		System.out.println("나이 ? ");
		int age = sc.nextInt();
		System.out.println("지역 ? (서울:s, 대전:d, 청주:c, 부산:b) ");
		String area = sc.next();
		System.out.println("학력 ? (중졸:m, 고졸:h, 대졸:u) ");
		String edu = sc.next();
		
		area = dao.getArea(area);
		edu = dao.getEdu(edu);
		
		J0201_1_dto dto_2 = new J0201_1_dto(name, area, edu, age);
		System.out.println("성명 : "+dto_2.getName());
		System.out.println("지역 : "+dto_2.getArea());
		System.out.println("학력 : "+dto_2.getEdu());
		System.out.println("나이 : "+dto_2.getAge());

		
		

	}

}
