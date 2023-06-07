package g_생성자;

public class J0125_1 {

	public static void main(String[] args) {
		J0125_sub_1 sub = new J0125_sub_1();
		
		int kor = sub.getKor();
		System.out.println("kor "+kor);
		
		sub.setKor(200);
		kor = sub.getKor();
		System.out.println("kor "+kor);
		
		sub.setName("이상화");
		String name = sub.getName();
		System.out.println(name);
						
		sub.setAve(0.5);
		double ave  = sub.getAve();
		System.out.println(ave);
			
		
		
		
		
		
		
		
		
	}

}
