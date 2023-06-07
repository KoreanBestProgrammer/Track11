package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		J0207_4_dao dao = new J0207_4_dao();
		ArrayList<J0207_4_dto> arr = new ArrayList<>();

		System.out.print("몇 명?");
	    int count = sc.nextInt();
	    
	    for(int k = 0 ; k < count ; k++) {
	    	System.out.print("ID ? ");
	    	String id = sc.next();
	    	System.out.print("성명 ? ");
	    	String name = sc.next();
	    	System.out.print("나이 ? ");
	    	int age = sc.nextInt();
	    	System.out.print("부서 [총무 : 10, 재무 : 20, 영업 : 30] ? ");
	    	String depart = sc.next();
	    	System.out.print("직위 [사원 : s, 대리 : d, 과장 : g]? ");
	    	String rank = sc.next();
	    	
	    	depart = dao.getDepart(depart);
	    	rank = dao.getRank(rank);		
	    	
	    	J0207_4_dto dto = new J0207_4_dto(id, name, depart, rank, age);
	    	
	    	arr.add(dto);
	    	
	    }
		dao.getPrint(arr);
	    
		//System.out.println("============================================");
		//System.out.println("ID"+"\t"+"성명"+"\t"+"나이"+"\t"+"부서"+"\t"+"직위"+"\t");
		//System.out.println("---------------------------------------------");
	   // for(int k = 0 ; k < arr.size() ; k++) {
			//System.out.print("ID : "+arr.get(k).getId()+"\t");
			//System.out.print("성명 : "+arr.get(k).getName()+"\t");
			//System.out.print("나이 : "+arr.get(k).getAge()+"\t");
			//System.out.print("부서 : "+arr.get(k).getDepart()+"\t");
			//System.out.println("직위 : "+arr.get(k).getRank()+"\n");
	//}
     // System.out.println("================================================");
}
}
