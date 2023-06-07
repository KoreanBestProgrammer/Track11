package i_string;

public class J0208_1 {

	public static void main(String[] args) {
		int a = 10;
		String str = "가나다라마바";
		int len = str.length();
		System.out.println(str.length());
		
		System.out.println(str.substring(2));
		
		System.out.println(str.substring(2, 4));
		
		int position = str.indexOf("가");
		System.out.println(position);
		 if(position != -1) {
			String c = str.substring(position, position+3);
			System.out.println(c);						
		 }
		
		 if(len > 3) {
			 String d = str.substring(0, 3);
			 d = d+"...";
			 System.out.println(d);
		 }
		
		
		
		
		
		
	}

}
