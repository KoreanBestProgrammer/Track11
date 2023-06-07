package f_메소드;

public class J0120_4 {

	public static void main(String[] args) {
		J0120_sub_4 sub = new J0120_sub_4();
		
		String names[] =  
				sub.getNames("2", "2", "2", "2");
        for(int k = 0 ; k < names.length ; k++) {
        	System.out.println(names[k]);
        }
	}

}
