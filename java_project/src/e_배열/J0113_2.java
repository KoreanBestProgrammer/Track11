package e_배열;

public class J0113_2 {

	public static void main(String[] args) {
		
		int aa[] = {10,20,30,40};
		
		String bb[] = {"가가가","나나나","다다다"};
		
		int total;
		total =0;
		
		for(int k =0; k<aa.length;k++) {total = total+aa[k];		                               	                              
		                                System.out.println(aa[k]);
		}
		System.out.println("total : "+total);
		System.out.println("===============");
		
		
		
		for(int k =0;k<aa.length;k++) {System.out.println(aa[k] += 100 );}
			
		
		
		

	}

}
