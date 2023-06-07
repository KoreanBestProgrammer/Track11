package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0207_3_dao dao = new J0207_3_dao();
		J0207_3_dto dto = new J0207_3_dto();
		 
		System.out.println("몇 마리?");
		int count = sc.nextInt();
		
		ArrayList<J0207_3_dto> arr = new ArrayList<>();
		
		for(int k = 0 ; k < count ; k ++) {
			System.out.println("종류[고양이 : c , 강아지 : d]");
			String kind = sc.next();
			System.out.println("동물 이름 ? ");
			String name = sc.next();
			System.out.println("키 ?");
			int height = sc.nextInt();
			System.out.println("무게 ? ");
			int weight = sc.nextInt();
			
			kind = dao.getKind(kind);
			
			dto.setKind(kind);
			dto.setName(name);
			dto.setHeight(height);
		    dto.setWeight(weight);
		    
			arr.add(dto);
			
		}
        dao.getPrint(arr);
		//for(int k = 0 ; k < arr.size() ; k++) {
			//System.out.print("종류 : "+arr.get(k).getKind()+"\t");
			//System.out.print("이름 : "+arr.get(k).getName()+"\t");
			//System.out.print("키 : "+arr.get(k).getHeight()+"\t\t");
			//System.out.println("무게 : "+arr.get(k).getWeight()+"\n");
			
			
			
		}
		
		
	}


