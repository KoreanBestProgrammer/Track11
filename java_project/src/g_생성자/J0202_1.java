package g_생성자;

import java.util.Scanner;

public class J0202_1 {

	public static void main(String[] args) {								
		Scanner sc = new Scanner(System.in);
		
		J0202_1_dao dao = new J0202_1_dao();
		
		System.out.println("몇 명 ?");
		int count = sc.nextInt();
		
		J0202_1_dto arr[] = new J0202_1_dto[count];
		
		for(int k =0 ; k <arr.length ; k++) {
		System.out.println("사번 ? ");
		String sabun = sc.next();
		System.out.println("이름 ? "  );
		String name = sc.next();
		System.out.println("부서[총무:c, 재무:j, 영업:y] ?");
		String depart = sc.next();
		System.out.println("직위[사원:10, 대리:20, 과장:30] ?");
		String rank = sc.next();		
		
		depart = dao.getDepartName(depart); //F3누르면 알아서 찾아감
		rank = dao.getRankName(rank);
		
		int salary = dao.getSalary(depart,rank);
		
		J0202_1_dto dto = new J0202_1_dto(sabun,name,depart,rank,salary);
		
		arr[k] = dto;
		
		//System.out.println("사번 : "+dto.getSabun());
		//System.out.println("이름 : "+dto.getName());
		//System.out.println("부서 : "+dto.getDepart());
		//System.out.println("직위 : "+dto.getRank());
		
	}
		
		dao.getPrint(arr);
		//for(int k =0 ; k <arr.length ; k++) {
			//System.out.println("사번 : "+arr[k].getSabun());
			//System.out.println("이름 : "+arr[k].getName());
			//System.out.println("부서 : "+arr[k].getDepart());
			//System.out.println("직위 : "+arr[k].getRank());
			//System.out.println("급여 : "+arr[k].getSalary());
		
		System.out.println("===========================================");
		System.out.println("성명 검색 ? ");
		String search = sc.next();
		dao.searchData(arr, search);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
       }
    }
 