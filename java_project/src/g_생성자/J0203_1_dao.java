package g_생성자;

public class J0203_1_dao {
  
  String getGender(String gender) {
	  	String result = "";
	  if(gender.equals("m")) result = "남자";
	  else if(gender.equals("f")) result = "여자";
	  else result = "성별입력오류";
	  return result;	  
  	}
  
	int getMoney(String gender, int age) {
		int result = 0;
		int aa = 0;
		if(gender.equals("남자")) {
			result = 100000; 
			aa++;
		}
		else if(gender.equals("여자")) {
			result = 120000; 
			aa++;
		}
		
		if(0 <= age && 20 >= age ) {
			result = result + 30000;
			aa++;
		}
		else if(20 <= age && 25 >= age) {
			result = result + 50000;
			aa++;
		}
		else if(25 < age) {
			result = result + 100000;
			aa++;
		}
		
		if(aa !=2) result = 0; 
		
		return result;
		
	}
	
	void getPrint(J0203_1_dto arr[]) {
		for(int k = 0 ; k < arr.length ; k++) {
			System.out.println("성명 : "+arr[k].getName());
			System.out.println("성별 : "+arr[k].getGender());
            System.out.println("나이 : "+arr[k].getAge());
            System.out.println("용돈 : "+arr[k].getMoney());
		}
	}
		void getSearch(J0203_1_dto aa[], String search) {
			for(int k = 0 ; k < aa.length ; k++) {
				
				if(aa[k].getName().indexOf(search) != -1) {
				
				System.out.println("성명 : "+aa[k].getName());
				System.out.println("성별 : "+aa[k].getGender());
	            System.out.println("나이 : "+aa[k].getAge());
	            System.out.println("용돈 : "+aa[k].getMoney());
				}
			}
			
		}
		
	}
  
	

