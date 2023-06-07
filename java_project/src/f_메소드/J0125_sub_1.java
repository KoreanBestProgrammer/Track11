package f_메소드;

public class J0125_sub_1 {

	 int getTotal(String a, int b) {
		int result = Integer.parseInt(a)+b;
		return result;
	}

	 int getTotal(int a, String b) {
		int result = a+Integer.parseInt(b);
		return result;
	}
	
	 int getTotal(int []arr) {
		 int total = 0;
		 for(int k = 0 ; k < arr.length ; k++) {
			 total = total + arr[k];
		 }
		 return total;
	 }
	
	 int[] getTotal(int a, int b) {
		 int[] result = new int[2];
		 int total = a+b;
		 int ave = total/2;
		 result[0] = total;
		 result[1] = ave;
		 
		 return result;
	 }
	 
	    String[] getTotal(int a,int b,int c) {
	    	String[] result = new String[2];
	    	int total = a+b+c;
	    	int ave = total/3;
	    	result[0] = Integer.toString(total);
	    	result[1] = Integer.toString(ave);
	    	return result;
	    	
	    }
	   
	    int getTotal(int[] a, String[] b) {
	    	int total = 0;
	    	for(int k = 0 ; k < a.length ; k++) {
	    		total = total+a[k];
	    	}
	    	int total_1 = 0;
	    	for(int k = 0 ; k <b.length ; k++) {
	    		total_1 = total_1+Integer.parseInt(b[k]);
	    	}
	    	int result = total + total_1;	    	
	    	return  result;	    		    
	    }
	     
	    	
	    
	    
	    
	    
	    	
	    }
	
	
	


