package g_생성자;

public class J0206_dao_member {
	

    String getResult(double h, double w) {
	String result = "";
	
	if(w <= (h-100)*0.9) result = "정상";
	else if(w > (h-100)*0.9) result = "비정상";
	
	return result;
	}
	
	void getPrint(J0206_dto_member a[]) {
		System.out.println("===================================");
		System.out.println("id\t성명\t키\t몸무게\t결과");
		System.out.println("-----------------------------------");
		  for(int k = 0 ; k < a.length ; k++) {
		    	System.out.print(a[k].getId()+"\t");
		    	System.out.print(a[k].getName()+"\t");
		    	System.out.print(a[k].getHeight()+"\t");
		    	System.out.print(a[k].getWeight()+"\t");
		    	System.out.print(a[k].getResult()+"\n");							
		  }
		  System.out.println("-----------------------------------");
		 
	}
	void getSearch(J0206_dto_member a[], String search) {
	System.out.println("===================================");
	System.out.println("id\t성명\t키\t몸무게\t결과");
	System.out.println("-----------------------------------");
	  for(int k = 0 ; k < a.length ; k++) {
		  if(a[k].getName().indexOf(search) != -1) {
	    	System.out.print(a[k].getId()+"\t");
	    	System.out.print(a[k].getName()+"\t");
	    	System.out.print(a[k].getHeight()+"\t");
	    	System.out.print(a[k].getWeight()+"\t");
	    	System.out.print(a[k].getResult()+"\n");
		  }
	  }
	       System.out.println("-----------------------------------");

	  
	}
}