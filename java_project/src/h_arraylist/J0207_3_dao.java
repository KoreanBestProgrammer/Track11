package h_arraylist;

import java.util.ArrayList;

public class J0207_3_dao {

	String getKind(String a) {
		String result = "";
		if(a.equals("c")) result = "고양이";
		else if(a.equals("d")) result = "강아지";
		
		return result;
		
	}

	
	void getPrint(ArrayList<J0207_3_dto> arr ) {
		for(int k = 0 ; k < arr.size() ; k++) {
			System.out.print("종류 : "+arr.get(k).getKind()+"\t");
			System.out.print("이름 : "+arr.get(k).getName()+"\t");
			System.out.print("키 : "+arr.get(k).getHeight()+"\t\t");
			System.out.println("무게 : "+arr.get(k).getWeight()+"\n");
		}				
	}
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

