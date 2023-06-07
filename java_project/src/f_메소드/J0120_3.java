package f_메소드;

public class J0120_3 {

	public static void main(String[] args) {
		J0120_sub_3 sub = new J0120_sub_3();
		
	     int score[] = {10,20,30,40};
	     
	     int total = sub.getTotal(score);
	     System.out.println(total);
	     
	     int ave = sub.getAve(score, 3);
	     System.out.println(ave);
	     
	     int ave_2 = sub.getAve(score);
	     System.out.println(ave_2);

	}

}
