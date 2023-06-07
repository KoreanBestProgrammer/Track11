package g_생성자;

public class J0203_김용석_dao {

	int getAve(int kor, int eng, int mat) {
		int ave = (kor+eng+mat)/3;
		return ave;				
	}
	
	String getResult(int ave) {
		String result = "";
		if(ave>= 0 && ave <= 100) {
		if(ave >= 80) result = "합격";
		else if(ave < 80) result = "불합격";
		}
		else result = "평균입력오류";
		return result;
	}
	
	void getPrint(J0203_김용석_dto arr[]) {
		for(int k = 0 ; k < arr.length ; k++) {											
			System.out.print(arr[k].getName()+"\t");
			System.out.print(arr[k].getKor()+"\t");
			System.out.print(arr[k].getEng()+"\t");
			System.out.print(arr[k].getMat()+"\t");
			System.out.print(arr[k].getAve()+"\t");
			System.out.print(arr[k].getResult()+"\n");						
		}
	}
	void getSearch(J0203_김용석_dto a[], String search) {	 
		for(int k = 0 ; k < a.length ; k++) {	
			if(a[k].getName().indexOf(search) != -1) {
			System.out.print(a[k].getName()+"\t");
			System.out.print(a[k].getKor()+"\t");
			System.out.print(a[k].getEng()+"\t");
			System.out.print(a[k].getMat()+"\t");
			System.out.print(a[k].getAve()+"\t");
			System.out.print(a[k].getResult()+"\n");						
		}
		}
		
		}
		
		
		
		
		
		
		
		
		
		
	
	
		}
	
