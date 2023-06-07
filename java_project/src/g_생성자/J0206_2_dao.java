package g_생성자;

public class J0206_2_dao {
	double getAve(int k, int e, int m) {
	
		double total = (k+e+m);
		double ave = total/3.0;
		ave = Math.round(ave*100)/100.0;
	
		return ave;			
	}
	
   String getResult(double a, int k, int e, int m) {
	   String result = "";	   
	   	   
	   if(a >= 80 && k >=60 && e >= 60 && m >= 60) result = "합격";	 
	   else result = "불합격";
	   	   	   
	   return result;
	   
   }

   void getPrint(J0206_2_dto a[]) {
	   System.out.println("==================================================");
		System.out.println("id\t성명\t국어\t영어\t수학\t평균\t결과");
		System.out.println("-------------------------------------------------");
	   for(int k = 0 ; k < a.length ; k++) {	
	   System.out.print(a[k].getId()+"\t");
	   System.out.print(a[k].getName()+"\t");
	   System.out.print(a[k].getKor()+"\t");
	   System.out.print(a[k].getEng()+"\t");
	   System.out.print(a[k].getMat()+"\t");
	   System.out.print(a[k].getAve()+"\t");
	   System.out.print(a[k].getResult()+"\n");
	   
	   }	   
	   System.out.println("--------------------------------------------------");
   }
   
}
