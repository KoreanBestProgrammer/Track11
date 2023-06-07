package f_메소드;

public class J0120_2 {

	public static void main(String[] args) {
		J0120_sub_2 sub = new J0120_sub_2();
		
		int total_1 = sub.getTotal(10, 20, 30);
		System.out.println(total_1);
		int total_2 = sub.getTotal(10, 20, "30");
		int total_3 = sub.getTotal(10, "20", "30");
		int total_4 = sub.getTotal(10, "20");
		
		
		
		
				

	}

}
