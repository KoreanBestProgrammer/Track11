package g_생성자;

public class J0201_1_dao {
	
	void dtoPrint(J0201_1_dto[] arr) {
		for(int k = 0 ; k < arr.length ; k++) {
		System.out.println("성명 : "+arr[k].getName());
		System.out.println("지역 : "+arr[k].getArea());
		System.out.println("학력 : "+arr[k].getEdu());
		System.out.println("나이 : "+arr[k].getAge());		
	}}
	
	
	
	
	
	
	

	String getArea(String area) {
		String result ="";
		if(area.equals("s")) result = "서울";
		else if(area.equals("d")) result = "대전";
		else if(area.equals("c")) result = "청주";
		else if(area.equals("b")) result = "부산";
		else result = "지역없음";
		return result;								
	}
	
	String getEdu(String edu) {
		String result = "";
		if(edu.equals("m")) result = "중졸";
		else if(edu.equals("h")) result = "고졸";
		else if(edu.equals("u")) result = "대졸";
		else result = "학력없음";
		return result;						
	}
	
	
	}
	
	
	

	

