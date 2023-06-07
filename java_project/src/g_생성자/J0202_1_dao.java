package g_생성자;

public class J0202_1_dao {

	
	String getDepartName(String code) {
		String result = "";
		if(code.equals("c")) result = "총무";
		else if(code.equals("j")) result = "재무";
		else if(code.equals("y")) result = "영업";
		else result = "부서입력오류";
		
		return result;
	}
	String getRankName(String rank) {
		String result = "";
		if(rank.equals("10")) result = "사원";
		else if(rank.equals("20")) result = "대리";
		else if(rank.equals("30")) result = "과장";
		else result = "직위입력오류";
		
		return result;
		
	}
	
	int getSalary(String depart, String rank) {
		int result = 0;
				
		if(depart.equals("총무")) result = 1000000;
		else if(depart.equals("재무")) result = 900000;
		else if(depart.equals("영업")) result = 1200000;
				
		if(rank.equals("사원")) result = result + 200000;
		else if(rank.equals("대리")) result = result + 300000;
		else if(rank.equals("과장")) result = result + 400000;
		
		
		if(depart.equals("부서입력오류") || rank.equals("직위입력오류")) result = 0;
		
		return result;
 	}
	
	void getPrint(J0202_1_dto arr[]) {
		for(int k =0 ; k <arr.length ; k++) {
		System.out.println("사번 : "+arr[k].getSabun());
		System.out.println("이름 : "+arr[k].getName());
		System.out.println("부서 : "+arr[k].getDepart());
		System.out.println("직위 : "+arr[k].getRank());
		System.out.println("급여 : "+arr[k].getSalary());
   }
	}
	
		void searchData(J0202_1_dto arr[], String search) {
									
			for(int k =0 ; k <arr.length ; k++) {
			    if(arr[k].getName().indexOf(search) != -1) {                         
			    System.out.println("사번 : "+arr[k].getSabun());
				System.out.println("이름 : "+arr[k].getName());
				System.out.println("부서 : "+arr[k].getDepart());
				System.out.println("직위 : "+arr[k].getRank());
				System.out.println("급여 : "+arr[k].getSalary());
				}						
			}
		
		
		
		
		}
	
	
}
