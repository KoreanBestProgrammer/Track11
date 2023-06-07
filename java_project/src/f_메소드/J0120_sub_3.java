package f_메소드;

public class J0120_sub_3 {
	
	
	int getTotal(int a[]) {
		int total = 0;
		for(int k = 0 ; k < a.length ; k++) {
			total = total+a[k];
		}		
		return total;
	}
    
	int getAve(int a[], int b) {
		int total = 0;
		for(int k = 0 ; k < a.length ; k++) {
			total = total + a[k];
		}
		total = total/b;
		return total;
	}
    
	int getAve(int a[]) {
		int total = 0; 
		for(int k = 0 ; k < a.length ; k++) {
			total = total + a[k];			
		}
		return total/a.length;
	}
	
	
}
