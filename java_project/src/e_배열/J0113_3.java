package e_배열;

public class J0113_3 {

	public static void main(String[] args) {
		int arr[] = {12,45,14,75,86,49,12,56,45,85,23,62,45,78,95,45,26,78,64,68,54,55,85};
		
		int total=0;
		int count =0;
		int total1=0;
		
		for(int k =0; k<arr.length;k++ ) { total += arr[k]; //total = total + arr[k];
		                                   
		
		                                   if(arr[k] >= 0 && arr[k] <= 50){
		                                      count = count+1;  // count++; // count += 1;
		                                      total1 += arr[k]; //total1 = total1 + arr[k];
		                                   }	
		                                   
		                                   
		}		
		System.out.println("total : "+ total);
		System.out.println("수"+count);												        
        System.out.println("total1 : "+total1);  
           
           
           
           
	}

}
