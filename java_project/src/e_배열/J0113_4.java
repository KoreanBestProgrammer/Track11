package e_배열;

public class J0113_4 {

	public static void main(String[] args) {

		int arr[] = {112,435,124,755,866,439,112,536,445,857,263,622,
				     425,378,495,745,926,378,464,568,594,555,855,454,
				     874,512,125,545,118,564};
        int total=0;
		int total1=0;
		int count=0;
		
		for(int k=0;k<arr.length;k++) { 
			   total = total + arr[k];		
		    if(arr[k]%2 == 0){ 
		    	count ++;
		    }else { 
		    	total1 += arr[k];
		    }		   
		}
		System.out.println("홀수 총합 : "+total1);
		System.out.println("짝수 개수 : "+count);
		System.out.println("총합 : "+total);
		
	} 

}
