package f_메소드;

public class J0125_1 {

	public static void main(String[] args) {
		J0125_sub_1 sub = new J0125_sub_1();
		
		int total = sub.getTotal("10", 20);
		System.out.println("total : "+total);
		
		total = sub.getTotal(30,"40");
		System.out.println("total : "+total);
		
		int[] arr = {10,20,30};
		
		total = sub.getTotal(arr);
		System.out.println("total : "+total);
		
		int[] point = sub.getTotal(100,200);
		for(int k = 0 ; k < point.length ; k++) {
			System.out.println(point[k]);
		}
		// point[0] : 300
		// point[1] : 150
		
		String[] result = sub.getTotal(10, 20, 30); 
		for(int k = 0 ; k < result.length ; k++) {
			System.out.println(result[k]);
		}
		
		total = sub.getTotal(point, result);
		System.out.println("total : "+total);
		
	}	

	}


