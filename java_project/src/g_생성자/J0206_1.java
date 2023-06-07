package g_생성자;

import java.util.Scanner;

public class J0206_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0206_dao_member dao = new J0206_dao_member();
		
		
		System.out.print("몇 명 ?");
		int count = sc.nextInt();
		
	    J0206_dto_member arr[] = new J0206_dto_member[count];
		
	    for(int k = 0 ; k < arr.length ; k++) {
	    	System.out.print("id ? ");
	    	String id = sc.next();
	    	System.out.print("name ? ");
	    	String name = sc.next();
	    	System.out.print("height ? ");
	    	double height = sc.nextDouble();
	    	System.out.print("weight ? ");
	    	double weight = sc.nextDouble();
	    	
	    	String result = dao.getResult(height, weight);
	    	
	    	J0206_dto_member dto = new J0206_dto_member(id, name, height, weight, result);
	    	
	    	arr[k] = dto;
	    }
	    
		dao.getPrint(arr);		
		System.out.println("성명찾기 ? ");
		String search = sc.next();
		dao.getSearch(arr, search);
	   // for(int k = 0 ; k < arr.length ; k++) {
	    	//System.out.println("id : "+arr[k].getId());
	    	//System.out.println("name : "+arr[k].getName());
	    	//System.out.println("height : "+arr[k].getHeight());
	    	//System.out.println("weight : "+arr[k].getWeight());
	    	//System.out.println("result : "+arr[k].getResult());
	    }

	
	}


